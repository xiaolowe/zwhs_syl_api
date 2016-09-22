package cn.org.citycloud.zwhs.syl.service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

import cn.org.citycloud.zwhs.syl.entity.StorePay;
import cn.org.citycloud.zwhs.syl.repository.StorePayDao;

/**
 * 
 * @author Allen
 *
 */

//Spring Bean的标识.
@Component
// 类中所有public函数都纳入事务管理的标识.
@Transactional
public class StorePayService {
	@Autowired
	private StorePayDao storePayDao;
	
	/**
	 * 动态查询支出款项列表
	 * @param pageable
	 * @param storePay
	 * @return
	 */
	public Page<StorePay> getStorePayPage(Pageable pageable, StorePay storePay, String startTime, String endTime){
		
		Page<StorePay> page = storePayDao.findAll(new Specification<StorePay>() {
			@Override
			public Predicate toPredicate(Root<StorePay> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				
				Predicate where = cb.conjunction();  
				
				Path<String> orderType = root.get("orderType");  
				where = cb.and(where, cb.equal(orderType, 1)); 
				
				if(storePay != null && storePay.getPayId() != null){
					Path<String> payId = root.get("payId");  
					where = cb.and(where, cb.equal(payId, storePay.getPayId())); 
					
				}
				if(storePay != null && storePay.getWechatMember() != null && StringUtils.isNotBlank(storePay.getWechatMember().getWechatAliasname())){
					Path<String> payMemberName = root.get("wechatMember").get("wechatAliasname");  
					where = cb.and(where, cb.like(payMemberName, "%"+storePay.getWechatMember().getWechatAliasname()+"%"));
				}
				if(storePay != null && StringUtils.isNotBlank(storePay.getCompanyName())){
					Path<String> companyName = root.get("companyName");  
					where = cb.and(where, cb.like(companyName, "%"+storePay.getCompanyName()+"%"));
				}
				if(storePay != null && storePay.getPayState() != null ){
					Path<String> payState = root.get("payState");  
					where = cb.and(where, cb.equal(payState, storePay.getPayState()));
				}
				if(storePay != null && StringUtils.isNotBlank(startTime) && StringUtils.isNotBlank(endTime)){
					Path<Date> payTime = root.get("payTime"); 
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date start = new Date();
					Date end = new Date();
					String startime1 = startTime + " 00:00:00";
					String endtime1 = endTime + " 23:59:59";
					try {
						start = sdf.parse(startime1);
						end = sdf.parse(endtime1);
					} catch (ParseException e) {
						e.printStackTrace();
					}
					where = cb.and(where, cb.between(payTime, start, end)); 
					
				}
				query.where(where);
				  
			    return null;   
			}
		}, pageable);
		
	    return page;
	}
	
	/**
	 * 动态查询支出款项列表
	 * @param pageable
	 * @param storePay
	 * @return
	 */
	public List<StorePay> getStorePayList(StorePay storePay, String startTime, String endTime){
		
		List<StorePay> list = storePayDao.findAll(new Specification<StorePay>() {
			@Override
			public Predicate toPredicate(Root<StorePay> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				
				Predicate where = cb.conjunction();  
				if(storePay != null && storePay.getPayId() != null){
					Path<String> payId = root.get("payId");  
					where = cb.and(where, cb.equal(payId, storePay.getPayId())); 
					
				}
				if(storePay != null && storePay.getWechatMember() != null && StringUtils.isNotBlank(storePay.getWechatMember().getWechatAliasname())){
					Path<String> payMemberName = root.get("wechatMember").get("wechatAliasname");  
					where = cb.and(where, cb.like(payMemberName, "%"+storePay.getWechatMember().getWechatAliasname()+"%"));
				}
				if(storePay != null && StringUtils.isNotBlank(storePay.getCompanyName())){
					Path<String> companyName = root.get("companyName");  
					where = cb.and(where, cb.like(companyName, "%"+storePay.getCompanyName()+"%"));
				}
				if(storePay != null && storePay.getPayState() != null ){
					Path<String> payState = root.get("payState");  
					where = cb.and(where, cb.equal(payState, storePay.getPayState()));
				}
				if(storePay != null && StringUtils.isNotBlank(startTime) && StringUtils.isNotBlank(endTime)){
					Path<Date> payTime = root.get("payTime"); 
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date start = new Date();
					Date end = new Date();
					String startime1 = startTime + " 00:00:00";
					String endtime1 = endTime + " 23:59:59";
					try {
						start = sdf.parse(startime1);
						end = sdf.parse(endtime1);
					} catch (ParseException e) {
						e.printStackTrace();
					}
					where = cb.and(where, cb.between(payTime, start, end)); 
					
				}
				query.where(where);
				  
			    return null;   
			}
		});
		
	    return list;
	}
	
	
	/**
	 * 获取收入款项详情信息
	 * @param payId
	 * @return
	 */
	public StorePay getStorePayByPayId(Integer payId){
		
		return storePayDao.findOne(payId);
	}
	
}
