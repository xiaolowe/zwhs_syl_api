package cn.org.citycloud.zwhs.syl.controller;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.org.citycloud.zwhs.syl.constants.ErrorCodes;
import cn.org.citycloud.zwhs.syl.entity.StorePay;
import cn.org.citycloud.zwhs.syl.entity.WechatMember;
import cn.org.citycloud.zwhs.syl.exception.BusinessErrorException;
import cn.org.citycloud.zwhs.syl.service.StorePayService;
import cn.org.citycloud.zwhs.syl.utils.ExcelUtil;


@Controller
@RequestMapping("storepay")
public class StorePayController {
	
	@Autowired
	private StorePayService storePayService;
	
	
	/**
	 * 获取收入款项列表
	 * 列表
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody()
	public Object getGoods(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
	        @RequestParam(value = "pageSize", defaultValue = "10")  Integer pageSize,
	        @RequestParam(value = "start_time", required = false)  String startTime,
	        @RequestParam(value = "end_time", required = false)  String endTime,
	        @RequestParam(value = "pay_id", required = false)  Integer payId,
	        @RequestParam(value = "pay_member_name", required = false)  String payMemberName,
	        @RequestParam(value = "company_name", required = false)  String companyName,
	        @RequestParam(value = "pay_state", required = false)  Integer payState ) throws Exception, RuntimeException {
		
		Sort sort = new Sort(Direction.DESC, "payId");
	    Pageable pageable = new PageRequest(pageNo - 1, pageSize, sort);
	    
	    StorePay storePay = new StorePay();
	    storePay.setPayId(payId);
	    
	    WechatMember wechatMember = new WechatMember();
	    wechatMember.setWechatAliasname(payMemberName);
	    storePay.setWechatMember(wechatMember);
	    
	    storePay.setCompanyName(companyName);
	    storePay.setPayState(payState);
	    
	    Page<StorePay> list = storePayService.getStorePayPage(pageable, storePay, startTime, endTime);
	    
		return list;
	}
	
	/**
	 * 获取收入款项详情
	 * @return
	 */
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	@ResponseBody()
	public Object detailStorePay(
			@RequestParam(value = "pay_id") Integer payId) throws Exception, RuntimeException {

		if(payId == null){
			
			throw new BusinessErrorException(ErrorCodes.PARAM_ERROR, "参数为空");
			
		}
		StorePay storePay = storePayService.getStorePayByPayId(payId);
		return storePay;
	}
	
	/**
	 * 导出报表
	 */
	@RequestMapping(value="downloadExcel", method = RequestMethod.GET)
    public String download(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
	        @RequestParam(value = "pageSize", defaultValue = "10")  Integer pageSize,
	        @RequestParam(value = "start_time", required = false)  String startTime,
	        @RequestParam(value = "end_time", required = false)  String endTime,
	        @RequestParam(value = "pay_id", required = false)  Integer payId,
	        @RequestParam(value = "pay_member_name", required = false)  String payMemberName,
	        @RequestParam(value = "company_name", required = false)  String companyName,
	        @RequestParam(value = "pay_state", required = false)  Integer payState,
    		HttpServletRequest request,HttpServletResponse response) throws Exception, RuntimeException, IOException{
      
		 	StorePay storePay = new StorePay();
		    storePay.setPayId(payId);
		    
		    WechatMember wechatMember = new WechatMember();
		    wechatMember.setWechatAliasname(payMemberName);
		    storePay.setWechatMember(wechatMember);
		    
		    storePay.setCompanyName(companyName);
		    storePay.setPayState(payState);
		    
		    List<StorePay> listExcel = storePayService.getStorePayList(storePay, startTime, endTime);
	    
		String fileName="财务管理（收入款项）";
        //填充实体类实体数据
		List<StorePay> projects= listExcel;
        List<Map<String,Object>> list=createExcelRecord(projects);
        String columnNames[]={"支付单号","生成时间","支付人","收款单位","应收金额"};//列名
        String keys[]    =     {"payId","payTime","payMemberName","companyName","payMoney"};//map中的key
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            ExcelUtil.createWorkBook(list,keys,columnNames).write(os);
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] content = os.toByteArray();
        InputStream is = new ByteArrayInputStream(content);
        // 设置response参数，可以打开下载页面
        response.reset();
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename="+ new String((fileName + ".xls").getBytes(), "iso-8859-1"));
        ServletOutputStream out = response.getOutputStream();
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(is);
            bos = new BufferedOutputStream(out);
            byte[] buff = new byte[2048];
            int bytesRead;
            // Simple read/write loop.
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }
        } catch (final IOException e) {
            throw e;
        } finally {
            if (bis != null)
                bis.close();
            if (bos != null)
                bos.close();
        }
        return null;
    }
	
    private List<Map<String, Object>> createExcelRecord(List<StorePay> projects) {
        List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("sheetName", "sheet1");
        listmap.add(map);
        StorePay project=null;
        for (int j = 0; j < projects.size(); j++) {
            project=projects.get(j);
            Map<String, Object> mapValue = new HashMap<String, Object>();
	            mapValue.put("payId", project.getPayId());
	            mapValue.put("payTime", project.getPayTime());
	            mapValue.put("payMemberName", project.getWechatMember().getWechatAliasname());
	            mapValue.put("companyName", project.getCompanyName());
	            mapValue.put("payMoney", project.getPayMoney());
            listmap.add(mapValue);
        }
        return listmap;
    
    }
	
}
