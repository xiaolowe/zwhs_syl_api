package cn.org.citycloud.zwhs.syl.controller;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.auth0.jwt.JWTSigner;
import cn.org.citycloud.zwhs.syl.bean.UserToken;
import cn.org.citycloud.zwhs.syl.constants.Constants;
import cn.org.citycloud.zwhs.syl.constants.ErrorCodes;
import cn.org.citycloud.zwhs.syl.entity.UserInfo;
import cn.org.citycloud.zwhs.syl.exception.BusinessErrorException;
import cn.org.citycloud.zwhs.syl.service.UserInfoService;
import net.rubyeye.xmemcached.MemcachedClient;


@Controller
public class UserInfoController {

	@Autowired
	UserInfoService userinfoService;
	
	@Autowired
	MemcachedClient memcachedClient;
	
	@RequestMapping(value = "/authentication/login", method = RequestMethod.POST)
	@ResponseBody()
	public Object login(@RequestBody Map<String, String> paramMap,
			HttpServletRequest request,HttpServletResponse response) throws Exception, RuntimeException {
		
		String userName = paramMap.get("user_name");
		String userPwd = paramMap.get("user_pwd");
		
		if(StringUtils.isEmpty(userName) || StringUtils.isEmpty(userPwd)) {
			throw new BusinessErrorException(ErrorCodes.PARAM_ERROR);
		}

		UserInfo userInfo = userinfoService.getUserInfoByNameAndPwd(userName, userPwd);
		if(userInfo == null){
			throw new BusinessErrorException(ErrorCodes.NO_DATA, "用户名或密码错误");
		}
		if(userInfo != null && userInfo.getUserState() == 0){
			throw new BusinessErrorException(ErrorCodes.OPERATION_ERROR, "该用户已经被禁用");
		}
		// 生成登录用Token
		String token = generateToken(paramMap, Constants.TOKEN_SECRET);
		
		// 将Token存入Memcached
		UserToken tokenEntity = new UserToken();
		tokenEntity.setToken(token);
		tokenEntity.setCreateTs(System.currentTimeMillis());
		tokenEntity.setUserId(userInfo.getUserId());
		tokenEntity.setUserName(userInfo.getUserName());
		tokenEntity.setExpiresIn(Constants.TOKEN_EXPIRES_IN);
		
		memcachedClient.set(token, Integer.parseInt(String.valueOf(Constants.TOKEN_EXPIRES_IN)), tokenEntity);
		
		Map<String, String> rstMap = new HashMap<String, String>();
		rstMap.put("user_id", String.valueOf(userInfo.getUserId()));
		rstMap.put("user_name", userInfo.getUserName());
		rstMap.put("zwhs_token", token);
		rstMap.put("role_id", userInfo.getRoleId().toString());
		rstMap.put("expires_in", String.valueOf(Constants.TOKEN_EXPIRES_IN));
		return rstMap;
		

	}
	
	/**
	 * 添加用户
	 * @return
	 */
	@RequestMapping(value = "/userinfo/add", method = RequestMethod.POST)
	@ResponseBody()
	public Object addUserInfo(@RequestBody Map<String, Object> params) throws Exception, RuntimeException {

		String userName = (String)params.get("user_name");
		String userPwd = (String)params.get("user_pwd");
		String userTruename = (String)params.get("user_truename");
		String userPhone = (String)params.get("user_phone");
		Integer roleId = (Integer)params.get("role_id");
		
		if(userName == null || userPwd ==null || userTruename == null
			|| userPhone == null || roleId == null  ){
			
			throw new BusinessErrorException(ErrorCodes.PARAM_ERROR, "参数为空");
			
		}
		UserInfo usercheck = userinfoService.getUserInfoByUserName(userName);
		
		if(usercheck != null){
			throw new BusinessErrorException(ErrorCodes.REPEAT_ERROR, "该用户名已经存在");
		}
		
		Integer userState = 1;  //默认正常
		Date now = new Date();
		
		UserInfo userInfo = new UserInfo(now, roleId, userName, userPhone,
				userPwd, userState, userTruename);
		
		UserInfo user = userinfoService.addUserInfo(userInfo);
		
		return user;
	}
	
	/**
	 * 列表
	 * @return
	 */
	@RequestMapping(value = "/userinfo/list", method = RequestMethod.GET)
	@ResponseBody()
	public Object getUsers(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
	        @RequestParam(value = "pageSize", defaultValue = "10")  Integer pageSize,
	        @RequestParam(value = "role_id", required = false)  Integer roleId,
	        @RequestParam(value = "user_state", required = false)  Integer userState,
	        @RequestParam(value = "user_truename", required = false) String userTruename) throws Exception, RuntimeException {

		Sort sort = new Sort(Direction.DESC, "userId");
	    Pageable pageable = new PageRequest(pageNo - 1, pageSize, sort);
	    UserInfo userInfo = new UserInfo();
	    userInfo.setRoleId(roleId);
	    userInfo.setUserState(userState);
	    userInfo.setUserTruename(userTruename);
	    Page<UserInfo> list = userinfoService.getUserInfoList(pageable, userInfo);
	    
		return list;
	}
	
	
	/**
	 * 编辑用户
	 * @return
	 */
	@RequestMapping(value = "/userinfo/modify", method = RequestMethod.PUT)
	@ResponseBody()
	public Object modifyUserInfo(@RequestBody Map<String, Object> params) throws Exception, RuntimeException {

		Integer userId = (Integer)params.get("user_id");
		String userName = (String)params.get("user_name");
		String userPwd = (String)params.get("user_pwd");
		String userTruename = (String)params.get("user_truename");
		String userPhone = (String)params.get("user_phone");
		Integer userState = (Integer)params.get("user_state");
		Integer roleId = (Integer)params.get("role_id");
		
		if(userId == null ){
			
			throw new BusinessErrorException(ErrorCodes.PARAM_ERROR, "参数为空");
			
		}
		Date now = new Date();
		
		UserInfo userInfo = new UserInfo(userId, now, roleId, userName, userPhone,
				userPwd, userState, userTruename);
		
		UserInfo user = userinfoService.modifyUserInfo(userId, userInfo);
		
		return user;
	}
	
	

	/**
	 * 查看用户信息
	 * @return
	 */
	@RequestMapping(value = "/userinfo/detail", method = RequestMethod.GET)
	@ResponseBody()
	public Object detailUserInfo( @RequestParam(value = "user_id")  Integer userId) throws Exception, RuntimeException {

		
		if(userId == null ){
			
			throw new BusinessErrorException(ErrorCodes.PARAM_ERROR, "参数为空");
			
		}
		
		UserInfo userInfo = userinfoService.getUserInfo(userId);
		
		return userInfo;
	}


	
	/**
	 * 生成token值
	 * 
	 * @param user
	 * @return
	 */
	private String generateToken(Map<String, String> user, String secret) {
		JWTSigner jwtSigner = new JWTSigner(secret);
		Map<String, Object> claims = new HashMap<String, Object>();
		
		claims.put("userName", user.get("user_name"));
		claims.put("crtime", System.currentTimeMillis());
		String token = jwtSigner.sign(claims);
		
		return token;
	}
	

	
}
