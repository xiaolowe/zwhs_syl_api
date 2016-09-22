package cn.org.citycloud.zwhs.syl.service;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.org.citycloud.zwhs.syl.entity.Brand;
import cn.org.citycloud.zwhs.syl.repository.BrandDao;



//Spring Bean的标识.
@Component
// 类中所有public函数都纳入事务管理的标识.
@Transactional
public class BrandService {
	@Autowired
	private BrandDao brandDao;
	
	/**
	 * 查找品牌列表
	 * @return
	 */
	public List<Brand> getBrandListAll(){
		
		
		return brandDao.findBrandListAll();
	}
	
	
	/**
	 * 动态查询商品列表
	 * @param pageable
	 * @param goodsCommon
	 * @return
	 */
	public Page<Brand> getBrandList(Pageable pageable, Brand brand){
		
		Page<Brand> page = brandDao.findAll(new Specification<Brand>() {
			@Override
			public Predicate toPredicate(Root<Brand> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				
				Predicate where = cb.conjunction();  
		        
				if(brand != null && brand.getBrandNo() != null){
					Path<String> brandNo = root.get("brandNo");  
					where = cb.and(where, cb.equal(brandNo, brand.getBrandNo())); 
					
				}
				if(brand != null && StringUtils.isNotBlank(brand.getBrandName())){
					Path<String> brandName = root.get("brandName");  
					where = cb.and(where, cb.like(brandName, "%"+brand.getBrandName()+"%"));
				}
				query.where(where);
				  
			    return null;  
			}
		}, pageable);
		
	    return page;
	}
	/**
	 * 添加品牌
	 * @param brand
	 */
	public void addBrand(Brand brand){
		brand.setBrandSort(0);
		brand.setBrandStat(0);
		brandDao.save(brand);
	}
	
	/**
	 * 修改品牌
	 * @param brandNo
	 * @param brand
	 */
	public void modifyBrand(Integer brandNo, Brand brand){
		Brand brandUpdate = brandDao.findOne(brandNo);
		if(brand != null && StringUtils.isNotBlank(brand.getBrandName())){
			brandUpdate.setBrandName(brand.getBrandName());
		}
		if(brand != null && StringUtils.isNotBlank(brand.getContactsName())){
			brandUpdate.setContactsName(brand.getContactsName());
		}
		if(brand != null && brand.getGoodsSource() != null){
			brandUpdate.setGoodsSource(brand.getGoodsSource());
		}
		if(brand != null && StringUtils.isNotBlank(brand.getBrandPic())){
			brandUpdate.setBrandPic(brand.getBrandPic());
		}
		Date now = new Date();
		brandUpdate.setUpdDate(now);
		
		brandDao.save(brandUpdate);
	}
	
	/**
	 * 查找品牌信息
	 * @param brandNo
	 * @return
	 */
	public Brand getBrandByBrandNo(Integer brandNo){
		
		return brandDao.findByBrandNo(brandNo);
	}
	
	/**
	 * 查找品牌信息
	 * @param brandName
	 * @return
	 */
	public Brand getBrandByBrandName(String brandName){
		
		return brandDao.findByBrandName(brandName);
	}
	
	
}
