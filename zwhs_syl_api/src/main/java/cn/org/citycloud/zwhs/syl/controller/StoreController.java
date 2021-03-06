package cn.org.citycloud.zwhs.syl.controller;

import cn.org.citycloud.zwhs.syl.bean.StoreAddBean;
import cn.org.citycloud.zwhs.syl.bean.StoreBean;
import cn.org.citycloud.zwhs.syl.constants.ErrorCodes;
import cn.org.citycloud.zwhs.syl.entity.Store;
import cn.org.citycloud.zwhs.syl.entity.StoreSg;
import cn.org.citycloud.zwhs.syl.entity.StoreUser;
import cn.org.citycloud.zwhs.syl.exception.BusinessErrorException;
import cn.org.citycloud.zwhs.syl.service.StoreService;
import cn.org.citycloud.zwhs.syl.service.StoreSgService;
import cn.org.citycloud.zwhs.syl.service.StoreUserService;
import cn.org.citycloud.zwhs.syl.utils.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.*;
import java.util.*;


@Controller
@RequestMapping("store")
public class StoreController {
	
	@Autowired
	private StoreService storeService;
	
	@Autowired
	private StoreUserService storeUserService;
	
	@Autowired
	private StoreSgService stoerSgService;
	
	
	/**
	 * 获取店铺列表
	 * 列表
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody()
	public Object getGoods(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
	        @RequestParam(value = "pageSize", defaultValue = "10")  Integer pageSize,
	        @RequestParam(value = "province_id", required = false)  String provinceId,
	        @RequestParam(value = "city_id", required = false)  String cityId,
	        @RequestParam(value = "area_id", required = false)  String areaId,
	        @RequestParam(value = "company_name", required = false)  String companyName,
	        @RequestParam(value = "store_state", required = false) Integer storeState) throws Exception, RuntimeException {

		
		Sort sort = new Sort(Direction.DESC, "storeId");
	    Pageable pageable = new PageRequest(pageNo - 1, pageSize, sort);
	    Store store = new Store(companyName, areaId, cityId,
	    		provinceId, storeState);
	    
	    Page<Store> list = storeService.getStorePage(pageable, store);
		return list;
	}
	
	/**
	 * 查看店铺详情
	 * @return
	 */
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	@ResponseBody()
	public Object detailGoods(
			@RequestParam(value = "store_id") Integer storeId) throws Exception, RuntimeException {

		if(storeId == null){
			
			throw new BusinessErrorException(ErrorCodes.PARAM_ERROR, "参数为空");
			
		}
		Store store = storeService.getStoreByStoreId(storeId);
		return store;
	}
	
	/**
	 * 编辑店铺信息
	 * @return
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.PUT)
	@ResponseBody()
	public Object modifyStoreInfo(@Valid @RequestBody StoreBean bean) throws Exception, RuntimeException {

		Date now = new Date();
		
		Store store = new Store(bean.getCompany_address(), bean.getCompany_name(),
				bean.getArea_id(), bean.getCity_id(),
				bean.getProvince_id(), bean.getSg_id(), bean.getStore_state(), now);
		
		StoreSg storeSg = stoerSgService.getStoreSg(bean.getSg_id());
		store.setCommisRates(storeSg.getCommisRates());
		
		Store storeupdate = storeService.modifyStoreByInfo(bean.getStore_id(), store);
		
		return storeupdate;
	}

	/**
	 * 获取商铺等级
	 *
	 * @return
     */
	@RequestMapping(value = "/sgs", method = RequestMethod.GET)
	@ResponseBody()
	public Object getStoreSgs() {
		return stoerSgService.getStoreSgList();
	}


	/**
	 * 添加店铺
	 *
	 * @param bean
	 * @return
     */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody()
	public Object addStore(@Valid @RequestBody StoreAddBean bean) {
		return storeService.addStore(bean);
	}

	/**
	 * 修改店铺
	 *
	 * @param storeId
	 * @param bean
     * @return
     */
	@RequestMapping(value = "/update/{storeId}", method = RequestMethod.PUT)
	@ResponseBody()
	public Object updateStore(@PathVariable int storeId, @Valid @RequestBody StoreAddBean bean) {
		return storeService.updateStore(storeId, bean);
	}
	
	/**
	 * 修改店铺密码
	 * @return
	 */
	@RequestMapping(value = "/modifypass/{storeId}", method = RequestMethod.PUT)
	@ResponseBody()
	public Object modifyStorePassword(@PathVariable Integer storeId,
			@RequestBody Map<String, Object> params) throws Exception, RuntimeException {

		String userPwd = (String)params.get("user_pwd");
		
		if(storeId == null || userPwd == null){
			
			throw new BusinessErrorException(ErrorCodes.PARAM_ERROR, "参数为空");
			
		}
		Date now = new Date();
		StoreUser storeUser = new StoreUser();
		storeUser.setUserPwd(userPwd);
		storeUser.setUpdDate(now);
		
		StoreUser storeupdate = storeUserService.modifyStoreUser(storeId, storeUser);
		
		return storeupdate;
	}
	
