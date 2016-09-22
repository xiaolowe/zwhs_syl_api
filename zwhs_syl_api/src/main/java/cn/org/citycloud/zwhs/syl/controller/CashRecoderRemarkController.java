package cn.org.citycloud.zwhs.syl.controller;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.org.citycloud.zwhs.syl.bean.CashRecoderRemarkBean;
import cn.org.citycloud.zwhs.syl.constants.ErrorCodes;
import cn.org.citycloud.zwhs.syl.core.BaseController;
import cn.org.citycloud.zwhs.syl.entity.CashRecoderRemark;
import cn.org.citycloud.zwhs.syl.exception.BusinessErrorException;
import cn.org.citycloud.zwhs.syl.service.CashRecoderRemarkService;


@Controller
@RequestMapping("cashreremark")
public class CashRecoderRemarkController extends BaseController{
	
	@Autowired
	private CashRecoderRemarkService cashRecoderRemarkService;
	
	
	/**
	 * 添加备注
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody()
	public Object addCashRemark(@Valid @RequestBody CashRecoderRemarkBean bean,
			HttpServletRequest request,HttpServletResponse response) throws Exception, RuntimeException {

		Date now = new Date();
		
		//登录用户名
		String userName = getUserName();
		
		
		CashRecoderRemark cashRecoderRemark = new CashRecoderRemark(bean.getCash_no(),
				now, now, bean.getRemark(), userName);
		
		return cashRecoderRemarkService.addCashRecoderRemark(cashRecoderRemark);
		
	}
	
	/**
	 * 查看备注列表
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody()
	public Object detailGoods(
			@RequestParam(value = "cash_no") Integer cashNo) throws Exception, RuntimeException {

		if(cashNo == null){
			
			throw new BusinessErrorException(ErrorCodes.PARAM_ERROR, "参数为空");
			
		}
		CashRecoderRemark cashRecoderRemark = cashRecoderRemarkService.getCashRemarkByCashNo(cashNo);
		return cashRecoderRemark;
	}
	
	
	
	
}
