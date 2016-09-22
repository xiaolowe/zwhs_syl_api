package cn.org.citycloud.zwhs.syl.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.org.citycloud.zwhs.syl.bean.TopBean;
import cn.org.citycloud.zwhs.syl.service.CashRecoderService;
import cn.org.citycloud.zwhs.syl.service.GoodsCommonService;
import cn.org.citycloud.zwhs.syl.service.StoreOrderService;
import cn.org.citycloud.zwhs.syl.service.StoreService;
import cn.org.citycloud.zwhs.syl.service.TopOrderService;


@Controller
@RequestMapping("data")
public class DataController {
	
	@Autowired
	private StoreOrderService storeOrderService;
	@Autowired
	private TopOrderService topOrderService;
	@Autowired
	private StoreService storeService;
	@Autowired
	private GoodsCommonService goodsCommonService;
	@Autowired
	private CashRecoderService cashRecoderService;
	
	
	/**
	 * 首页
	 * @return
	 */
	@RequestMapping(value = "/msg", method = RequestMethod.GET)
	@ResponseBody()
	public Object getMessage() throws Exception, RuntimeException {
		
		//今日订单数
		Long ordercount = storeOrderService.getStoreOrderCount();
		//今日交易额
		Double ordermoney = storeOrderService.getOrderAmountCount();
		//母婴店认证申请
		Long storeuncheck = storeService.getStoreByUncheck();
		//商品入库申请
		Long goodsuncheck = goodsCommonService.getGoodsCommonByunCheckState();
		//提款申请
		Long cashuncheck = cashRecoderService.getCashByUncheck();
		//待打款项
		Long cashunpay = cashRecoderService.getCashByUnPay();
		//top10列表
		List<TopBean> topmoney = topOrderService.getMoneyTop10();
		
		
		
		Map<String, Object> rstMap = new HashMap<String, Object>();
		
		rstMap.put("ordercount", ordercount);
		rstMap.put("ordermoney", ordermoney);
		rstMap.put("storeuncheck", storeuncheck);
		rstMap.put("goodsuncheck", goodsuncheck);
		rstMap.put("cashuncheck", cashuncheck);
		rstMap.put("cashunpay", cashunpay);
		rstMap.put("topmoney", topmoney);
		
		
		return rstMap;

	}
	
}
