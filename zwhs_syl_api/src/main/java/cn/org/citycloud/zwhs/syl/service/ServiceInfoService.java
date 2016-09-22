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

import cn.org.citycloud.zwhs.syl.entity.ServiceInfo;
import cn.org.citycloud.zwhs.syl.repository.ServiceInfoDao;



//Spring Bean的标识.
@Component
// 类中所有public函数都纳入事务管理的标识.
@Transactional
public class ServiceInfoService {
	@Autowired
	private ServiceInfoDao serviceInfoDao;
	
	
	/**
	 * 动态查询服务信息列表
	 * @param pageable
	 * @param serviceInfo
	 * @return
	 */
	public Page<ServiceInfo> getServiceInfoList(Pageable pageable, ServiceInfo serviceInfo){
		
		Page<ServiceInfo> page = serviceInfoDao.findAll(new Specification<ServiceInfo>() {
			@Override
			public Predicate toPredicate(Root<ServiceInfo> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				
				Predicate where = cb.conjunction();  
		        
				if(serviceInfo != null && StringUtils.isNotBlank(serviceInfo.getServiceName())){
					Path<String> serviceName = root.get("serviceName");  
					where = cb.and(where, cb.like(serviceName, "%"+serviceInfo.getServiceName()+"%"));
				}
				if(serviceInfo != null && serviceInfo.getServiceProvider() != null 
						&& StringUtils.isNotBlank(serviceInfo.getServiceProvider().getProviderAliasName())){
					Path<String> providerAliasName = root.get("serviceProvider").get("providerAliasName");  
					where = cb.and(where, cb.like(providerAliasName, "%"+serviceInfo.getServiceProvider().getProviderAliasName()+"%"));
				}
				if(serviceInfo != null && serviceInfo.getType() != null){
					Path<Integer> type = root.get("type");  
					where = cb.and(where, cb.equal(type, serviceInfo.getType()));  
				}
				if(serviceInfo != null && serviceInfo.getServiceState() != null){
					Path<Integer> serviceState = root.get("serviceState");  
					where = cb.and(where, cb.equal(serviceState, serviceInfo.getServiceState()));  
				}else{
					Path<Integer> serviceState = root.get("serviceState");  
					where = cb.and(where, cb.notEqual(serviceState, 10));		// service_state为10 代表 禁售
				}
				if(serviceInfo != null && serviceInfo.getServiceVerify() != null){
					Path<Integer> serviceVerify = root.get("serviceVerify");  
					where = cb.and(where, cb.equal(serviceVerify, serviceInfo.getServiceVerify()));  
				}
				query.where(where);
				  
			    return null;  
			}
		}, pageable);
		
	    return page;
	}

	/**
	 * 查找服务信息
	 * @param serviceId
	 * @return
	 */
	public ServiceInfo getServiceInfoById(Integer serviceId){
		
		return serviceInfoDao.findOne(serviceId);
		
	}
	
	/**
	 * 审核服务信息
	 * @param serviceId
	 * @return
	 */
	public ServiceInfo checkServiceInfoById(Integer serviceId, ServiceInfo si){
		
		ServiceInfo serviceInfo = serviceInfoDao.findOne(serviceId);
		
		if(si != null && si.getServiceVerify() != null){
			serviceInfo.setServiceVerify(si.getServiceVerify());  // 1 为审核通过     	2为驳回
		}
		serviceInfo.setConfirmUserId(si.getConfirmUserId());
		serviceInfo.setConfirmUserName(si.getConfirmUserName());
		
		if(serviceInfo.getStoreRates() == null){
			serviceInfo.setStoreRates(20.0);
		}
		Date now = new Date();
		serviceInfo.setUpdDate(now);
		serviceInfo.setConfirmTime(now);
		return serviceInfoDao.save(serviceInfo);
		
	}
	
	/**
	 * 禁售服务信息
	 * @param serviceId
	 * @return
	 */
	public ServiceInfo forbidServiceInfoById(Integer serviceId){
		
		ServiceInfo serviceInfo = serviceInfoDao.findOne(serviceId);
		serviceInfo.setServiceState(10);  // 10  为禁止销售
		
		Date now = new Date();
		serviceInfo.setUpdDate(now);

		return serviceInfoDao.save(serviceInfo);
		
	}
	
	
	/**
	 * 修改服务信息
	 * @param serviceId
	 * @return
	 */
	public ServiceInfo modifyServiceInfoById(Integer serviceId, ServiceInfo serviceInfo){
		
		ServiceInfo siupdate = serviceInfoDao.findOne(serviceId);
		
		if(serviceInfo != null && StringUtils.isNoneEmpty(serviceInfo.getServiceName())){
			siupdate.setServiceName(serviceInfo.getServiceName());
		}
		if(serviceInfo != null && StringUtils.isNoneEmpty(serviceInfo.getServiceLogo())){
			siupdate.setServiceLogo(serviceInfo.getServiceLogo());
		}
		if(serviceInfo != null && StringUtils.isNoneEmpty(serviceInfo.getServicePic1())){
			siupdate.setServicePic1(serviceInfo.getServicePic1());
		}
		if(serviceInfo != null && StringUtils.isNoneEmpty(serviceInfo.getServicePic2())){
			siupdate.setServicePic2(serviceInfo.getServicePic2());
		}
		if(serviceInfo != null && StringUtils.isNoneEmpty(serviceInfo.getServicePic3())){
			siupdate.setServicePic3(serviceInfo.getServicePic3());
		}
		if(serviceInfo != null && StringUtils.isNoneEmpty(serviceInfo.getServicePic4())){
			siupdate.setServicePic4(serviceInfo.getServicePic4());
		}
		if(serviceInfo != null && StringUtils.isNoneEmpty(serviceInfo.getServicePic5())){
			siupdate.setServicePic5(serviceInfo.getServicePic5());
		}
		if(serviceInfo != null && StringUtils.isNoneEmpty(serviceInfo.getRemark())){
			siupdate.setRemark(serviceInfo.getRemark());
		}
		if(serviceInfo != null && serviceInfo.getBusinessStart() != null){
			siupdate.setBusinessStart(serviceInfo.getBusinessStart());
		}
		if(serviceInfo != null && serviceInfo.getBusinessEnd() != null){
			siupdate.setBusinessEnd(serviceInfo.getBusinessEnd());
		}
		if(serviceInfo != null && serviceInfo.getServicePrice() != null){
			siupdate.setServicePrice(serviceInfo.getServicePrice());
		}
		if(serviceInfo != null && serviceInfo.getProviderRates() != null){
			siupdate.setProviderRates(serviceInfo.getProviderRates());
		}
		if(serviceInfo != null && serviceInfo.getStoreRates() != null){
			siupdate.setStoreRates(serviceInfo.getStoreRates());
		}
		if(serviceInfo != null && serviceInfo.getCommisRates() != null){
			siupdate.setCommisRates(serviceInfo.getCommisRates());
		}
		
		return serviceInfoDao.save(siupdate);
		
	}
}
