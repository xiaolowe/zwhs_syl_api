package cn.org.citycloud.zwhs.syl.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import cn.org.citycloud.zwhs.syl.entity.GoodsCommon;


/**
 * 
 * @author Allen
 *
 */
public interface GoodsCommonDao extends PagingAndSortingRepository<GoodsCommon, Integer> , JpaRepository<GoodsCommon, Integer>, JpaSpecificationExecutor<GoodsCommon> {

	/**
	 * 通过商品编号获取商品信息
	 * @param goodsId
	 * @return
	 */
	List<GoodsCommon> findByGoodsId(Integer goodsid);
	
	@Query("SELECT a FROM GoodsCommon a WHERE a.goodsSn = ?1 ")
	GoodsCommon findGoodsCommonByGoodsSn(String goodsSn);
	
	@Query("SELECT a FROM GoodsCommon a WHERE a.goodsId <> ?1 and a.goodsSn = ?2 ")
	GoodsCommon findGoodsCommonByGoodsSn(Integer goodsId, String goodsSn);
	
	@Query(value="select count(1) from goods_common a where a.goods_verify = 0", nativeQuery = true)
	Long findGoodsCommonByunCheckState();
	
	
}
