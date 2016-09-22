package cn.org.citycloud.zwhs.syl.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import cn.org.citycloud.zwhs.syl.entity.GoodsClass;
import java.lang.Integer;


/**
 * 
 * @author Allen
 *
 */
public interface GoodsClassDao extends PagingAndSortingRepository<GoodsClass, Integer> , JpaRepository<GoodsClass, Integer>, JpaSpecificationExecutor<GoodsClass> {

	/**
	 * 查找商品一级分类
	 * @return
	 */
	@Query(value = "SELECT * FROM goods_class a WHERE a.gc_parent_id = ?1 ", nativeQuery = true)
	public List<GoodsClass> findGoodClassByPid(Integer parentId);
	
	/**
	 * 通过父分类查找分类信息
	 * @param gcparentid
	 * @return
	 */
	List<GoodsClass> findByGcParentId(Integer gcparentid);
	
	
	@Query("SELECT a FROM GoodsClass a WHERE a.gcNo = ?1")
	public GoodsClass findGoodsClassByGcNo(Integer gcNo);
	
	
	
}
