package cn.org.citycloud.zwhs.syl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import cn.org.citycloud.zwhs.syl.entity.ServiceInfo;
import java.lang.Integer;


/**
 * 
 * @author Allen
 *
 */
public interface ServiceInfoDao extends PagingAndSortingRepository<ServiceInfo, Integer> , JpaRepository<ServiceInfo, Integer>, JpaSpecificationExecutor<ServiceInfo> {

	
	
	
}
