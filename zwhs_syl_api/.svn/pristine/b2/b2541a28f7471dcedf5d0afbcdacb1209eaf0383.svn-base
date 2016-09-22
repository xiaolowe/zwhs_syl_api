package cn.org.citycloud.zwhs.syl.repository;

import cn.org.citycloud.zwhs.syl.entity.RetailMember;
import cn.org.citycloud.zwhs.syl.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * desc the file.
 *
 * @author demon
 * @Date 2016/7/26 10:32
 */
public interface RetailMemberDao extends PagingAndSortingRepository<RetailMember, Integer>, JpaRepository<RetailMember, Integer>, JpaSpecificationExecutor<RetailMember> {
    /**
     * 根据店铺Id查询分销会员
     *
     * @param store
     * @return
     */
    List<RetailMember> findByStore(Store store);
}
