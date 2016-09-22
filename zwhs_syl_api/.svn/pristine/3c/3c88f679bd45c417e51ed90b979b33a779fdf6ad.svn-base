package cn.org.citycloud.zwhs.syl.controller;
import java.util.Map;
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
import cn.org.citycloud.zwhs.syl.bean.ServiceProviderSearchBean;
import cn.org.citycloud.zwhs.syl.constants.ErrorCodes;
import cn.org.citycloud.zwhs.syl.entity.ServiceProvider;
import cn.org.citycloud.zwhs.syl.exception.BusinessErrorException;
import cn.org.citycloud.zwhs.syl.service.ServiceProviderService;


@Controller
@RequestMapping("serviceprovider")
public class ServiceProviderController {
	
	@Autowired
	private ServiceProviderService serviceProviderService;
	
	
	/**
	 * 获取服务商列表
	 * 列表
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody()
	public Object getServiceInfoList(@Valid ServiceProviderSearchBean bean) throws Exception, RuntimeException {

		Sort sort = new Sort(Direction.DESC, "providerId");
	    Pageable pageable = new PageRequest(bean.getPageNo() - 1, bean.getPageSize(), sort);
	    
	    ServiceProvider serviceProvider = new ServiceProvider();
	    serviceProvider.setCompanyName(bean.getCompanyName());
	    serviceProvider.setProviderState(bean.getProvider_state());
	    
		Page<ServiceProvider> list = serviceProviderService.getServiceProviderList(pageable, serviceProvider);
		return list;
	}
	
	
	/**
	 * 审核、驳回、冻结服务商信息
	 * @return
	 */
	@RequestMapping(value = "/check/{providerId}", method = RequestMethod.PUT)
	@ResponseBody()
	public Object checkServiceInfo(@PathVariable Integer providerId,
			@RequestBody Map<String, Object> params) throws Exception, RuntimeException {

		Integer providerState = (Integer)params.get("provider_state");
		
		if(providerId == null && providerState == null){
			
			throw new BusinessErrorException(ErrorCodes.PARAM_ERROR, "参数为空");
			
		}
		
		return serviceProviderService.checkServiceProviderById(providerId, providerState);
	}
	
	
	/**
	 * 查看服务信息详情
	 * @return
	 */
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	@ResponseBody()
	public Object detailServiceInfo(
			@RequestParam(value = "provider_id") Integer providerId) throws Exception, RuntimeException {

		if(providerId == null){
			
			throw new BusinessErrorException(ErrorCodes.PARAM_ERROR, "参数为空");
			
		}
		return serviceProviderService.getServiceProviderById(providerId);
		
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
