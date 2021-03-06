package cn.org.citycloud.zwhs.syl.controller;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.auth0.jwt.internal.com.fasterxml.jackson.databind.deser.Deserializers.Base;

import cn.org.citycloud.zwhs.syl.constants.ErrorCodes;
import cn.org.citycloud.zwhs.syl.core.BaseController;
import cn.org.citycloud.zwhs.syl.entity.CashRecoder;
import cn.org.citycloud.zwhs.syl.exception.BusinessErrorException;
import cn.org.citycloud.zwhs.syl.service.CashRecoderService;
import cn.org.citycloud.zwhs.syl.utils.ExcelUtil;


@Controller
@RequestMapping("cashrecoder")
public class CashRecoderController extends BaseController{
	
	@Autowired
	private CashRecoderService cashRecoderService;
	
	
	
	/**
	 * 获取列表
	 * 列表
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody()
	public Object getGoods(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
	        @RequestParam(value = "pageSize", defaultValue = "10")  Integer pageSize,
	        @RequestParam(value = "start_time", required = false)  String startTime,
	        @RequestParam(value = "end_time", required = false)  String endTime,
	        @RequestParam(value = "cash_no", required = false)  Integer cashNo,
	        @RequestParam(value = "company_name", required = false)  String companyName,
	        @RequestParam(value = "confirm_stat", required = false)  Integer confirmStat,
	        @RequestParam(value = "acc_type", required = false)  Integer accType) throws Exception, RuntimeException {

		
		Sort sort = new Sort(Direction.DESC, "cashNo");
	    Pageable pageable = new PageRequest(pageNo - 1, pageSize, sort);
	    
	    CashRecoder cashRecoder = new CashRecoder();
	    cashRecoder.setCashNo(cashNo);
	    cashRecoder.setCompanyName(companyName);
	    cashRecoder.setConfirmStat(confirmStat);
	    cashRecoder.setAccType(accType);
	    
	    Page<CashRecoder> list = cashRecoderService.getCashRecoderPage(pageable, cashRecoder, startTime, endTime);
		return list;
	}
	
	/**
	 * 查看财务支出详情
	 * @return
	 */
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	@ResponseBody()
	public Object detailGoods(
			@RequestParam(value = "cash_no") Integer cashNo) throws Exception, RuntimeException {

		if(cashNo == null){
			
			throw new BusinessErrorException(ErrorCodes.PARAM_ERROR, "参数为空");
			
		}
		CashRecoder cashRecoder = cashRecoderService.getCashRecoder(cashNo);
		
		return cashRecoder;
	}
	
	/**
	 * 财务管理（支出款项）
	 * 审核通过
	 * @return
	 */
	@RequestMapping(value = "/check/{cashNo}", method = RequestMethod.PUT)
	@ResponseBody()
	public Object checkCashRecoder(@PathVariable Integer cashNo,
			@RequestBody Map<String, Object> params,
			HttpServletRequest request,HttpServletResponse response) throws Exception, RuntimeException {

		Integer confirmStat = (Integer)params.get("confirm_stat");
		String confirmUserName = getUserName();
		
		if(cashNo == null || confirmStat == null ){
			
			throw new BusinessErrorException(ErrorCodes.PARAM_ERROR, "参数为空");
			
		}
		Date now = new Date();
		CashRecoder cashRecoder = new CashRecoder();
		cashRecoder.setConfirmStat(confirmStat);
		cashRecoder.setConfirmUserName(confirmUserName);
		cashRecoder.setConfirmTime(now);
		cashRecoder.setUpdDate(now);
		
		
		return cashRecoderService.modifyCashRecoderByState(cashNo, cashRecoder);
		
	}
	
