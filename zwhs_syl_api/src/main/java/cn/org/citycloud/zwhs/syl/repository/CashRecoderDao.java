package cn.org.citycloud.zwhs.syl.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import cn.org.citycloud.zwhs.syl.entity.CashRecoder;

/**
 * 
 * @author Allen
 *
 */
public interface CashRecoderDao extends PagingAndSortingRepository<CashRecoder, Integer> , JpaRepository<CashRecoder, Integer>, JpaSpecificationExecutor<CashRecoder> {

	
	@Query(value="select count(1) from cash_recoder c where c.confirm_stat = 0", nativeQuery = true)
	public Long findCashByUncheck();
	
	@Query(value="select count(1) from cash_recoder c where c.confirm_stat = 1", nativeQuery = true)
	public Long findCashByUnPay();
	
}
