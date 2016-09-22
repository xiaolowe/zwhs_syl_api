package cn.org.citycloud.zwhs.syl.repository;

import cn.org.citycloud.zwhs.syl.entity.StoreNew;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * desc the file.
 *
 * @author demon
 * @Date 2016/8/7 18:37
 */
public interface StoreNewDao extends PagingAndSortingRepository<StoreNew, Integer>, JpaRepository<StoreNew, Integer>, JpaSpecificationExecutor<StoreNew> {
}
