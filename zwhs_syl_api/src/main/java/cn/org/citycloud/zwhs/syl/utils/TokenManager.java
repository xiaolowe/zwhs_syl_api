package cn.org.citycloud.zwhs.syl.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.auth0.jwt.JWTSigner;

import cn.org.citycloud.zwhs.syl.entity.UserInfo;


public class TokenManager {
	private static TokenManager me = new TokenManager();

	private Map<String, UserInfo> tokens;
	private Map<String, String> userToken;

	public TokenManager() {
		tokens = new ConcurrentHashMap<String, UserInfo>();
		userToken = new ConcurrentHashMap<String, String>();
	}

	/**
	 * 获取单例对象
	 * 
	 * @return
	 */
	public static TokenManager getMe() {
		return me;
	}

	/**
	 * 验证token
	 * 
	 * @param token
	 * @return
	 */
	public UserInfo validate(String token) {
		return tokens.get(token);
	}

	/**
	 * 生成token值
	 * 
	 * @param user
	 * @return
	 */
	public String generateToken(UserInfo user, String secret) {
		JWTSigner jwtSigner = new JWTSigner(secret);
		Map<String, Object> claims = new HashMap<String, Object>();
		claims.put("user", user);
		String token = jwtSigner.sign(claims);
//		userToken.put(user.getId() + "", token);
		tokens.put(token, user);
		return token;
	}
}
