package cn.org.citycloud.zwhs.syl.controller;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.org.citycloud.zwhs.syl.bean.StoreSgBean;
import cn.org.citycloud.zwhs.syl.entity.StoreSg;
import cn.org.citycloud.zwhs.syl.service.StoreService;
import cn.org.citycloud.zwhs.syl.service.StoreSgService;


@Controller
@RequestMapping("storesg")
public class StoreSgController {
	
	@Autowired
	private StoreSgService storeSgService;
	
	@Autowired
	private StoreService storeService;
	
	
	/**
	 * 获取等级列表
	 * 列表
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody()
	public Object getStoreSgList() throws Exception, RuntimeException {

	    List<StoreSg> list = storeSgService.getStoreSgList();
		return list;
	}
	
	/**
	 * 根据等级id获取等级信息
	 * 列表
	 * @return
	 */
	@RequestMapping(value = "/getStoreSg/{sgId}", method = RequestMethod.GET)
	@ResponseBody()
	public Object getStoreSg(@PathVariable Integer sgId) throws Exception, RuntimeException {

	    StoreSg storeSg = storeSgService.getStoreSg(sgId);
		return storeSg;
	}
	
	/**
	 * 添加分成等级
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody()
	public Object addStoreSg(@Valid @RequestBody StoreSgBean storeSgBean) throws Exception, RuntimeException {

		
		StoreSg storeSg = new StoreSg();
		storeSg.setSgName(storeSgBean.getSg_name());
		storeSg.setCommisRates(storeSgBean.getCommis_rates());
		StoreSg StoreSgadd = storeSgService.addStoreSg(storeSg);
		
		return StoreSgadd;
	}
	
	/**
	 * 更新分成等级
	 * @return
	 */
	@RequestMapping(value = "/edit/{sgId}", method = RequestMethod.PUT)
	@ResponseBody()
	public Object modifyStoreInfo(@PathVariable Integer sgId, 
			@Valid @RequestBody StoreSgBean storeSgBean) throws Exception, RuntimeException {

		
		StoreSg storeSg = new StoreSg();
		storeSg.setSgName(storeSgBean.getSg_name());
		storeSg.setCommisRates(storeSgBean.getCommis_rates());
		StoreSg StoreSgupdate = storeSgService.modifyStoreSg(sgId, storeSg);
		
		if(storeSgBean.getCommis_rates() != null){
			
			storeService.modifyStoreBySgId(storeSgBean.getCommis_rates(), sgId);
		}
		
		return StoreSgupdate;
	}
	
	
}
