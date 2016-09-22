package cn.org.citycloud.zwhs.syl.service;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.org.citycloud.zwhs.syl.entity.StoreSg;
import cn.org.citycloud.zwhs.syl.repository.StoreSgDao;


//Spring Bean的标识.
@Component
// 类中所有public函数都纳入事务管理的标识.
@Transactional
public class StoreSgService {
	@Autowired
	private StoreSgDao storeSgDao;
	
	
	/**
	 * 添加分成管理
	 * @param storeSg
	 */
	public StoreSg addStoreSg(StoreSg storeSg){
		
		Date now = new Date();
		storeSg.setInsDate(now);
		return storeSgDao.save(storeSg);
	}
	
	/**
	 * 更新分成管理
	 * @param storeSg
	 */
	public StoreSg modifyStoreSg(Integer sgId, StoreSg storeSg){
		
		StoreSg storeSgupdate = storeSgDao.findOne(sgId);
		if(storeSg != null && StringUtils.isNotBlank(storeSg.getSgName())){
			storeSgupdate.setSgName(storeSg.getSgName());
		}
		if(storeSg != null && storeSg.getCommisRates() != null){
			storeSgupdate.setCommisRates(storeSg.getCommisRates());
		}
		storeSgupdate.setUpdDate(new Date());
		return storeSgDao.save(storeSgupdate);
	}
	/**
	 * 获取店铺等级列表
	 * @return
	 */
	public List<StoreSg> getStoreSgList(){
		
		return storeSgDao.findAll();
	}
	/**
	 * 通过sgId获取店铺等级信息
	 * @param sgId
	 * @return
	 */
	public StoreSg getStoreSg(Integer sgId){
		
		return storeSgDao.findStoreSgBySgId(sgId);
	}
	
	/**
	 * 删除分成等级
	 * @param sgId
	 */
	public void removeStoreSg(Integer sgId){
		
	     storeSgDao.delete(sgId);
	}
}
