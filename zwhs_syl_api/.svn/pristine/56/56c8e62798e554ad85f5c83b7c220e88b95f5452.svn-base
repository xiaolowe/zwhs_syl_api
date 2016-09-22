package cn.org.citycloud.zwhs.syl.repository;

import cn.org.citycloud.zwhs.syl.entity.RetailShopGood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * desc the file.
 *
 * @author demon
 * @Date 2016/7/26 14:06
 */
public interface RetailShopGoodsDao extends PagingAndSortingRepository<RetailShopGood, Integer>, JpaRepository<RetailShopGood, Integer>, JpaSpecificationExecutor<RetailShopGood> {
    List<RetailShopGood> findByMemberId(int memberId);
}
