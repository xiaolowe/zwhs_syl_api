package cn.org.citycloud.zwhs.syl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import cn.org.citycloud.zwhs.syl.bean.TopBean;
import cn.org.citycloud.zwhs.syl.entity.StoreOrder;

/**
 * 
 * @author Alden
 *
 */
public interface TopOrderDao extends  JpaRepository<StoreOrder, Integer>, JpaSpecificationExecutor<StoreOrder> {

	
	
	@Query(value="SELECT  region_prov_name as province,region_city_name as city,count(distinct store_id) as storenum,count(*) as ordernum,"
			+ "sum(store_amount) as ordermoney FROM store_order"
			+" group by region_prov_name,region_city_name order by sum(store_amount) desc limit 10 ;", nativeQuery = true)
	public List<TopBean> findMoneyTop10();
}
