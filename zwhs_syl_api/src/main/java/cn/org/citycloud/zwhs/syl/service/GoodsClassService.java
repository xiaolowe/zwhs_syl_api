package cn.org.citycloud.zwhs.syl.service;
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
import cn.org.citycloud.zwhs.syl.entity.GoodsClass;
import cn.org.citycloud.zwhs.syl.repository.GoodsClassDao;



//Spring Bean的标识.
@Component
// 类中所有public函数都纳入事务管理的标识.
@Transactional
public class GoodsClassService {
	@Autowired
	private GoodsClassDao goodsClassDao;
	
	/**
	 * 查找一级商品分类
	 * @return
	 */
	public List<GoodsClass> getGoodClassByPid(Integer parentId){
		
		return goodsClassDao.findGoodClassByPid(parentId);
	}
	
	/**
	 * 添加分类
	 * @param goodsClass
	 * @return
	 */
	public GoodsClass addGoodsClass(GoodsClass goodsClass){
		
		return goodsClassDao.save(goodsClass);
	}
	
	/**
	 * 更新分类信息
	 * @param gcNo
	 * @param goodsClass
	 * @return
	 */
	public GoodsClass modifyGoodsClass(Integer gcNo, GoodsClass goodsClass){
		GoodsClass class1 = goodsClassDao.findOne(gcNo);
		if(StringUtils.isNotBlank(goodsClass.getGcName())){
			class1.setGcName(goodsClass.getGcName());
		}
		if(StringUtils.isNotBlank(goodsClass.getGcTitle())){
			class1.setGcTitle(goodsClass.getGcTitle());
		}
		if(goodsClass.getGcSort() != null){
			class1.setGcSort(goodsClass.getGcSort());
		}
		
		return goodsClassDao.save(class1);
	}
	
	/**
	 * 通过父分类查找分类信息
	 * @param gcNo
	 * @return
	 */
	public List<GoodsClass> getGoodsClassByParentId(Integer gcNo){
		
		List<GoodsClass> list = goodsClassDao.findByGcParentId(gcNo);
		return list;
	}
	
	/**
	 * 删除分类
	 * @param gcNo
	 */
	public void removeGoodsClass(Integer gcNo){
		
		goodsClassDao.delete(gcNo);
		
	}
	
	public Page<GoodsClass> getGoodsList(Pageable pageable, GoodsClass goodsClass){
		
		Page<GoodsClass> page = goodsClassDao.findAll(new Specification<GoodsClass>() {
			@Override
			public Predicate toPredicate(Root<GoodsClass> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Path<String> namePath = root.get("gcName");  
			    query.where(cb.like(namePath, "%妈妈%")); //这里可以设置任意条查询条件  
			    return null;  
			}
		}, pageable);
		
	    return page;
	}
	
	/**
	 * 通过分类id查询分类信息
	 * @param gcNo
	 * @return
	 */
	public GoodsClass getGoodsClassByGcNo(Integer gcNo){
		
		return goodsClassDao.findGoodsClassByGcNo(gcNo);
		
	}
	
}
