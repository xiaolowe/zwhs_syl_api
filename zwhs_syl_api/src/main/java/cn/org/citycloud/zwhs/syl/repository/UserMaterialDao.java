package cn.org.citycloud.zwhs.syl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import cn.org.citycloud.zwhs.syl.entity.UserMaterial;

import java.lang.Integer;


/**
 * 
 * @author Allen
 *
 */
public interface UserMaterialDao extends PagingAndSortingRepository<UserMaterial, Integer> , JpaRepository<UserMaterial, Integer>, JpaSpecificationExecutor<UserMaterial> {

	
	
}
