package cn.org.citycloud.zwhs.syl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import cn.org.citycloud.zwhs.syl.entity.Brand;
import java.lang.Integer;
import java.lang.String;


/**
 * 
 * @author Allen
 *
 */
public interface BrandDao extends PagingAndSortingRepository<Brand, Integer> , JpaRepository<Brand, Integer>, JpaSpecificationExecutor<Brand> {

	/**
	 * 查找品牌列表
	 * @return
	 */
	@Query(value = "SELECT * FROM brand b", nativeQuery = true)
	public List<Brand> findBrandListAll();
	
	/**
	 * 根据品牌号查找品牌信息
	 * @param brandno
	 * @return
	 */
	@Query(value = "SELECT * FROM brand b WHERE b.brand_no = ?1", nativeQuery = true)
	Brand findByBrandNo(Integer brandno);
	
	/**
	 * 根据品牌号查找品牌信息
	 * @param brandno
	 * @return
	 */
	@Query("SELECT b FROM Brand b WHERE b.brandName = ?1")
	Brand findByBrandName(String brandName);
	
	
	
}
