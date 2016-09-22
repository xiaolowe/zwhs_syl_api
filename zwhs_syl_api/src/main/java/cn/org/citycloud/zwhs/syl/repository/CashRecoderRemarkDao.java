package cn.org.citycloud.zwhs.syl.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import cn.org.citycloud.zwhs.syl.entity.CashRecoderRemark;
/**
 * 
 * @author Allen
 *
 */
public interface CashRecoderRemarkDao extends PagingAndSortingRepository<CashRecoderRemark, Integer> , JpaRepository<CashRecoderRemark, Integer>, JpaSpecificationExecutor<CashRecoderRemark> {

	@Query("SELECT a FROM CashRecoderRemark a WHERE a.cashNo = ?1 ")
	public CashRecoderRemark findRemarkByCashNo(Integer cashNo);
}
