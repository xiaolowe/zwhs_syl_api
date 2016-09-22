package cn.org.citycloud.zwhs.syl.service;

import cn.org.citycloud.zwhs.syl.bean.StoreAddBean;
import cn.org.citycloud.zwhs.syl.entity.*;
import cn.org.citycloud.zwhs.syl.repository.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author Allen
 *
 */

//Spring Bean的标识.
@Component
// 类中所有public函数都纳入事务管理的标识.
@Transactional
public class StoreService {
	@Autowired
	private StoreDao storeDao;

	@Autowired
	private StoreUserDao userDao;

	@Autowired
	private FinAccDao finAccDao;

	@Autowired
	private WechatKeyDao wechatKeyDao;

	@Autowired
	private StoreUserNewDao storeUserNewDao;

	@Autowired
	private StoreNewDao storeNewDao;
	
	/**
	 * 动态查询店铺列表
	 * @param pageable
	 * @param goodsCommon
	 * @return
	 */
	public Page<Store> getStorePage(Pageable pageable, Store store){
		
		Page<Store> page = storeDao.findAll(new Specification<Store>() {
			@Override
			public Predicate toPredicate(Root<Store> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				
				Predicate where = cb.conjunction();  
				if(store != null && StringUtils.isNotBlank(store.getCompanyName())){
					Path<String> companyName = root.get("companyName");  
					where = cb.and(where, cb.like(companyName, "%"+store.getCompanyName()+"%"));
					
				}
				if(store != null && store.getStoreState() != null){
					Path<String> storeState = root.get("storeState");  
					where = cb.and(where, cb.equal(storeState, store.getStoreState())); 
					
				}else{
					Path<String> storeState = root.get("storeState");
					where = cb.and(where, cb.notEqual(storeState, 2));
				}
				if(store != null && StringUtils.isNotBlank(store.getRegionProv())){
					Path<String> regionProv = root.get("regionProv");  
					String regionCode = store.getRegionProv().substring(0, 2);
					where = cb.and(where, cb.like(regionProv, regionCode+"%"));
					
				}
				if(store != null && StringUtils.isNotBlank(store.getRegionCity())){
					Path<String> regionCity = root.get("regionCity");  
					String regionCode = store.getRegionCity().substring(0, 4);
					where = cb.and(where, cb.like(regionCity, regionCode+"%"));
					
				}
				if(store != null && StringUtils.isNotBlank(store.getCompanyRegion())){
					Path<String> companyRegion = root.get("companyRegion");  
					where = cb.and(where, cb.like(companyRegion, "%"+store.getCompanyRegion()+"%"));
				}
				query.where(where);
				  
			    return null;   
			}
		}, pageable);
		
	    return page;
	}
	
	
	/**
	 * 动态查询店铺列表
	 * @param store
	 * @return
	 */
	public List<Store> getStoreList(Store store){
		
		List<Store> list = storeDao.findAll(new Specification<Store>() {
			@Override
			public Predicate toPredicate(Root<Store> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				
				Predicate where = cb.conjunction();  
				if(store != null && StringUtils.isNotBlank(store.getCompanyName())){
					Path<String> companyName = root.get("companyName");  
					where = cb.and(where, cb.like(companyName, "%"+store.getCompanyName()+"%"));
					
				}
				if(store != null && store.getStoreState() != null){
					Path<String> storeState = root.get("storeState");  
					where = cb.and(where, cb.equal(storeState, store.getStoreState())); 
					
				}else{
					Path<String> storeState = root.get("storeState");
					where = cb.and(where, cb.notEqual(storeState, 2));
				}
				if(store != null && StringUtils.isNotBlank(store.getRegionProv())){
					Path<String> regionProv = root.get("regionProv");  
					String regionCode = store.getRegionProv().substring(0, 2);
					where = cb.and(where, cb.like(regionProv, regionCode+"%"));
					
				}
				if(store != null && StringUtils.isNotBlank(store.getRegionCity())){
					Path<String> regionCity = root.get("regionCity");  
					String regionCode = store.getRegionCity().substring(0, 4);
					where = cb.and(where, cb.like(regionCity, regionCode+"%"));
					
				}
				if(store != null && StringUtils.isNotBlank(store.getCompanyRegion())){
					Path<String> companyRegion = root.get("companyRegion");  
					where = cb.and(where, cb.like(companyRegion, "%"+store.getCompanyRegion()+"%"));
				}
				query.where(where);
				  
			    return null;   
			}
		});
		
	    return list;
	}
	
	
	/**
	 * 根据店铺id查询店铺信息
	 * @param storeId
	 * @return
	 */
	public Store getStoreByStoreId(Integer storeId){
		
		return storeDao.findOne(storeId);
	}
	
