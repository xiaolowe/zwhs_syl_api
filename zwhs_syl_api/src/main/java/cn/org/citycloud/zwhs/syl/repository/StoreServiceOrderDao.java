package cn.org.citycloud.zwhs.syl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import cn.org.citycloud.zwhs.syl.entity.StoreServiceOrder;

/**
 * 
 * @author Allen
 *
 */
public interface StoreServiceOrderDao extends PagingAndSortingRepository<StoreServiceOrder, Integer> , JpaRepository<StoreServiceOrder, Integer>, JpaSpecificationExecutor<StoreServiceOrder> {

	
}
