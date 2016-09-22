package cn.org.citycloud.zwhs.syl.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import cn.org.citycloud.zwhs.syl.entity.RoleInfo;
import cn.org.citycloud.zwhs.syl.repository.RoleInfoDao;

/**
 * 
 * @author Allen
 *
 */
//Spring Bean的标识.
@Component
// 类中所有public函数都纳入事务管理的标识.
@Transactional
public class RoleInfoService {
	
	@Autowired
	private RoleInfoDao roleInfoDao;
	
	/**
	 * 获取角色列表
	 * @return
	 */
	public List<RoleInfo> getRoleInfo(){
		
		return roleInfoDao.findRoleInfoList();
	}
	
	
	
}
