package cn.org.citycloud.zwhs.syl.controller;
import java.util.Map;

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

import cn.org.citycloud.zwhs.syl.bean.ServiceStoreSearchBean;
import cn.org.citycloud.zwhs.syl.constants.ErrorCodes;
import cn.org.citycloud.zwhs.syl.core.BaseController;
import cn.org.citycloud.zwhs.syl.entity.ServiceStore;
import cn.org.citycloud.zwhs.syl.entity.Store;
import cn.org.citycloud.zwhs.syl.exception.BusinessErrorException;
import cn.org.citycloud.zwhs.syl.service.ServiceStoreService;


@Controller
@RequestMapping("servicestore")
public class ServiceStoreController extends BaseController{
	
	@Autowired
	private ServiceStoreService serviceStoreService;
	
	
	/**
	 * 获取服务商列表
	 * 列表
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody()
	public Object getServiceInfoList(@Valid ServiceStoreSearchBean bean) throws Exception, RuntimeException {

		Sort sort = new Sort(Direction.DESC, "id");
	    Pageable pageable = new PageRequest(bean.getPageNo() - 1, bean.getPageSize(), sort);
	    
	    ServiceStore serviceStore = new ServiceStore();
	    serviceStore.setServiceState(bean.getService_state());
	    serviceStore.setServiceVerify(bean.getService_verify());
	    Store store = new Store();
	    store.setCompanyName(bean.getCompany_name());
	    serviceStore.setStore(store);
	    
		Page<ServiceStore> list = serviceStoreService.getServiceStoreList(pageable, serviceStore);
		return list;
	}
	
	
	/**
	 * 审核、驳回 母婴店服务信息
	 * @return
	 */
	@RequestMapping(value = "/check/{serviceStoreId}", method = RequestMethod.PUT)
	@ResponseBody()
	public Object checkServiceInfo(@PathVariable Integer serviceStoreId,
			@RequestBody Map<String, Object> params,
			HttpServletRequest request,HttpServletResponse response) throws Exception, RuntimeException {

		Integer serviceVerify = (Integer)params.get("service_verify");
		
		if(serviceStoreId == null && serviceVerify == null){
			
			throw new BusinessErrorException(ErrorCodes.PARAM_ERROR, "参数为空");
		}
		Integer userId =  getUserId();
		String userName = getUserName();
		if(userId == null || userName == null){
			throw new BusinessErrorException(ErrorCodes.PARAM_ERROR, "用户session失效，请重新登录！");
		}
		ServiceStore serviceStore = new ServiceStore();
		serviceStore.setServiceVerify(serviceVerify);
		serviceStore.setConfirmUserId(userId);
		serviceStore.setConfirmUserName(userName);
		
		return serviceStoreService.checkServiceStoreById(serviceStoreId, serviceStore);
	}
	
	
	/**
	 * 查看服务信息详情
	 * @return
	 */
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	@ResponseBody()
	public Object detailServiceInfo(
			@RequestParam(value = "service_store_id") Integer serviceStoreId) throws Exception, RuntimeException {

		if(serviceStoreId == null){
			
			throw new BusinessErrorException(ErrorCodes.PARAM_ERROR, "参数为空");
			
		}
		return serviceStoreService.getServiceStoreById(serviceStoreId);
		
	}
	
	/**
	 * 修改服务信息
	 * @return
	 */
//	@RequestMapping(value = "/modify/{serviceId}", method = RequestMethod.PUT)
//	@ResponseBody()
//	public Object modifyServiceInfo(@PathVariable Integer serviceId,
//			@Valid @RequestBody ServiceInfoModifyBean bean) throws Exception, RuntimeException {
//
//		if(serviceId == null){
//			
//			throw new BusinessErrorException(ErrorCodes.PARAM_ERROR, "参数为空");
//			
//		}
//		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
//        Time starttime=new Time(sdf.parse(bean.getBusinessStart()).getTime());
//        Time endtime=new Time(sdf.parse(bean.getBusinessEnd()).getTime());
//		ServiceInfo serviceInfo = new ServiceInfo();
//		serviceInfo.setBusinessStart(starttime);
//		serviceInfo.setBusinessEnd(endtime);
//		BeanUtils.copyProperties(bean, serviceInfo);
//		
//		return serviceInfoService.modifyServiceInfoById(serviceId, serviceInfo);
//	}
	
}
