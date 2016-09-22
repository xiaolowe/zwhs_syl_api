package cn.org.citycloud.zwhs.syl.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.org.citycloud.zwhs.syl.entity.RegionInfo;
import cn.org.citycloud.zwhs.syl.service.RegionInfoService;


@Controller
@RequestMapping("regionInfo")
public class RegionInfoController {
	
	@Autowired
	private RegionInfoService regionInfoService;
	
	
	/**
	 * 获取所有省
	 * @return
	 */
	@RequestMapping(value = "/getProvince", method = RequestMethod.GET)
	@ResponseBody()
	public Object getProvince() throws Exception, RuntimeException {
		
		List<RegionInfo> list = regionInfoService.getRegionProvince();

		return list;
	}
	
	
	/**
	 * 获取所有市
	 * @return
	 */
	@RequestMapping(value = "/getCity", method = RequestMethod.GET)
	@ResponseBody()
	public Object getCity(@RequestParam("region_code") String regionCode ) throws Exception, RuntimeException {
		
		String code = regionCode.substring(0, 2);
		
		List<RegionInfo> list = regionInfoService.getRegionCity(Integer.valueOf(code));

		return list;
	}
	
	/**
	 * 获取所有区县
	 * @return
	 */
	@RequestMapping(value = "/getArea", method = RequestMethod.GET)
	@ResponseBody()
	public Object getArea(@RequestParam("region_code") String regionCode ) throws Exception, RuntimeException {
		
		String code = regionCode.substring(0, 4);
		
		List<RegionInfo> list = regionInfoService.getRegionArea(Integer.valueOf(code));

		return list;
	}
	
	
}
