package cn.org.citycloud.zwhs.syl.core;

import cn.org.citycloud.zwhs.syl.bean.UserToken;

/**
 * 控制器基类
 * 
 * @author lanbo
 *
 */
public class BaseController {


	private int userId;
	
	private String userName;
	
	
	private String token;
	
	
	private UserToken userToken;



	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public UserToken getUserToken() {
		return userToken;
	}

	public void setUserToken(UserToken userToken) {
		this.userToken = userToken;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	

}
