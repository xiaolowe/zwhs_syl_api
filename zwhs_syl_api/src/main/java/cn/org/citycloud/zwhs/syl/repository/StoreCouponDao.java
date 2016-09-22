package cn.org.citycloud.zwhs.syl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import cn.org.citycloud.zwhs.syl.entity.StoreCoupon;

import java.lang.Integer;


/**
 * 
 * @author Allen
 *
 */
public interface StoreCouponDao extends PagingAndSortingRepository<StoreCoupon, Integer> , JpaRepository<StoreCoupon, Integer>, JpaSpecificationExecutor<StoreCoupon> {

	
	
	
}
