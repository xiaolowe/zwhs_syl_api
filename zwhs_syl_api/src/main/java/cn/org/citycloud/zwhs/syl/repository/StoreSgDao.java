package cn.org.citycloud.zwhs.syl.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import cn.org.citycloud.zwhs.syl.entity.StoreSg;


/**
 * 
 * @author Allen
 *
 */
public interface StoreSgDao extends PagingAndSortingRepository<StoreSg, Integer> , JpaRepository<StoreSg, Integer>, JpaSpecificationExecutor<StoreSg> {
	
	/**
	 * 根据店铺等级id查找店铺等级信息
	 * @param storeId
	 * @return
	 */
	@Query(value = "SELECT * FROM store_sg s WHERE s.sg_id = ?1", nativeQuery = true)
	public StoreSg findStoreSgBySgId(Integer sgId);
}