	/**
	 * 店铺审核通过(驳回)
	 * @return
	 */
	@RequestMapping(value = "/check/{storeId}", method = RequestMethod.PUT)
	@ResponseBody()
	public Object checkStore(@PathVariable Integer storeId,
			@RequestBody Map<String, Object> params) throws Exception, RuntimeException {

		Integer storeState = (Integer)params.get("store_state");
		
		if(storeId == null || storeState == null){
			
			throw new BusinessErrorException(ErrorCodes.PARAM_ERROR, "参数为空");
			
		}
		Date now = new Date();
		Store store = new Store();
		store.setStoreState(storeState);
		store.setUpdDate(now);
		
		return storeService.modifyStoreByState(storeId, store);
		
	}
	
	
	/**
	 * 导出报表
	 */
	@RequestMapping(value="downloadExcel", method = RequestMethod.GET)
    public String download(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
	        @RequestParam(value = "pageSize", defaultValue = "10")  Integer pageSize,
	        @RequestParam(value = "province_id", required = false)  String provinceId,
	        @RequestParam(value = "city_id", required = false)  String cityId,
	        @RequestParam(value = "area_id", required = false)  String areaId,
	        @RequestParam(value = "company_name", required = false)  String companyName,
	        @RequestParam(value = "store_state", required = false) Integer storeState,
    		HttpServletRequest request,HttpServletResponse response) throws Exception, RuntimeException, IOException{
      
		 Store store = new Store(companyName, areaId, cityId,
		    		provinceId, storeState);
	    
		List<Store> listExcel = storeService.getStoreList(store);
	    
		String fileName="店铺信息";
        //填充实体类实体数据
		List<Store> projects= listExcel;
        List<Map<String,Object>> list=createExcelRecord(projects);
        String columnNames[]={"母婴店编号","注册时间","母婴店名称","所在省","所在市","所在区", "联系人",
        		"联系电话", "母婴店地址", "母婴店状态","母婴店等级","平台分成比例","银行卡", "开户人", "开户行"};//列名
        String keys[]    =     {"storeId","createTime","companyName","regionProvName","regionCityName","regionAreaName", "userTruename",
        		"userPhone", "companyAddress", "storeState", "sgId", "commisRates", "bankAccNumber","bankOwner", "bankAccName"};//map中的key
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            ExcelUtil.createWorkBook(list,keys,columnNames).write(os);
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] content = os.toByteArray();
        InputStream is = new ByteArrayInputStream(content);
        // 设置response参数，可以打开下载页面
        response.reset();
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename="+ new String((fileName + ".xls").getBytes(), "iso-8859-1"));
        ServletOutputStream out = response.getOutputStream();
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(is);
            bos = new BufferedOutputStream(out);
            byte[] buff = new byte[2048];
            int bytesRead;
            // Simple read/write loop.
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }
        } catch (final IOException e) {
            throw e;
        } finally {
            if (bis != null)
                bis.close();
            if (bos != null)
                bos.close();
        }
        return null;
    }
	
    private List<Map<String, Object>> createExcelRecord(List<Store> projects) {
        List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("sheetName", "sheet1");
        listmap.add(map);
        Store project=null;
        for (int j = 0; j < projects.size(); j++) {
            project=projects.get(j);
            Map<String, Object> mapValue = new HashMap<String, Object>();
	            mapValue.put("storeId", project.getStoreId());
	            mapValue.put("createTime", project.getCreateTime());
	            mapValue.put("companyName", project.getCompanyName());
	            mapValue.put("regionProvName", project.getProvinceName().getRegionName());
	            mapValue.put("regionCityName", project.getCityName().getRegionName());
	            mapValue.put("regionAreaName", project.getAreaName().getRegionName());
	            mapValue.put("userTruename", project.getStoreUser().getUserTruename());
	            mapValue.put("userPhone", project.getUserPhone());
	            mapValue.put("companyAddress", project.getCompanyAddress());
	            if(project.getStoreState() == 0){
	            	 mapValue.put("storeState", "未审核");
	            }
	            if(project.getStoreState() == 1){
	            	 mapValue.put("storeState", "已审核");
	            }
	            if(project.getStoreState() == 2){
	            	 mapValue.put("storeState", "已驳回");
	            }
	            if(project.getStoreState() == 3){
	            	 mapValue.put("storeState", "已冻结");
	            }
	            mapValue.put("sgId", project.getStoreSg().getSgName());
	            mapValue.put("commisRates", project.getCommisRates());
	            mapValue.put("bankAccNumber", project.getBankAccNumber());
	            mapValue.put("bankOwner", project.getBankOwner());
	            mapValue.put("bankAccName", project.getBankAccName());
            listmap.add(mapValue);
        }
        return listmap;
    
    }
	
}
