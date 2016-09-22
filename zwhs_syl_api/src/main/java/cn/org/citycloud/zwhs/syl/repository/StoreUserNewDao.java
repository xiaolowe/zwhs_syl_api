package cn.org.citycloud.zwhs.syl.repository;

import cn.org.citycloud.zwhs.syl.entity.StoreUserNew;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * desc the file.
 *
 * @author demon
 * @Date 2016/8/7 18:36
 */
public interface StoreUserNewDao extends PagingAndSortingRepository<StoreUserNew, Integer>, JpaRepository<StoreUserNew, Integer>, JpaSpecificationExecutor<StoreUserNew> {
}
