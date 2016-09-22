package cn.org.citycloud.zwhs.syl.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import cn.org.citycloud.zwhs.syl.entity.FinAcc;

/**
 * 
 * @author Allen
 *
 */
public interface FinAccDao extends PagingAndSortingRepository<FinAcc, Integer> , JpaRepository<FinAcc, Integer>, JpaSpecificationExecutor<FinAcc> {


	
	@Query("SELECT a FROM FinAcc a WHERE a.accNo = ?1")
	public FinAcc findFinaccByAccNo(Integer accNo);
	
}
