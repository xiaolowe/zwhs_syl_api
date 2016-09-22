package cn.org.citycloud.zwhs.syl.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import cn.org.citycloud.zwhs.syl.entity.StoreGood;
import java.lang.Integer;
import java.util.List;

/**
 * 
 * @author Allen
 *
 */
public interface StoreGoodDao extends PagingAndSortingRepository<StoreGood, Integer> , JpaRepository<StoreGood, Integer>, JpaSpecificationExecutor<StoreGood> {
}
