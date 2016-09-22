package cn.org.citycloud.zwhs.syl.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.org.citycloud.zwhs.syl.constants.ErrorCodes;
import cn.org.citycloud.zwhs.syl.entity.ServiceStore;
import cn.org.citycloud.zwhs.syl.entity.Store;
import cn.org.citycloud.zwhs.syl.exception.BusinessErrorException;
import cn.org.citycloud.zwhs.syl.repository.ServiceStoreDao;
import cn.org.citycloud.zwhs.syl.repository.StoreDao;

/**
 * 服务管理API(宝宝理发)
 * 
 * @author lanbo
 *
 */
@RestController
public class ServiceManageController {

	@Autowired
	private ServiceStoreDao writeListDao;
	
	@Autowired
	private StoreDao storeDao;

	/**
	 * 获取上门服务白名单
	 */
	@RequestMapping(value = "/serviceWhiteLists", method = RequestMethod.GET)
	public Object getServiceStore() {

		return writeListDao.findAll();
	}

	/**
	 * 添加上门服务白名单
	 * 
	 * @throws BusinessErrorException
	 */
	@RequestMapping(value = "/serviceWhiteLists/store/{store_id}", method = RequestMethod.POST)
	public void addServiceStore(@PathVariable int store_id)
			throws BusinessErrorException {
		long count = writeListDao.countByStoreId(store_id);
		
		if (count > 0) {

			throw new BusinessErrorException(ErrorCodes.REPEAT_ERROR,
					"此母婴店已经添加了上门服务白名单");
		}
		
		Store store = storeDao.findOne(store_id);
		
		if(store == null) {
			throw new BusinessErrorException(ErrorCodes.OPERATION_ERROR,
					"此母婴店不存在");
		}

		ServiceStore entity = new ServiceStore();
		// 宝宝理发 上门服务 1
		entity.setServiceId(1);
		entity.setStoreId(store_id);
		entity.setCompanyName(store.getCompanyName());
		entity.setServiceState(1);
		Date now = new Date();
		entity.setInsDate(now);
		entity.setUpdDate(now);

		writeListDao.save(entity);
	}

	/**
	 * 删除上门服务白名单
	 */
	@RequestMapping(value = "/serviceWhiteLists/{id}", method = RequestMethod.DELETE)
	public void deleteServiceStore(@PathVariable int id) {

		writeListDao.delete(id);
	}

}
