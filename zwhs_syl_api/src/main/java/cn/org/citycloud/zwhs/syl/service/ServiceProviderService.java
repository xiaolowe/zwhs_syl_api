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
import cn.org.citycloud.zwhs.syl.repository.ServiceProviderDao;



//Spring Bean的标识.
@Component
// 类中所有public函数都纳入事务管理的标识.
@Transactional
public class ServiceProviderService {
	@Autowired
	private ServiceProviderDao serviceProviderDao;
	
	
	/**
	 * 动态查询服务商列表
	 * @param pageable
	 * @param serviceProvider
	 * @return
	 */
	public Page<ServiceProvider> getServiceProviderList(Pageable pageable, ServiceProvider serviceProvider){
		
		Page<ServiceProvider> page = serviceProviderDao.findAll(new Specification<ServiceProvider>() {
			@Override
			public Predicate toPredicate(Root<ServiceProvider> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				
				Predicate where = cb.conjunction();  
		        
				if(serviceProvider != null && StringUtils.isNotBlank(serviceProvider.getCompanyName())){
					Path<String> companyName = root.get("companyName");  
					where = cb.and(where, cb.like(companyName, "%"+serviceProvider.getCompanyName()+"%"));
				}
				if(serviceProvider != null && serviceProvider.getProviderState() != null){
					Path<Integer> providerState = root.get("providerState");  
					where = cb.and(where, cb.equal(providerState, serviceProvider.getProviderState()));  
				}
				query.where(where);
				  
			    return null;  
			}
		}, pageable);
		
	    return page;
	}

	/**
	 * 查找服务商信息
	 * @param providerId
	 * @return
	 */
	public ServiceProvider getServiceProviderById(Integer providerId){
		
		return serviceProviderDao.findOne(providerId);
		
	}
	
	/**
	 * 审核、驳回、冻结服务商信息
	 * @param providerState
	 * @return
	 */
	public ServiceProvider checkServiceProviderById(Integer providerId, Integer providerState){
		
		ServiceProvider serviceProvider = serviceProviderDao.findOne(providerId);
		serviceProvider.setProviderState(providerState);  // 0 待审核 1 已审核 2 驳回 3 冻结 
		Date now = new Date();
		serviceProvider.setUpdDate(now);

		return serviceProviderDao.save(serviceProvider);
		
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
