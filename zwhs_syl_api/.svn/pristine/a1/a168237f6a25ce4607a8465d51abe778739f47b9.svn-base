package cn.org.citycloud.zwhs.syl.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.org.citycloud.zwhs.syl.entity.RoleInfo;
import cn.org.citycloud.zwhs.syl.service.RoleInfoService;


@Controller
@RequestMapping("roleinfo")
public class RoleInfoController {
	
	@Autowired
	private RoleInfoService roleInfoService;
	
	/**
	 * 获取权限列表
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody()
	public Object getRoleInfoList() throws Exception, RuntimeException {
		
		List<RoleInfo>	list = roleInfoService.getRoleInfo();
		return list;
	}
	
	
}
