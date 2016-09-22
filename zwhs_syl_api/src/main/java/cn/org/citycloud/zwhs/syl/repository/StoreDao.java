package cn.org.citycloud.zwhs.syl.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import cn.org.citycloud.zwhs.syl.entity.Store;

/**
 * 
 * @author Allen
 *
 */
public interface StoreDao extends PagingAndSortingRepository<Store, Integer> , JpaRepository<Store, Integer>, JpaSpecificationExecutor<Store> {

	@Query("select a from Store a")
	public Page<Store> findStoreList(Pageable pageable);
	
	@Modifying
	@Query(value="update store s set s.commis_rates = ?1 where s.sg_id = ?2 ", nativeQuery = true)
	public void updateStoreCommisBySgId(Double commis_rates, Integer sgId);
	
	
	@Query(value="select count(1) from store s where s.store_state = 0", nativeQuery = true)
	public Long findStoreByUncheck();
	
	
}
