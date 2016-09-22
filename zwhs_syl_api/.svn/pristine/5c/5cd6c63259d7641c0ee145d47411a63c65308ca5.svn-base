package cn.org.citycloud.zwhs.syl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import cn.org.citycloud.zwhs.syl.entity.RoleInfo;


/**
 * 
 * @author Allen
 *
 */
public interface RoleInfoDao extends PagingAndSortingRepository<RoleInfo, Integer> , JpaRepository<RoleInfo, Integer>, JpaSpecificationExecutor<RoleInfo> {

	@Query(value = "SELECT * FROM role_info r", nativeQuery = true)
	List<RoleInfo> findRoleInfoList();
}
