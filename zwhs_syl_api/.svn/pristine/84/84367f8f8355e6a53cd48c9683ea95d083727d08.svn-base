package cn.org.citycloud.zwhs.syl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import cn.org.citycloud.zwhs.syl.entity.ServiceStore;

public interface ServiceStoreDao extends PagingAndSortingRepository<ServiceStore, Integer> ,JpaRepository<ServiceStore, Integer>,
JpaSpecificationExecutor<ServiceStore> {
	
	public long countByStoreId(int store_id);

}
