package cn.org.citycloud.zwhs.syl.service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import cn.org.citycloud.zwhs.syl.entity.RetailMember;
import cn.org.citycloud.zwhs.syl.entity.RetailShopGood;
import cn.org.citycloud.zwhs.syl.repository.RetailMemberDao;
import cn.org.citycloud.zwhs.syl.repository.RetailShopGoodsDao;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import cn.org.citycloud.zwhs.syl.entity.StoreGood;
import cn.org.citycloud.zwhs.syl.repository.StoreGoodDao;

/**
 * 
 * @author Allen
 *
 */

//Spring Bean的标识.
@Component
// 类中所有public函数都纳入事务管理的标识.
@Transactional
public class StoreGoodService {
	@Autowired
	private StoreGoodDao storeGoodDao;

	@Autowired
	private RetailMemberDao memberDao;

	@Autowired
	private RetailShopGoodsDao shopGoodsDao;
	
	/**
	 * 动态查询母婴店店铺列表
	 * @param pageable
	 * @param goodsCommon
	 * @return
	 */
	public Page<StoreGood> getStoreList(Pageable pageable, StoreGood storeGood, String starttime, String endtime){
		
		Page<StoreGood> page = storeGoodDao.findAll(new Specification<StoreGood>() {
			@Override
			public Predicate toPredicate(Root<StoreGood> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				
				Predicate where = cb.conjunction();  
				if(storeGood != null && StringUtils.isNotBlank(starttime) && StringUtils.isNotBlank(endtime)){
					Path<Date> addTime = root.get("insDate"); 
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date start = new Date();
					Date end = new Date();
					String startime1 = starttime + " 00:00:00";
					String endtime1 = endtime + " 23:59:59";
					try {
						start = sdf.parse(startime1);
						end = sdf.parse(endtime1);
					} catch (ParseException e) {
						e.printStackTrace();
					}
					where = cb.and(where, cb.between(addTime, start, end)); 
					
				}

				if(storeGood != null && storeGood.getGoodsState() != -1){
					Path<Integer> goodsState = root.get("goodsState");
					where = cb.and(where, cb.equal(goodsState, storeGood.getGoodsState()));
				}

				if(storeGood != null && storeGood.getGoodsVerify() != -1){
					Path<String> goodsVerify = root.get("goodsVerify");
					where = cb.and(where, cb.equal(goodsVerify, storeGood.getGoodsVerify()));
				}

				if(storeGood != null && storeGood.getGcNo() != -1){
					Path<String> gcNo = root.get("gcNo");  
					where = cb.and(where, cb.equal(gcNo, storeGood.getGcNo())); 
					
				}
				if(storeGood != null && StringUtils.isNotBlank(storeGood.getGoodsName())){
					Path<String> goodsName = root.get("goodsName");  
					where = cb.and(where, cb.like(goodsName, "%"+storeGood.getGoodsName()+"%"));
				}
				if(storeGood != null && storeGood.getStore() != null && StringUtils.isNotBlank(storeGood.getStore().getCompanyName())){
					Path<String> storeName = root.get("store").get("companyName");  
					where = cb.and(where, cb.like(storeName, "%"+storeGood.getStore().getCompanyName()+"%"));
				}

				query.where(where);
				  
			    return null;   
			}
		}, pageable);
		
	    return page;
	}
	/**
	 * 根据店铺id查询店铺信息
	 * @param storeId
	 * @return
	 */
	public StoreGood getStoreGoodByGoodsId(Integer goodsId){
		
		return storeGoodDao.findOne(goodsId);
	}

	/**
	 * 审核通过
	 *
	 * @param goodsId
	 * @return
     */
	@Transactional(rollbackFor = Exception.class)
	public Object passGood(int goodsId) {
		StoreGood storeGood = storeGoodDao.findOne(goodsId);
		storeGood.setGoodsVerify(1);
		storeGood.setUpdDate(new Date());
		storeGoodDao.save(storeGood);

		// 如果被审核的商品是分销商品,则将数据插入到分销商品表中，memberId取所有与此store关联的会员的Id
		if (storeGood.getIsAddRetail() == 1) {
			List<RetailMember> members = memberDao.findByStore(storeGood.getStore());
			for (RetailMember member : members) {
				RetailShopGood retailShopGood = new RetailShopGood();
				retailShopGood.setStatus(1);
				retailShopGood.setUpdateTime(new Date());
				retailShopGood.setCreateTime(new Date());
				retailShopGood.setAlreadySale(storeGood.getSellNumber());
				retailShopGood.setGoodsId(storeGood.getGoodsId());
				retailShopGood.setShopGoodsPrice(storeGood.getRetailSalePrice());
				retailShopGood.setMemberId(member.getMemberId());
				retailShopGood.setGoodsName(storeGood.getGoodsName());
				retailShopGood.setOnlineTime(new Date());
				retailShopGood.setShopGoodsPrice(storeGood.getRetailSalePrice());
				retailShopGood.setGoodsImage(storeGood.getGoodsImage());
				retailShopGood.setGoodsImageSmall(storeGood.getGoodsImageSmall());
				retailShopGood.setInitPrice(storeGood.getRetailInitPrice());
				retailShopGood.setSalePrice(storeGood.getRetailSalePrice());
				shopGoodsDao.save(retailShopGood);
			}
		}

		return storeGood;
	}

	/**
	 * 审核驳回
	 *
	 * @param goodsId
	 * @return
     */
	public Object rejectedGood(int goodsId) {
		StoreGood storeGood = storeGoodDao.findOne(goodsId);
		storeGood.setGoodsVerify(1);
		storeGood.setUpdDate(new Date());
		return storeGoodDao.save(storeGood);
	}

	/**
	 * 商品下架
	 *
	 * @param goodsId
	 * @return
     */
	public Object unshelved(int goodsId) {
		StoreGood storeGood = storeGoodDao.findOne(goodsId);
		storeGood.setGoodsState(0);
		storeGood.setUpdDate(new Date());
		return storeGoodDao.save(storeGood);
	}
	
}
