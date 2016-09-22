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
import javax.validation.Valid;

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

import cn.org.citycloud.zwhs.syl.bean.StoreServiceOrderSearchBean;
import cn.org.citycloud.zwhs.syl.constants.ErrorCodes;
import cn.org.citycloud.zwhs.syl.entity.ServiceInfo;
import cn.org.citycloud.zwhs.syl.entity.StoreServiceOrder;
import cn.org.citycloud.zwhs.syl.exception.BusinessErrorException;
import cn.org.citycloud.zwhs.syl.service.StoreServiceOrderService;
import cn.org.citycloud.zwhs.syl.utils.ExcelUtil;


@Controller
@RequestMapping("serviceorder")
public class StoreServiceOrderController {
	
	@Autowired
	private StoreServiceOrderService storeServiceOrderService;
	
	
	/**
	 * 获取服务订单列表
	 * 列表
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody()
	public Object getServiceOrder(@Valid StoreServiceOrderSearchBean bean) throws Exception, RuntimeException {

		
		Sort sort = new Sort(Direction.DESC, "orderId");
 	    Pageable pageable = new PageRequest(bean.getPageNo() - 1, bean.getPageSize(), sort);
	    
	    StoreServiceOrder serviceOrder = new StoreServiceOrder(bean.getOrder_id(), bean.getMember_truename(),
	    		bean.getOrder_status(), bean.getService_type());
	    ServiceInfo serviceInfo = new ServiceInfo();
	    serviceInfo.setServiceName(bean.getService_name());
	    serviceOrder.setServiceInfo(serviceInfo);
	    
	    
	    Page<StoreServiceOrder> list = storeServiceOrderService.getStoreServiceOrderPage(pageable, serviceOrder);
	    
		return list;
	}
	
	/**
	 * 查看订单详情
	 * @return
	 */
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	@ResponseBody()
	public Object detailServiceOrder(
			@RequestParam(value = "order_id") Integer orderId) throws Exception, RuntimeException {

		if(orderId == null){
			
			throw new BusinessErrorException(ErrorCodes.PARAM_ERROR, "参数为空");
			
		}
		StoreServiceOrder  serviceOrder = storeServiceOrderService.getStoreServiceOrderByOrderId(orderId);
		
		return serviceOrder;
	}
	
	
	
	/**
	 * 导出报表
	 */
	@RequestMapping(value="downloadExcel", method = RequestMethod.GET)
    public String download(@Valid StoreServiceOrderSearchBean bean,
    		HttpServletRequest request,HttpServletResponse response) throws Exception, RuntimeException, IOException{
      
		StoreServiceOrder serviceOrder = new StoreServiceOrder(bean.getOrder_id(), bean.getMember_truename(),
	    		bean.getOrder_status(), bean.getService_type());
	    ServiceInfo serviceInfo = new ServiceInfo();
	    serviceInfo.setServiceName(bean.getService_name());
	    serviceOrder.setServiceInfo(serviceInfo);
	    
		List<StoreServiceOrder> listExcel = storeServiceOrderService.getStoreServiceOrderList(serviceOrder);
	    
		String fileName="服务订单信息";
        //填充实体类实体数据
		List<StoreServiceOrder> projects= listExcel;
        List<Map<String,Object>> list=createExcelRecord(projects);
        String columnNames[]={"订单号","下单时间","下单会员","母婴店","订单金额","平台分成金额", "母婴店收益"};//列名
        String keys[]    =     {"orderId","addTime","memberTruename","companyName","orderAmount","commisAmount", "storeAmount"};//map中的key
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
	
    private List<Map<String, Object>> createExcelRecord(List<StoreServiceOrder> projects) {
        List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("sheetName", "sheet1");
        listmap.add(map);
        StoreServiceOrder project=null;
        for (int j = 0; j < projects.size(); j++) {
            project=projects.get(j);
            Map<String, Object> mapValue = new HashMap<String, Object>();
	            mapValue.put("orderId", project.getOrderId());
	            mapValue.put("addTime", project.getAddTime());
	            mapValue.put("memberTruename", project.getMemberTruename());
	            mapValue.put("companyName", project.getCompanyName());
	            mapValue.put("orderAmount", project.getOrderAmount());
	            mapValue.put("commisAmount", project.getCommisAmount());
	            mapValue.put("storeAmount", project.getStoreAmount());
            listmap.add(mapValue);
        }
        return listmap;
    
    }
	
	
}
