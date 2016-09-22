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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

import cn.org.citycloud.zwhs.syl.bean.TopBean;
import cn.org.citycloud.zwhs.syl.constants.ErrorCodes;
import cn.org.citycloud.zwhs.syl.entity.StoreOrder;
import cn.org.citycloud.zwhs.syl.exception.BusinessErrorException;
import cn.org.citycloud.zwhs.syl.service.StoreOrderService;
import cn.org.citycloud.zwhs.syl.service.TopOrderService;
import cn.org.citycloud.zwhs.syl.utils.ExcelUtil;


@Controller
@RequestMapping("order")
@Api(tags = "订单管理")
public class OrderController {
	
	@Autowired
	private StoreOrderService storeOrderService;
	@Autowired
	private TopOrderService topOrderService;
	
	
	/**
	 * 获取订单列表
	 * 列表
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ApiOperation(value="获取订单列表",notes="获取订单列表",consumes="application/json",produces="application/json")
	@ResponseBody()
	public Object getGoods(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
	        @RequestParam(value = "pageSize", defaultValue = "10")  Integer pageSize,
	        @RequestParam(value = "order_status", required = false)  Integer orderStatus,
	        @RequestParam(value = "order_id", required = false)  Integer orderId,
	        @RequestParam(value = "start_time", required = false)  String startTime,
	        @RequestParam(value = "end_time", required = false)  String endTime,
						   @RequestParam(value = "is_retail", required = false)  Integer isRetail) throws Exception, RuntimeException {

		
		Sort sort = new Sort(Direction.DESC, "orderId");
	    Pageable pageable = new PageRequest(pageNo - 1, pageSize, sort);
	    StoreOrder storeOrder = new StoreOrder(orderId, orderStatus);
	    storeOrder.setOrderStatus(orderStatus);
	    storeOrder.setOrderId(orderId);
		if (isRetail != null) {
			storeOrder.setIsRetail(isRetail);
		}
	    Page<StoreOrder> list = storeOrderService.getStoreOrderPage(pageable, storeOrder, startTime, endTime);
		return list;
	}
	
	/**
	 * 查看订单详情
	 * @return
	 */
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	@ApiOperation(value="查看订单详情",notes="查看订单详情",consumes="application/json",produces="application/json")
	@ResponseBody()
	public Object detailGoods(
			@RequestParam(value = "order_id") Integer orderId) throws Exception, RuntimeException {

		if(orderId == null){
			
			throw new BusinessErrorException(ErrorCodes.PARAM_ERROR, "参数为空");
			
		}
		StoreOrder storeOrder = storeOrderService.getStoreOrderByOrderId(orderId);
		return storeOrder;
	}
	
	/**
	 * 获取今日订单数
	 * @return
	 */
	@RequestMapping(value = "/ordercount", method = RequestMethod.GET)
	@ResponseBody()
	public Object allcount() throws Exception, RuntimeException {

		
		Long count = storeOrderService.getStoreOrderCount();
		return count;
	}
	
	/**
	 * 获取今日交易额
	 * @return
	 */
	@RequestMapping(value = "/ordermoney", method = RequestMethod.GET)
	@ResponseBody()
	public Object ordermoney() throws Exception, RuntimeException {

		
		Double count = storeOrderService.getOrderAmountCount();
		return count;
	}
	
	/**
	 * 获取top10
	 * @return
	 */
	@RequestMapping(value = "/gettop10", method = RequestMethod.GET)
	@ResponseBody()
	public Object top10money() throws Exception, RuntimeException {

		
		List<TopBean> list = topOrderService.getMoneyTop10();
		return list;
	}
	
	
	/**
	 * 导出报表
	 */
	@RequestMapping(value="downloadExcel", method = RequestMethod.GET)
    public String download(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
	        @RequestParam(value = "pageSize", defaultValue = "10")  Integer pageSize,
	        @RequestParam(value = "order_status", required = false)  Integer orderStatus,
	        @RequestParam(value = "order_id", required = false)  Integer orderId,
	        @RequestParam(value = "start_time", required = false)  String startTime,
	        @RequestParam(value = "end_time", required = false)  String endTime,
    		HttpServletRequest request,HttpServletResponse response) throws Exception, RuntimeException, IOException{
      
	    StoreOrder storeOrder = new StoreOrder(orderId, orderStatus);
	    storeOrder.setOrderStatus(orderStatus);
	    storeOrder.setOrderId(orderId);
	    
		List<StoreOrder> listExcel = storeOrderService.getStoreOrderList(storeOrder, startTime, endTime);
	    
		String fileName="订单信息";
        //填充实体类实体数据
		List<StoreOrder> projects= listExcel;
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
	
    private List<Map<String, Object>> createExcelRecord(List<StoreOrder> projects) {
        List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("sheetName", "sheet1");
        listmap.add(map);
        StoreOrder project=null;
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
