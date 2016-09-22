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

import cn.org.citycloud.zwhs.syl.entity.GoodsCommon;
import cn.org.citycloud.zwhs.syl.repository.GoodsCommonDao;

/**
 * 
 * @author Allen
 *
 */

//Spring Bean的标识.
@Component
// 类中所有public函数都纳入事务管理的标识.
@Transactional
public class GoodsCommonService {
	@Autowired
	private GoodsCommonDao goodsCommonDao;
	
	/**
	 * 动态查询商品列表
	 * @param pageable
	 * @param goodsCommon
	 * @return
	 */
	public Page<GoodsCommon> getGoodsCommonList(Pageable pageable, GoodsCommon goodsCommon){
		
		Page<GoodsCommon> page = goodsCommonDao.findAll(new Specification<GoodsCommon>() {
			@Override
			public Predicate toPredicate(Root<GoodsCommon> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				
				Predicate where = cb.conjunction();  
		        
				if(goodsCommon != null && goodsCommon.getGoodsId() != null){
					Path<String> goodsId = root.get("goodsId");  
					where = cb.and(where, cb.equal(goodsId, goodsCommon.getGoodsId())); 
					
				}
				if(goodsCommon != null && goodsCommon.getGcNo() != null){
					Path<String> gcNo = root.get("gcNo");  
					where = cb.and(where, cb.equal(gcNo, goodsCommon.getGcNo())); 
					
				}
				if(goodsCommon != null && goodsCommon.getBrandNo() != null){
					Path<String> brandNo = root.get("brandNo");  
					where = cb.and(where, cb.equal(brandNo, goodsCommon.getBrandNo())); 
					
				}
				if(goodsCommon != null && goodsCommon.getGoodsVerify() != null){
					Path<String> goodsVerify = root.get("goodsVerify");  
					where = cb.and(where, cb.equal(goodsVerify, goodsCommon.getGoodsVerify())); 
					
				}
				if(goodsCommon != null && StringUtils.isNotBlank(goodsCommon.getGoodsName())){
					Path<String> goodsName = root.get("goodsName");  
					where = cb.and(where, cb.like(goodsName, "%"+goodsCommon.getGoodsName()+"%"));
				}
				if (goodsCommon != null && goodsCommon.getGoodsState() != null) {
					Path<String> goodsState = root.get("goodsState");
					where = cb.and(where, cb.equal(goodsState, goodsCommon.getGoodsState()));
				}
				query.where(where);
				  
			    return null;  
			}
		}, pageable);
		
	    return page;
	}
	/**
	 * 添加商品
	 * @param goodsCommon
	 */
	public void addGoodsCommon(GoodsCommon goodsCommon){
		Date now = new Date();
		goodsCommon.setGoodsAddtime(now);
		goodsCommon.setConfirmUserId(0);
		goodsCommon.setGoodsCostprice(0.0);
		goodsCommon.setGoodsMarketprice(0.0);
		goodsCommon.setGoodsPrice(0.0);
		goodsCommonDao.save(goodsCommon);
	}
	