	/**
	 * 根据店铺id修改店铺信息
	 * @param storeId
	 * @param store
	 * @return
	 */
	public Store modifyStoreByInfo(Integer storeId, Store store){
		
		Store storeupdate = storeDao.findOne(storeId);
		if(store != null && StringUtils.isNotBlank(store.getCompanyName())){
			storeupdate.setCompanyName(store.getCompanyName());
		}
		if(store != null && StringUtils.isNotBlank(store.getCompanyAddress())){
			storeupdate.setCompanyAddress(store.getCompanyAddress());
		}
		if(store != null && store.getStoreState() != null){
			storeupdate.setStoreState(store.getStoreState());
		}
		if(store != null && store.getSgId() != null){
			storeupdate.setSgId(store.getSgId());
		}
		if(store != null && store.getCommisRates() != null){
			storeupdate.setCommisRates(store.getCommisRates());
		}
		if(store != null && StringUtils.isNotBlank(store.getRegionProv())){
			storeupdate.setRegionProv(store.getRegionProv());
		}
		if(store != null && StringUtils.isNotBlank(store.getRegionCity())){
			storeupdate.setRegionCity(store.getRegionCity());
		}
		if(store != null && StringUtils.isNotBlank(store.getCompanyRegion())){
			storeupdate.setCompanyRegion(store.getCompanyRegion());
		}
		
		return storeDao.save(storeupdate);
	}
	
	
	/**
	 * 修改店铺状态
	 * @param storeId
	 * @param store
	 * @return
	 */
	public Store modifyStoreByState(Integer storeId, Store store){
		
		Store storeupdate = storeDao.findOne(storeId);
		
		if(store != null && store.getStoreState() != null){
			storeupdate.setStoreState(store.getStoreState());
		}
		if(store != null && store.getUpdDate() != null){
			storeupdate.setUpdDate(store.getUpdDate());
		}
		
		return storeDao.save(storeupdate);
	}
	
	
	/**
	 * 根据sgid修改分成比例
	 * @param commisRates
	 * @param sgId
	 */
	public void modifyStoreBySgId(Double commisRates, Integer sgId){
		
		storeDao.updateStoreCommisBySgId(commisRates, sgId);
	}
	
	
	public Long getStoreByUncheck(){
		
		return storeDao.findStoreByUncheck();
	}

	/**
	 * 新增店铺
	 *
	 * @param bean
	 * @return
     */
	@Transactional(rollbackFor = Exception.class)
	public Object addStore(StoreAddBean bean) {
		StoreNew store = new StoreNew();
		BeanUtils.copyProperties(bean, store);
		Date date = new Date();
		store.setCreateTime(date);
		store.setUpdDate(date);
		store.setStoreState(1);
		store.setRetailCode(cn.org.citycloud.zwhs.syl.utils.StringUtils.generateShortUuid().toLowerCase());
		store.setStoreType(1);
		storeNewDao.save(store);
		// 添加店铺默认用户
		StoreUserNew user = new StoreUserNew();
		user.setUpdDate(date);
		user.setInsDate(date);
		user.setStoreId(store.getStoreId());
		user.setUserPhone(store.getUserPhone());
		user.setUserPwd("888888");
		user.setUserTruename(store.getStoreOwner());
		storeUserNewDao.save(user);

		// 设置账号信息
		FinAcc finAcc = finAccDao.findFinaccByAccNo(store.getStoreId());
		if(finAcc==null){
			finAcc = new FinAcc();
			finAcc.setAccBal(0d);
			finAcc.setAccIncome(0d);
			finAcc.setAccNo(store.getStoreId());
			finAcc.setAccPay(0d);
			finAcc.setUpdDate(new Date());
			finAccDao.save(finAcc);
		}

		// 设置门店关键词
		WechatKey key1 = new WechatKey();
		key1.setReplyType(1);
		key1.setStoreId(store.getStoreId());
		key1.setKeywordSearch(1);
		key1.setReplyConType(1);
		key1.setReplyText("欢迎光临");
		WechatKey key2 = new WechatKey();
		key2.setReplyType(3);
		key2.setStoreId(store.getStoreId());
		key2.setKeywordSearch(1);
		key2.setReplyConType(1);
		key2.setReplyText("感谢您关注微信公众号");
		wechatKeyDao.save(key2);
		wechatKeyDao.save(key1);
		return store;
	}

	/**
	 * 修改店铺信息
	 *
	 * @param storeId
	 * @param bean
     * @return
     */
	public Object updateStore(int storeId, StoreAddBean bean) {
		Store store = storeDao.findOne(storeId);
		BeanUtils.copyProperties(bean, store);
		store.setUpdDate(new Date());
		return storeDao.save(store);
	}
}
