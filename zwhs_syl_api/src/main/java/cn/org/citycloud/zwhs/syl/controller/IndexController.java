package cn.org.citycloud.zwhs.syl.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class IndexController {
	
	/**
	 * 列表
	 * @return
	 */
	@RequestMapping(value = "/index/api", method = RequestMethod.GET)
	public Object getIndex() throws Exception, RuntimeException {

		return "index";
	}
	
	
	
}
