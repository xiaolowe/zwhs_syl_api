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
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.org.citycloud.zwhs.syl.bean.TopBean;
import cn.org.citycloud.zwhs.syl.entity.StoreOrder;
import cn.org.citycloud.zwhs.syl.repository.StoreOrderDao;

/**
 * @author Allen
 */

//Spring Bean的标识.
@Component
// 类中所有public函数都纳入事务管理的标识.
@Transactional
public class StoreOrderService {
	@Autowired
	private StoreOrderDao storeOrderDao;
	
	/**
	 * 动态查询订单列表
	 * @param pageable
	 * @param storeOrder
	 * @return
	 */
	public Page<StoreOrder> getStoreOrderPage(Pageable pageable, StoreOrder storeOrder, String startime, String endtime){
		Page<StoreOrder> page = storeOrderDao.findAll(new Specification<StoreOrder>() {
			@Override
			public Predicate toPredicate(Root<StoreOrder> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				
				Predicate where = cb.conjunction();  
				if(storeOrder != null && StringUtils.isNotBlank(startime) && StringUtils.isNotBlank(endtime)){
					Path<Date> addTime = root.get("addTime"); 
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date start = new Date();
					Date end = new Date();
					String startime1 = startime + " 00:00:00";
					String endtime1 = endtime + " 23:59:59";
					try {
						start = sdf.parse(startime1);
						end = sdf.parse(endtime1);
					} catch (ParseException e) {
						e.printStackTrace();
					}
					where = cb.and(where, cb.between(addTime, start, end)); 
					
				}
				if(storeOrder != null && storeOrder.getFinishTime() != null){
					Path<String> finishTime = root.get("finishTime");  
					where = cb.and(where, cb.equal(finishTime, storeOrder.getFinishTime())); 
					
				}
				if(storeOrder != null && storeOrder.getOrderId() != null ){
					Path<String> orderId = root.get("orderId");  
					where = cb.and(where, cb.equal(orderId, storeOrder.getOrderId()));
				}
				if(storeOrder != null && storeOrder.getOrderStatus() != null ){
					Path<String> orderStatus = root.get("orderStatus");  
					where = cb.and(where, cb.equal(orderStatus, storeOrder.getOrderStatus()));
				}

				// 分销订单查询
				Path<String> isRetail = root.get("isRetail");
				where = cb.and(where, cb.equal(isRetail, storeOrder.getIsRetail()));

				query.where(where);
				  
			    return null;   
			}
		}, pageable);
		
	    return page;
	}
	
	/**
	 * 动态查找列表
	 * @param storeOrder
	 * @param startime
	 * @param endtime
	 * @return
	 */
	public List<StoreOrder> getStoreOrderList(StoreOrder storeOrder, String startime, String endtime){
		
		return storeOrderDao.findAll(new Specification<StoreOrder>() {
			@Override
			public Predicate toPredicate(Root<StoreOrder> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate where = cb.conjunction();  
				if(storeOrder != null && StringUtils.isNotBlank(startime) && StringUtils.isNotBlank(endtime)){
					Path<Date> addTime = root.get("addTime"); 
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date start = new Date();
					Date end = new Date();
					String startime1 = startime + " 00:00:00";
					String endtime1 = endtime + " 23:59:59";
					try {
						start = sdf.parse(startime1);
						end = sdf.parse(endtime1);
					} catch (ParseException e) {
						e.printStackTrace();
					}
					where = cb.and(where, cb.between(addTime, start, end)); 
					
				}
				if(storeOrder != null && storeOrder.getFinishTime() != null){
					Path<String> finishTime = root.get("finishTime");  
					where = cb.and(where, cb.equal(finishTime, storeOrder.getFinishTime())); 
					
				}
				if(storeOrder != null && storeOrder.getOrderId() != null ){
					Path<String> orderId = root.get("orderId");  
					where = cb.and(where, cb.equal(orderId, storeOrder.getOrderId()));
				}
				if(storeOrder != null && storeOrder.getOrderStatus() != null ){
					Path<String> orderStatus = root.get("orderStatus");  
					where = cb.and(where, cb.equal(orderStatus, storeOrder.getOrderStatus()));
				}
				query.where(where);
				  
			    return null;   
			}
		});
	}
	/**
	 * 根据订单id查询订单信息
	 * @param orderId
	 * @return
	 */
	public StoreOrder getStoreOrderByOrderId(Integer orderId){
		
		return storeOrderDao.findOne(orderId);
	}
	
	/**
	 * 获取当天订单数
	 * @return
	 */
	public Long getStoreOrderCount(){
		
		return storeOrderDao.count(new Specification<StoreOrder>() {
				@Override
				public Predicate toPredicate(Root<StoreOrder> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
					
					Predicate where = cb.conjunction();  
					
					Path<Date> addTime = root.get("addTime"); 
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String now = sdf.format(new Date());
					String startime = now + " 00:00:00";
					String endtime = now + " 23:59:59";
					Date start = new Date();
					Date end = new Date();
					try {
						start = sdf2.parse(startime);
						end = sdf2.parse(endtime);
					} catch (ParseException e) {
						e.printStackTrace();
					}
					where = cb.and(where, cb.between(addTime, start, end)); 
					
					query.where(where);
					  
				    return null;   
				}
			});
	}
	
	
	/**
	 * 获取当天交易额
	 * @return
	 */
	public Double getOrderAmountCount(){
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String now = sdf.format(new Date());
		String startime = now + " 00:00:00";
		String endtime = now + " 23:59:59";
		Date start = new Date();
		Date end = new Date();
		try {
			start = sdf2.parse(startime);
			end = sdf2.parse(endtime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Double count = storeOrderDao.findOrderAcountAll(start, end);
		if(count == null){
			return 0.0;
		}else{
			return count;
		}
		
	}
	
	/**
	 * 获取首页top10 数据
	 * @return
	 */
	public List<StoreOrder> getMoneyTop10(){
		
		return storeOrderDao.findMoneyTop10();
	}
	
}
