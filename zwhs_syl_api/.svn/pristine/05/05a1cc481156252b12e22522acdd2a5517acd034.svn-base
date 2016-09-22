package cn.org.citycloud.zwhs.syl.service;

import java.util.Date;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.org.citycloud.zwhs.syl.entity.UserInfo;
import cn.org.citycloud.zwhs.syl.repository.UserInfoDao;



//Spring Bean的标识.
@Component
// 类中所有public函数都纳入事务管理的标识.
@Transactional
public class UserInfoService {
	@Autowired
	private UserInfoDao userInfoDao;
	
	
	/**
	 * 用户登录
	 * @param userName
	 * @param userPwd
	 * @return
	 */
	public UserInfo getUserInfoByNameAndPwd(String userName, String userPwd) {
		
		return userInfoDao.findUserInfoByNameAndPass(userName, userPwd);
		
	}
	/**
	 * 添加用户
	 * @param userInfo
	 */
	public UserInfo addUserInfo(UserInfo userInfo){
		
		UserInfo user = userInfoDao.save(userInfo);
		userInfoDao.flush();
		return user;
	}
	
	/**
	 * 编辑用户
	 * @param userInfo
	 */
	public UserInfo modifyUserInfo(Integer userId, UserInfo userInfo){
		
		UserInfo user = userInfoDao.findOne(userId);
		if(userInfo != null && userInfo.getUserName() != null){
			user.setUserName(userInfo.getUserName());
		}
		if(userInfo != null && userInfo.getUserPwd() != null){
			user.setUserPwd(userInfo.getUserPwd());
		}
		if(userInfo != null && userInfo.getUserTruename() != null){
			user.setUserTruename(userInfo.getUserTruename());
		}
		if(userInfo != null && userInfo.getUserPhone() != null){
			user.setUserPhone(userInfo.getUserPhone());
		}
		if(userInfo != null && userInfo.getRoleId() != null){
			user.setRoleId(userInfo.getRoleId());
		}
		if(userInfo != null && userInfo.getUserState() != null){
			user.setUserState(userInfo.getUserState());
		}
		Date now = new Date();
		user.setUpdDate(now);
		
		return userInfoDao.save(user);
				
	}
	
	public UserInfo getUserInfo(Integer userId){
		
		UserInfo userInfo = userInfoDao.findUserInfo(userId);
		return userInfo;
	}

	/**
	 * 动态查询用户列表
	 * @param pageable
	 * @param userInfo
	 * @return
	 */
	public Page<UserInfo> getUserInfoList(Pageable pageable, UserInfo userInfo){
		
		Page<UserInfo> page = userInfoDao.findAll(new Specification<UserInfo>() {
			@Override
			public Predicate toPredicate(Root<UserInfo> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				
				Predicate where = cb.conjunction();  
		        
				if(userInfo != null && StringUtils.isNotBlank(userInfo.getUserTruename())){
					Path<String> userTruename = root.get("userTruename");  
					where = cb.and(where, cb.like(userTruename, "%"+ userInfo.getUserTruename()+"%"));
				}
				if(userInfo != null && userInfo.getRoleId() != null){
					Path<String> roleId = root.get("roleId");  
					where = cb.and(where, cb.equal(roleId, userInfo.getRoleId())); 
					
				}
				if(userInfo != null && userInfo.getUserState() != null){
					Path<String> userState = root.get("userState");  
					where = cb.and(where, cb.equal(userState, userInfo.getUserState())); 
					
				}
				query.where(where);
				
			    return null;   
			}
		}, pageable);
		
	    return page;
	}
	
	/**
	 * 根据用户名查询用户信息
	 * @param userName
	 * @return
	 */
	public UserInfo getUserInfoByUserName(String userName){
		
		UserInfo userInfo = userInfoDao.findOne(new Specification<UserInfo>() {
				@Override
				public Predicate toPredicate(Root<UserInfo> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
					Predicate where = cb.conjunction();  
			        
					if(userName != null){
						Path<String> name = root.get("userName");  
						where = cb.and(where, cb.equal(name, userName));
					}
					
					query.where(where);
					
				    return null;   
				}
			});
		
		return userInfo;
	}
}