	/**
	 * 修改商品
	 * @param goodsCommon
	 */
	public void modifyGoodsCommon(Integer goodsId, GoodsCommon goodsCommon){
		GoodsCommon gcUpdate = goodsCommonDao.findOne(goodsId);
		
		if(goodsCommon != null && StringUtils.isNotBlank(goodsCommon.getBrandName())){
			gcUpdate.setBrandName(goodsCommon.getBrandName());
		}
		if(goodsCommon != null && goodsCommon.getBrandNo() != null){
		    gcUpdate.setBrandNo(goodsCommon.getBrandNo());
		}
		if(goodsCommon != null && StringUtils.isNotBlank(goodsCommon.getContactsName())){
			gcUpdate.setContactsName(goodsCommon.getContactsName());
		}
		if(goodsCommon != null && goodsCommon.getGcNo() != null){
			gcUpdate.setGcNo(goodsCommon.getGcNo());
		}
		if(goodsCommon != null && StringUtils.isNotBlank(goodsCommon.getGcName())){
			gcUpdate.setGcName(goodsCommon.getGcName());
		}
		if(goodsCommon != null && goodsCommon.getGcLitId() != null){
			gcUpdate.setGcLitId(goodsCommon.getGcLitId());
		}
		if(goodsCommon != null && StringUtils.isNotBlank(goodsCommon.getGcLitName())){
			gcUpdate.setGcLitName(goodsCommon.getGcLitName());
		}
		if(goodsCommon != null && StringUtils.isNotBlank(goodsCommon.getGoodsBody())){
			gcUpdate.setGoodsBody(goodsCommon.getGoodsBody());
		}
		if(goodsCommon != null && StringUtils.isNotBlank(goodsCommon.getGoodsImage())){
			gcUpdate.setGoodsImage(goodsCommon.getGoodsImage());
		}
		if(goodsCommon != null && StringUtils.isNotBlank(goodsCommon.getGoodsImageSmall())){
			gcUpdate.setGoodsImageSmall(goodsCommon.getGoodsImageSmall());
		}
		if(goodsCommon != null && StringUtils.isNotBlank(goodsCommon.getGoodsName())){
			gcUpdate.setGoodsName(goodsCommon.getGoodsName());
		}
		if(goodsCommon != null && StringUtils.isNotBlank(goodsCommon.getGoodsSn())){
			gcUpdate.setGoodsSn(goodsCommon.getGoodsSn());
		}
		if(goodsCommon != null && StringUtils.isNotBlank(goodsCommon.getGoodsSpec())){
			gcUpdate.setGoodsSpec(goodsCommon.getGoodsSpec());
		}
		if(goodsCommon != null && goodsCommon.getGoodsVerify() != null){
		    gcUpdate.setGoodsVerify(goodsCommon.getGoodsVerify());
		}
		if(goodsCommon != null && goodsCommon.getUpdDate() != null){
			Date now = new Date();
			gcUpdate.setUpdDate(now);
		}
		
		
		goodsCommonDao.save(gcUpdate);
	}
	
	/**
	 * 通过商品编号获取商品信息
	 * @param goodsno
	 * @return
	 */
	public GoodsCommon getGoodsCommon(Integer goodsId){
		
		GoodsCommon goodsCommon = null;
		List<GoodsCommon> list = goodsCommonDao.findByGoodsId(goodsId);
		if(list != null && list.size() > 0){
			 goodsCommon = list.get(0);
		}
		return goodsCommon;
	}
	
	/**
	 * 修改商品状态
	 * @param goodsId
	 * @param goodsCommon
	 * @return
	 */
	public GoodsCommon modifyGoodsCommonByVerify(Integer goodsId, GoodsCommon goodsCommon){
		
		GoodsCommon common = goodsCommonDao.findOne(goodsId);
		common.setGoodsVerify(goodsCommon.getGoodsVerify());
		return goodsCommonDao.save(common);
		
	}

	/**
	 * 修改商品上下架状态
	 *
	 * @param goodsId 商品id
	 * @param goodsCommon 商品实体
	 * @return
	 */
	public GoodsCommon modifyGoodsCommonByState(Integer goodsId, GoodsCommon goodsCommon){

		GoodsCommon common = goodsCommonDao.findOne(goodsId);
		common.setGoodsState(goodsCommon.getGoodsState());
		return goodsCommonDao.save(common);

	}

	/**
	 * 通过商品串码查询商品信息
	 * @param goodsSn
	 * @return
	 */
	public GoodsCommon getGoodsCommonByGoodsSn(String goodsSn){
		
		return goodsCommonDao.findGoodsCommonByGoodsSn(goodsSn);
	}
	/**
	 * 通过商品串码查询商品信息
	 * @param goodsSn
	 * @return
	 */
	public GoodsCommon getGoodsCommonByGoodsSn(Integer goodsId, String goodsSn){
		
		return goodsCommonDao.findGoodsCommonByGoodsSn(goodsId, goodsSn);
	}
	
	public Long getGoodsCommonByunCheckState(){
		
		return goodsCommonDao.findGoodsCommonByunCheckState();
	}
}
