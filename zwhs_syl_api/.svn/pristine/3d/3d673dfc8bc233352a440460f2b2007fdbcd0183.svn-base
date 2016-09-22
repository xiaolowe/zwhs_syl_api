package cn.org.citycloud.zwhs.syl.service;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import cn.org.citycloud.zwhs.syl.entity.StoreUser;
import cn.org.citycloud.zwhs.syl.repository.StoreUserDao;

/**
 * 
 * @author Allen
 *
 */

//Spring Bean的标识.
@Component
// 类中所有public函数都纳入事务管理的标识.
@Transactional
public class StoreUserService {
	@Autowired
	private StoreUserDao storeUserDao;
	
	
	/**
	 * 修改店铺密码
	 * @param storeId
	 * @param storeUser
	 * @return
	 */
	public StoreUser modifyStoreUser(Integer storeId, StoreUser storeUser){
		
		StoreUser storeUserupdate = storeUserDao.findOne(storeId);
		if(storeUser != null && StringUtils.isNotBlank(storeUser.getUserPwd())){
			storeUserupdate.setUserPwd(storeUser.getUserPwd());
		}
		if(storeUser != null && storeUser.getUpdDate() != null){
			storeUserupdate.setUpdDate(storeUser.getUpdDate());
		}
		
		
		return storeUserDao.save(storeUserupdate);
	}
	
	
}
