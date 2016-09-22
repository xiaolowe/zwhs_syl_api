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

import cn.org.citycloud.zwhs.syl.entity.ServiceProvider;
import cn.org.citycloud.zwhs.syl.entity.ServiceStore;
import cn.org.citycloud.zwhs.syl.repository.ServiceStoreDao;



//Spring Bean的标识.
@Component
// 类中所有public函数都纳入事务管理的标识.
@Transactional
public class ServiceStoreService {
	@Autowired
	private ServiceStoreDao serviceStoreDao;
	
	
	/**
	 * 动态查询门店服务列表
	 * @param pageable
	 * @param serviceStore
	 * @return
	 */
	public Page<ServiceStore> getServiceStoreList(Pageable pageable, ServiceStore serviceStore){
		
		Page<ServiceStore> page = serviceStoreDao.findAll(new Specification<ServiceStore>() {
			@Override
			public Predicate toPredicate(Root<ServiceStore> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				
				Predicate where = cb.conjunction();  
		        
				if(serviceStore != null && serviceStore.getStore() != null && 
						StringUtils.isNotBlank(serviceStore.getStore().getCompanyName())){
					Path<String> serviceName = root.get("store").get("companyName");  
					where = cb.and(where, cb.like(serviceName, "%"+serviceStore.getStore().getCompanyName()+"%"));
				}
				if(serviceStore != null && serviceStore.getServiceState() != null){
					Path<Integer> serviceState = root.get("serviceState");  
					where = cb.and(where, cb.equal(serviceState, serviceStore.getServiceState()));  
				}
				if(serviceStore != null && serviceStore.getServiceVerify() != null){
					Path<Integer> serviceVerify = root.get("serviceVerify");  
					where = cb.and(where, cb.equal(serviceVerify, serviceStore.getServiceVerify()));  
				}
				query.where(where);
				  
			    return null;  
			}
		}, pageable);
		
	    return page;
	}

	/**
	 * 查找母婴店服务信息
	 * @param serviceStoreId
	 * @return
	 */
	public ServiceStore getServiceStoreById(Integer id){
		
		return serviceStoreDao.findOne(id);
		
	}
	
	/**
	 * 审核、驳回、冻结服务商信息
	 * @return
	 */
	public ServiceStore checkServiceStoreById(Integer serviceStoreId, ServiceStore ss){
		
		ServiceStore serviceStore = serviceStoreDao.findOne(serviceStoreId);
		if(ss != null && ss.getServiceVerify() != null){
			serviceStore.setServiceVerify(ss.getServiceVerify());  // 服务审核 1 审核通过，0未通过，2 驳回 
		}
		serviceStore.setConfirmUserId(ss.getConfirmUserId());
		serviceStore.setConfirmUserName(ss.getConfirmUserName());
		
		Date now = new Date();
		serviceStore.setUpdDate(now);
		serviceStore.setConfirmTime(now);
		
		return serviceStoreDao.save(serviceStore);
		
	}
	
	
	/**
	 * 修改服务信息
	 * @param serviceId
	 * @return
	 */
//	public ServiceInfo modifyServiceInfoById(Integer serviceId, ServiceInfo serviceInfo){
//		
//		ServiceInfo siupdate = serviceInfoDao.findOne(serviceId);
//		
//		if(serviceInfo != null && StringUtils.isNoneEmpty(serviceInfo.getServiceName())){
//			siupdate.setServiceName(serviceInfo.getServiceName());
//		}
//		if(serviceInfo != null && StringUtils.isNoneEmpty(serviceInfo.getServiceLogo())){
//			siupdate.setServiceLogo(serviceInfo.getServiceLogo());
//		}
//		if(serviceInfo != null && StringUtils.isNoneEmpty(serviceInfo.getServicePic1())){
//			siupdate.setServicePic1(serviceInfo.getServicePic1());
//		}
//		if(serviceInfo != null && StringUtils.isNoneEmpty(serviceInfo.getServicePic2())){
//			siupdate.setServicePic2(serviceInfo.getServicePic2());
//		}
//		if(serviceInfo != null && StringUtils.isNoneEmpty(serviceInfo.getServicePic3())){
//			siupdate.setServicePic3(serviceInfo.getServicePic3());
//		}
//		if(serviceInfo != null && StringUtils.isNoneEmpty(serviceInfo.getServicePic4())){
//			siupdate.setServicePic4(serviceInfo.getServicePic4());
//		}
//		if(serviceInfo != null && StringUtils.isNoneEmpty(serviceInfo.getServicePic5())){
//			siupdate.setServicePic5(serviceInfo.getServicePic5());
//		}
//		if(serviceInfo != null && StringUtils.isNoneEmpty(serviceInfo.getRemark())){
//			siupdate.setRemark(serviceInfo.getRemark());
//		}
//		if(serviceInfo != null && serviceInfo.getBusinessStart() != null){
//			siupdate.setBusinessStart(serviceInfo.getBusinessStart());
//		}
//		if(serviceInfo != null && serviceInfo.getBusinessEnd() != null){
//			siupdate.setBusinessEnd(serviceInfo.getBusinessEnd());
//		}
//		if(serviceInfo != null && serviceInfo.getServicePrice() != null){
//			siupdate.setServicePrice(serviceInfo.getServicePrice());
//		}
//		if(serviceInfo != null && serviceInfo.getProviderRates() != null){
//			siupdate.setProviderRates(serviceInfo.getProviderRates());
//		}
//		if(serviceInfo != null && serviceInfo.getStoreRates() != null){
//			siupdate.setStoreRates(serviceInfo.getStoreRates());
//		}
//		if(serviceInfo != null && serviceInfo.getCommisRates() != null){
//			siupdate.setCommisRates(serviceInfo.getCommisRates());
//		}
//		
//		return serviceInfoDao.save(siupdate);
//		
//	}
}