	/**
	 * 财务管理（支出款项）
	 * (驳回)
	 * @return
	 */
	@RequestMapping(value = "/reject/{cashNo}", method = RequestMethod.PUT)
	@ResponseBody()
	public Object rejectCashRecoder(@PathVariable Integer cashNo,
			@RequestBody Map<String, Object> params,
			HttpServletRequest request,HttpServletResponse response) throws Exception, RuntimeException {

		Integer confirmStat = (Integer)params.get("confirm_stat");
		
		String confirmUserName = getUserName();
		
		if(cashNo == null || confirmStat == null ){
			
			throw new BusinessErrorException(ErrorCodes.PARAM_ERROR, "参数为空");
			
		}
		Date now = new Date();
		CashRecoder cashRecoder = new CashRecoder();
		cashRecoder.setConfirmStat(confirmStat);
		cashRecoder.setConfirmUserName(confirmUserName);
		cashRecoder.setConfirmTime(now);
		cashRecoder.setUpdDate(now);
		
		
		return cashRecoderService.modifyCashRecoderRejectByState(cashNo, cashRecoder);
		
	}
	
	/**
	 * 确认打款
	 * @return
	 */
	@RequestMapping(value = "/paymoney/{cashNo}", method = RequestMethod.PUT)
	@ResponseBody()
	public Object checkPaymoney(@PathVariable Integer cashNo,
			@RequestBody Map<String, Object> params,
			HttpServletRequest request,HttpServletResponse response) throws Exception, RuntimeException {

		Integer confirmStat = (Integer)params.get("confirm_stat");
		String payingCertificate = (String)params.get("paying_certificate");
		
		String payingUserName = getUserName();
		
		if(cashNo == null || confirmStat == null
			 || payingCertificate == null){
			
			throw new BusinessErrorException(ErrorCodes.PARAM_ERROR, "参数为空");
			
		}
		Date now = new Date();
		CashRecoder cashRecoder = new CashRecoder();
		cashRecoder.setConfirmStat(confirmStat);
		cashRecoder.setPayingUserName(payingUserName);
		cashRecoder.setPayingTime(now);
		cashRecoder.setPayingCertificate(payingCertificate);
		cashRecoder.setUpdDate(now);
		
		
		return cashRecoderService.payMoneyCashRecoderByState(cashNo, cashRecoder);
		
	}
	
	
	/**
	 * 导出报表
	 */
	@RequestMapping(value="downloadExcel", method = RequestMethod.GET)
    public String download(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
	        @RequestParam(value = "pageSize", defaultValue = "10")  Integer pageSize,
	        @RequestParam(value = "start_time", required = false)  String startTime,
	        @RequestParam(value = "end_time", required = false)  String endTime,
	        @RequestParam(value = "cash_no", required = false)  Integer cashNo,
	        @RequestParam(value = "company_name", required = false)  String companyName,
	        @RequestParam(value = "confirm_stat", required = false)  Integer confirmStat,
    		HttpServletRequest request,HttpServletResponse response) throws Exception, RuntimeException, IOException{
      
			CashRecoder cashRecoder = new CashRecoder();
		    cashRecoder.setCashNo(cashNo);
		    cashRecoder.setCompanyName(companyName);
		    cashRecoder.setConfirmStat(confirmStat);
		    
		    List<CashRecoder> listExcel = cashRecoderService.getCashRecoderList(cashRecoder, startTime, endTime);
	    
		String fileName="财务管理（支出款项）";
        //填充实体类实体数据
		List<CashRecoder> projects= listExcel;
        List<Map<String,Object>> list=createExcelRecord(projects);
        String columnNames[]={"支付单号","申请时间","申请人","申请单位","申请金额"};//列名
        String keys[]    =     {"cashNo","applyTime","applyUserName","companyName","applyMoney"};//map中的key
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
	
    private List<Map<String, Object>> createExcelRecord(List<CashRecoder> projects) {
        List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("sheetName", "sheet1");
        listmap.add(map);
        CashRecoder project=null;
        for (int j = 0; j < projects.size(); j++) {
            project=projects.get(j);
            Map<String, Object> mapValue = new HashMap<String, Object>();
	            mapValue.put("cashNo", project.getCashNo());
	            mapValue.put("applyTime", project.getApplyTime());
	            mapValue.put("applyUserName", project.getApplyUserName());
	            mapValue.put("companyName", project.getCompanyName());
	            mapValue.put("applyMoney", project.getApplyMoney());
            listmap.add(mapValue);
        }
        return listmap;
    
    }
	
}
