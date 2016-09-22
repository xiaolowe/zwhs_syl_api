package cn.org.citycloud.zwhs.syl.service;
import java.util.Date;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.org.citycloud.zwhs.syl.entity.StoreCoupon;
import cn.org.citycloud.zwhs.syl.repository.StoreCouponDao;



//Spring Bean的标识.
@Component
// 类中所有public函数都纳入事务管理的标识.
@Transactional
public class StoreCouponService {
	@Autowired
	private StoreCouponDao storeCouponDao;
	
	/**
	 * 动态查询优惠券列表
	 * @param pageable
	 * @param storeCoupon
	 * @return
	 */
	public Page<StoreCoupon> getStoreCouponList(Pageable pageable, StoreCoupon storeCoupon, Integer status){
		
		Page<StoreCoupon> page = storeCouponDao.findAll(new Specification<StoreCoupon>() {
			@Override
			public Predicate toPredicate(Root<StoreCoupon> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				
				Predicate where = cb.conjunction();  
				
				Path<Date> effectiveTime = root.get("effectiveTime");
				Path<Date> expirationTime = root.get("expirationTime");
				Path<Byte> couponStatus = root.get("couponStatus");
				Date now = new Date();
				Path<String> storeId = root.get("storeId");  
				where = cb.and(where, cb.isNull(storeId));
				
				if(status == 2){
					where = cb.and(where, cb.greaterThan(effectiveTime, now));
					where = cb.and(where, cb.equal(couponStatus, 10));  
				}
				if(status==3){
					where = cb.and(where, cb.and(cb.lessThan(effectiveTime, now),cb.greaterThan(expirationTime, now)));
					where = cb.and(where, cb.equal(couponStatus, 10));
				}
				if(status==4){
					where = cb.and(where, cb.or(cb.lessThan(expirationTime, now),cb.equal(couponStatus, 20)));
				}
				if(storeCoupon != null && StringUtils.isNotBlank(storeCoupon.getCouponName())){
					Path<String> couponName = root.get("couponName");  
					where = cb.and(where, cb.like(couponName, "%"+storeCoupon.getCouponName()+"%"));
				}
				query.where(where);
				  
			    return null;  
			}
		}, pageable);
		
	    return page;
	}
	
	/**
	 * 添加优惠券
	 * @param storeCoupon
	 */
	public StoreCoupon addStoreCoupon(StoreCoupon storeCoupon){
		
		
		return storeCouponDao.save(storeCoupon);
		
	}
	
	/**
	 * 使优惠券失效
	 * @param storeCoupon
	 * @return
	 */
	public StoreCoupon invalidStoreCoupon(int couponId){
		
		StoreCoupon storeCoupon = storeCouponDao.findOne(couponId);
		storeCoupon.setCouponStatus(20);  // 20 为失效
		Date now = new Date();
		storeCoupon.setUpdDate(now);
		return storeCouponDao.save(storeCoupon);
		
	}
	
	/**
	 * 查看优惠券详情
	 * @param couponId
	 * @return
	 */
	public StoreCoupon getStoreCoupon(int couponId){
		
		StoreCoupon storeCoupon = storeCouponDao.findOne(couponId);
		return storeCoupon;
	}
	
}
