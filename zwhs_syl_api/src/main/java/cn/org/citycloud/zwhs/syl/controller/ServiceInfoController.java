package cn.org.citycloud.zwhs.syl.controller;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
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

import cn.org.citycloud.zwhs.syl.bean.ServiceInfoModifyBean;
import cn.org.citycloud.zwhs.syl.bean.ServiceInfoSearchBean;
import cn.org.citycloud.zwhs.syl.constants.ErrorCodes;
import cn.org.citycloud.zwhs.syl.core.BaseController;
import cn.org.citycloud.zwhs.syl.entity.ServiceInfo;
import cn.org.citycloud.zwhs.syl.entity.ServiceProvider;
import cn.org.citycloud.zwhs.syl.exception.BusinessErrorException;
import cn.org.citycloud.zwhs.syl.service.ServiceInfoService;


@Controller
@RequestMapping("serviceinfo")
public class ServiceInfoController extends BaseController{
	
	@Autowired
	private ServiceInfoService serviceInfoService;
	
	
	/**
	 * 获取服务信息列表
	 * 列表
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody()
	public Object getServiceInfoList(@Valid ServiceInfoSearchBean bean) throws Exception, RuntimeException {

		Sort sort = new Sort(Direction.DESC, "serviceId");
	    Pageable pageable = new PageRequest(bean.getPageNo() - 1, bean.getPageSize(), sort);
	    ServiceInfo serviceInfo = new ServiceInfo();
	    serviceInfo.setServiceName(bean.getService_name());
	    
	    ServiceProvider serviceProvider = new ServiceProvider();
	    serviceProvider.setProviderAliasName(bean.getProvider_alias_name());
	    serviceInfo.setServiceProvider(serviceProvider);
	    
	    serviceInfo.setType(bean.getType());
	    serviceInfo.setServiceState(bean.getService_state());
	    serviceInfo.setServiceVerify(bean.getService_verify());
		Page<ServiceInfo> list = serviceInfoService.getServiceInfoList(pageable, serviceInfo);
		return list;
	}
	
	
	/**
	 * 审核、驳回 服务信息
	 * @return
	 */
	@RequestMapping(value = "/check/{serviceId}", method = RequestMethod.PUT)
	@ResponseBody()
	public Object checkServiceInfo(@PathVariable Integer serviceId,
			@RequestBody Map<String, Object> params,
			HttpServletRequest request,HttpServletResponse response) throws Exception, RuntimeException {
		
		Integer serviceVerify = (Integer)params.get("service_verify");

		if(serviceId == null || serviceVerify == null){
			
			throw new BusinessErrorException(ErrorCodes.PARAM_ERROR, "参数为空");
			
		}
		Integer userId = getUserId();
		String userName = getUserName();
		
		ServiceInfo serviceInfo = new ServiceInfo();
		serviceInfo.setServiceVerify(serviceVerify);
		serviceInfo.setConfirmUserId(userId);
		serviceInfo.setConfirmUserName(userName);
		
		return serviceInfoService.checkServiceInfoById(serviceId, serviceInfo);
	}
	
	/**
	 * 禁售服务信息
	 * @return
	 */
	@RequestMapping(value = "/forbid/{serviceId}", method = RequestMethod.PUT)
	@ResponseBody()
	public Object forbidServiceInfo(@PathVariable Integer serviceId) throws Exception, RuntimeException {

		if(serviceId == null){
			
			throw new BusinessErrorException(ErrorCodes.PARAM_ERROR, "参数为空");
			
		}
		
		return serviceInfoService.forbidServiceInfoById(serviceId);
	}
	
	
	/**
	 * 查看服务信息详情
	 * @return
	 */
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	@ResponseBody()
	public Object detailServiceInfo(
			@RequestParam(value = "service_id") Integer serviceId) throws Exception, RuntimeException {

		if(serviceId == null){
			
			throw new BusinessErrorException(ErrorCodes.PARAM_ERROR, "参数为空");
			
		}
		return serviceInfoService.getServiceInfoById(serviceId);
		
	}
	
	/**
	 * 修改服务信息
	 * @return
	 */
	@RequestMapping(value = "/modify/{serviceId}", method = RequestMethod.PUT)
	@ResponseBody()
	public Object modifyServiceInfo(@PathVariable Integer serviceId,
			@Valid @RequestBody ServiceInfoModifyBean bean) throws Exception, RuntimeException {

		if(serviceId == null){
			
			throw new BusinessErrorException(ErrorCodes.PARAM_ERROR, "参数为空");
			
		}
		ServiceInfo serviceInfo = new ServiceInfo();
		
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		if(bean.getBusinessStart() != null && bean.getBusinessEnd() != null){
			
			Time starttime=new Time(sdf.parse(bean.getBusinessStart()).getTime());
	        Time endtime=new Time(sdf.parse(bean.getBusinessEnd()).getTime());
			serviceInfo.setBusinessStart(starttime);
			serviceInfo.setBusinessEnd(endtime);
		}
        
		BeanUtils.copyProperties(bean, serviceInfo);
		
		return serviceInfoService.modifyServiceInfoById(serviceId, serviceInfo);
	}
	
}
