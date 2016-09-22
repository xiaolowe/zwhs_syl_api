package cn.org.citycloud.zwhs.syl.repository;

import cn.org.citycloud.zwhs.syl.entity.RetailShop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * desc the file.
 *
 * @author demon
 * @Date 2016/7/26 10:33
 */
public interface RetailShopDao extends PagingAndSortingRepository<RetailShop, Integer>, JpaRepository<RetailShop, Integer>, JpaSpecificationExecutor<RetailShop> {
    RetailShop findByMemberId(int memberId);
}
