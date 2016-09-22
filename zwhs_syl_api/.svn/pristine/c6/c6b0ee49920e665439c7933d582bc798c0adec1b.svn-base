package cn.org.citycloud.zwhs.syl.controller;
import java.util.Date;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.org.citycloud.zwhs.syl.bean.StoreCouponBean;
import cn.org.citycloud.zwhs.syl.constants.ErrorCodes;
import cn.org.citycloud.zwhs.syl.entity.StoreCoupon;
import cn.org.citycloud.zwhs.syl.exception.BusinessErrorException;
import cn.org.citycloud.zwhs.syl.service.StoreCouponService;
import cn.org.citycloud.zwhs.syl.utils.DateUtil;

@Controller
@RequestMapping("storecoupon")
public class StoreCouponController {
	
	
	@Autowired
	private StoreCouponService storeCouponService;
	
	/**
	 * 添加优惠券
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody()
	public Object addStoerCoupon(@Valid @RequestBody StoreCouponBean bean,
			HttpServletRequest request,HttpServletResponse response) throws Exception, RuntimeException {

		Date now = new Date();
		
		StoreCoupon storeCoupon = new StoreCoupon(bean.getCoupon_condition(), bean.getCoupon_limit(), bean.getCoupon_money(), bean.getCoupon_name(),
				bean.getCoupon_number(), bean.getCouponSymbol(), now, bean.getCoupon_desc());
		storeCoupon.setCouponStatus(10);
		storeCoupon.setEffectiveTime(DateUtil.convertMinDate(bean.getEffective_time()));
		storeCoupon.setExpirationTime(DateUtil.convertMaxDate(bean.getExpiration_time()));
		
		return storeCouponService.addStoreCoupon(storeCoupon);
	}
	
	
	/**
	 * 列表
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody()
	public Object getGoods(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
	        @RequestParam(value = "pageSize", defaultValue = "10")  Integer pageSize,
	        @RequestParam(value = "status", defaultValue = "1")  Integer status,
	        @RequestParam(value = "coupon_name", required = false)  String couponName) throws Exception, RuntimeException {

		Sort sort = new Sort(Direction.DESC, "couponId");
	    Pageable pageable = new PageRequest(pageNo - 1, pageSize, sort);
	    StoreCoupon storeCoupon = new StoreCoupon();
	    storeCoupon.setCouponName(couponName);
		Page<StoreCoupon> list = storeCouponService.getStoreCouponList(pageable, storeCoupon, status);
		return list;
	}
	
	/**
	 * 优惠券失效
	 * @return
	 */
	@RequestMapping(value = "/invalid/{couponId}", method = RequestMethod.PUT)
	@ResponseBody()
	public Object checkStore(@PathVariable Integer couponId) throws Exception, RuntimeException {

		
		if(couponId == null){
			
			throw new BusinessErrorException(ErrorCodes.PARAM_ERROR, "参数为空");
			
		}
		
		return storeCouponService.invalidStoreCoupon(couponId);
		
	}
	
	
	/**
	 * 查看优惠券详情
	 * @return
	 */
	@RequestMapping(value = "/detail/{couponId}", method = RequestMethod.GET)
	@ResponseBody()
	public Object detailGoods(@PathVariable Integer couponId) throws Exception, RuntimeException {

		if(couponId == null){
			
			throw new BusinessErrorException(ErrorCodes.PARAM_ERROR, "参数为空");
			
		}
		StoreCoupon storeCoupon = storeCouponService.getStoreCoupon(couponId);
		
		return storeCoupon;
	}
	
	
}
