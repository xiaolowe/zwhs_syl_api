package cn.org.citycloud.zwhs.syl.service;
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
import cn.org.citycloud.zwhs.syl.entity.StoreServiceOrder;
import cn.org.citycloud.zwhs.syl.repository.StoreServiceOrderDao;

/**
 * @author Allen
 */

//Spring Bean的标识.
@Component
// 类中所有public函数都纳入事务管理的标识.
@Transactional
public class StoreServiceOrderService {
	@Autowired
	private StoreServiceOrderDao storeServiceOrderDao;
	
	/**
	 * 动态查询订单列表
	 * @param pageable
	 * @param storeServiceOrder
	 * @return
	 */
	public Page<StoreServiceOrder> getStoreServiceOrderPage(Pageable pageable, StoreServiceOrder storeServiceOrder){
		
		Page<StoreServiceOrder> page = storeServiceOrderDao.findAll(new Specification<StoreServiceOrder>() {
			@Override
			public Predicate toPredicate(Root<StoreServiceOrder> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				
				Predicate where = cb.conjunction();  
				
				if(storeServiceOrder != null && storeServiceOrder.getOrderId() != null){
					Path<String> orderId = root.get("orderId");  
					where = cb.and(where, cb.equal(orderId, storeServiceOrder.getOrderId())); 
				}
				if(storeServiceOrder != null && StringUtils.isNotBlank(storeServiceOrder.getMemberTruename())){
					Path<String> memberTruename = root.get("memberTruename");  
					where = cb.and(where, cb.like(memberTruename, "%"+storeServiceOrder.getMemberTruename()+"%"));
				}
				if(storeServiceOrder != null && storeServiceOrder.getServiceInfo() != null &&
						StringUtils.isNotBlank(storeServiceOrder.getServiceInfo().getServiceName())){
					Path<String> serviceName = root.get("serviceInfo").get("serviceName");  
					where = cb.and(where, cb.like(serviceName, "%"+storeServiceOrder.getServiceInfo().getServiceName()+"%"));
				}
				if(storeServiceOrder != null && storeServiceOrder.getServiceType() != null ){
					Path<String> serviceType = root.get("serviceType");  
					where = cb.and(where, cb.equal(serviceType, storeServiceOrder.getServiceType()));
				}
				if(storeServiceOrder != null && storeServiceOrder.getOrderStatus() != null ){
					Path<String> orderStatus = root.get("orderStatus");  
					where = cb.and(where, cb.equal(orderStatus, storeServiceOrder.getOrderStatus()));
				}
				query.where(where);
				  
			    return null;   
			}
		}, pageable);
		
	    return page;
	}
	
	/**
	 * 动态查找列表
	 * @param storeServiceOrder
	 * @return
	 */
	public List<StoreServiceOrder> getStoreServiceOrderList(StoreServiceOrder storeServiceOrder){
		
		return storeServiceOrderDao.findAll(new Specification<StoreServiceOrder>() {
			@Override
			public Predicate toPredicate(Root<StoreServiceOrder> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				
				Predicate where = cb.conjunction();  
				
				if(storeServiceOrder != null && storeServiceOrder.getOrderId() != null){
					Path<String> orderId = root.get("orderId");  
					where = cb.and(where, cb.equal(orderId, storeServiceOrder.getOrderId())); 
				}
				if(storeServiceOrder != null && StringUtils.isNotBlank(storeServiceOrder.getMemberTruename())){
					Path<String> memberTruename = root.get("memberTruename");  
					where = cb.and(where, cb.like(memberTruename, "%"+storeServiceOrder.getMemberTruename()+"%"));
				}
				if(storeServiceOrder != null && storeServiceOrder.getServiceInfo() != null &&
						StringUtils.isNotBlank(storeServiceOrder.getServiceInfo().getServiceName())){
					Path<String> serviceName = root.get("serviceName");  
					where = cb.and(where, cb.like(serviceName, "%"+storeServiceOrder.getServiceInfo().getServiceName()+"%"));
				}
				if(storeServiceOrder != null && storeServiceOrder.getServiceType() != null ){
					Path<String> serviceType = root.get("serviceType");  
					where = cb.and(where, cb.equal(serviceType, storeServiceOrder.getServiceType()));
				}
				if(storeServiceOrder != null && storeServiceOrder.getOrderStatus() != null ){
					Path<String> orderStatus = root.get("orderStatus");  
					where = cb.and(where, cb.equal(orderStatus, storeServiceOrder.getOrderStatus()));
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
	public StoreServiceOrder getStoreServiceOrderByOrderId(Integer orderId){
		
		return storeServiceOrderDao.findOne(orderId);
	}
	
	
}
