package cn.org.citycloud.zwhs.syl.controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.org.citycloud.zwhs.syl.core.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 消息接口
 * @author Allen
 *
 */
@RestController
@Api(tags="消息", value = "/message",  description = "消息接口", consumes="application/json")
public class MessageController extends BaseController{

	
	
	

	/**
	 * 查看系统消息
	 * @param bean
	 */
	@RequestMapping(value = "/message/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "查看系统消息", notes = "查看系统消息")
	public Object getMessage(@ApiParam(value = "消息Id", required = true) @PathVariable int id) {
		
//		Message message = messageDao.findOne(id);
//		message.setStatus(1);  //0 未读    1 已读
//
//		return messageDao.save(message);
		return null;
	}
	
	/**
	 * 查看站内信消息
	 * @param bean
	 */
	@RequestMapping(value = "/mailmessage/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "查看站内信消息", notes = "查看站内信消息")
	public Object getMailMessage(@ApiParam(value = "站内信消息Id", required = true) @PathVariable int id) {
		
//		MailMessage mailmessage = mailmessageDao.findOne(id);
//		mailmessage.setStatus(1);  //0 未读    1 已读
//
//		return mailmessageDao.save(mailmessage);
		return null;
	}
	
	
	

}
