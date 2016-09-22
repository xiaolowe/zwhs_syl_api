package cn.org.citycloud.zwhs.syl.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import cn.org.citycloud.zwhs.syl.entity.UserInfo;


/**
 * 
 * @author Allen
 *
 */
public interface UserInfoDao extends PagingAndSortingRepository<UserInfo, Integer> , JpaRepository<UserInfo, Integer>, JpaSpecificationExecutor<UserInfo> {

	@Query(value = "SELECT * FROM user_info a where a.user_name = ?1 and a.user_pwd = ?2", nativeQuery = true)
	public UserInfo findUserInfoByNameAndPass(String userName, String userPwd);
	
	
	@Query("SELECT a FROM UserInfo a WHERE a.userId = ?1 ")
	public UserInfo findUserInfo(Integer userId);
	
	
}
