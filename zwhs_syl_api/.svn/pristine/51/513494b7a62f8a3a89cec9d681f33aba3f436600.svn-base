package cn.org.citycloud.zwhs.syl.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import cn.org.citycloud.zwhs.syl.entity.StoreOrder;

/**
 * 
 * @author Allen
 *
 */
public interface StoreOrderDao extends PagingAndSortingRepository<StoreOrder, Integer> , JpaRepository<StoreOrder, Integer>, JpaSpecificationExecutor<StoreOrder> {

	
	@Query("SELECT sum(a.orderAmount)  FROM StoreOrder a WHERE a.addTime BETWEEN ?1 AND ?2 and a.orderStatus in (20, 30, 40)")
	public Double findOrderAcountAll(Date start, Date end);
	
	
	@Query(value="SELECT *,  region_prov_name as province,region_city_name as city,count(distinct store_id) as storenum,count(*) as ordernum,"
			+ "sum(store_amount) as ordermoney FROM store_order"
			+" group by region_prov_name,region_city_name order by sum(store_amount) desc limit 10 ;", nativeQuery = true)
	public List<StoreOrder> findMoneyTop10();
}
