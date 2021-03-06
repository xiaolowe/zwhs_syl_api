package cn.org.citycloud.zwhs.syl.controller;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.org.citycloud.zwhs.syl.bean.ExcelTest;
import cn.org.citycloud.zwhs.syl.constants.ErrorCodes;
import cn.org.citycloud.zwhs.syl.core.BaseController;
import cn.org.citycloud.zwhs.syl.entity.Brand;
import cn.org.citycloud.zwhs.syl.entity.GoodsClass;
import cn.org.citycloud.zwhs.syl.entity.GoodsCommon;
import cn.org.citycloud.zwhs.syl.exception.BusinessErrorException;
import cn.org.citycloud.zwhs.syl.service.BrandService;
import cn.org.citycloud.zwhs.syl.service.GoodsClassService;
import cn.org.citycloud.zwhs.syl.service.GoodsCommonService;
import cn.org.citycloud.zwhs.syl.utils.ExcelUtil;

@Controller
@RequestMapping("goodscommon")
public class GoodsCommonController extends BaseController{
	
	@Autowired
	private GoodsCommonService goodsCommonService;
	
	@Autowired
	private GoodsClassService  goodsClassSerice;
	
	@Autowired
	private BrandService brandService;
	
	/**
	 * 添加商品
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody()
	public Object addGoods(@RequestBody Map<String, Object> params,
			HttpServletRequest request,HttpServletResponse response) throws Exception, RuntimeException {

		Integer brandNo = (Integer)params.get("brand_no");
		String goodsName = (String)params.get("goods_name");
		String goodsSn = (String)params.get("goods_sn");
//		Integer goodsVerify = (Integer)params.get("goods_verify");
		Integer gcNo = (Integer)params.get("gc_no");
		Integer gcLitId = (Integer)params.get("gc_lit_id");
		String goodsSpec  = (String)params.get("goods_spec");
//		String contactsName = (String)params.get("contacts_name");
		String goodsImage = (String)params.get("goods_image");
		String goodsImageSmall = (String)params.get("goods_image_small");
		String goodsBody = (String)params.get("goods_body");
		
		if(brandNo == null || goodsName ==null || goodsSn == null
		    || gcNo == null 
			|| gcLitId == null ||  goodsSpec == null || goodsImage == null 
			|| goodsBody == null ){
			
			throw new BusinessErrorException(ErrorCodes.PARAM_ERROR, "参数为空");
			
		}
		GoodsCommon common = goodsCommonService.getGoodsCommonByGoodsSn(goodsSn);
		if(common != null){
			throw new BusinessErrorException(ErrorCodes.REPEAT_ERROR, "该商品编码已存在");
		}
		Brand brand = brandService.getBrandByBrandNo(brandNo);
		GoodsClass gc1 = goodsClassSerice.getGoodsClassByGcNo(gcNo);
		GoodsClass gc2 = goodsClassSerice.getGoodsClassByGcNo(gcLitId);
		String userName =  getUserName();
		Integer goodState = 0;
		Integer goodsVerify = 1;   // 0 待审核 1 已审核 2 驳回 3 冻结
		Date now = new Date();
		if(brand == null || gc1 == null || gc2 == null){
			throw new BusinessErrorException(ErrorCodes.PARAM_ERROR, "参数错误");
		}
		GoodsCommon goodsCommon = new GoodsCommon(brand.getBrandName(), brandNo, userName,
				gcLitId, gc2.getGcName(), gc1.getGcName(), gcNo, goodsBody,
				goodsImage, goodsImageSmall, goodsName, goodsSn, 
				goodsSpec,goodState, goodsVerify, now);
		goodsCommonService.addGoodsCommon(goodsCommon);
		
		return goodsCommon;
	}
	
	
	/**
	 * 修改商品
	 * @return
	 */
	@RequestMapping(value = "/edit/{goodsId}", method = RequestMethod.PUT)
	@ResponseBody()
	public Object modifyGoods(@PathVariable Integer goodsId, @RequestBody Map<String, Object> params,
			HttpServletRequest request,HttpServletResponse response) throws Exception, RuntimeException {

		Integer brandNo = (Integer)params.get("brand_no");
		String goodsName = (String)params.get("goods_name");
		String goodsSn = (String)params.get("goods_sn");
		Integer goodsVerify = (Integer)params.get("goods_verify");
		Integer gcNo = (Integer)params.get("gc_no");
		Integer gcLitId = (Integer)params.get("gc_lit_id");
		String goodsSpec  = (String)params.get("goods_spec");
//		String contactsName = (String)params.get("contacts_name");
		String goodsImage = (String)params.get("goods_image");
		String goodsImageSmall = (String)params.get("goods_image_small");
		String goodsBody = (String)params.get("goods_body");
		
		if(goodsId == null ){
			
			throw new BusinessErrorException(ErrorCodes.PARAM_ERROR, "参数为空");
			
		}
		GoodsCommon common = goodsCommonService.getGoodsCommonByGoodsSn(goodsId, goodsSn);
		if(common != null){
			throw new BusinessErrorException(ErrorCodes.REPEAT_ERROR, "该商品编码已存在");
		}
		Brand brand = brandService.getBrandByBrandNo(brandNo);
		GoodsClass gc1 = goodsClassSerice.getGoodsClassByGcNo(gcNo);
		GoodsClass gc2 = goodsClassSerice.getGoodsClassByGcNo(gcLitId);
		String userName = getUserName();
		Date now = new Date();
		if(brand == null || gc1 == null || gc2 == null){
			throw new BusinessErrorException(ErrorCodes.PARAM_ERROR, "参数错误");
		}
		GoodsCommon goodsCommon = new GoodsCommon(brand.getBrandName(), brandNo, userName,
				gcLitId, gc2.getGcName(), gc1.getGcName(), gcNo, goodsBody,
				goodsImage, goodsImageSmall, goodsName, goodsSn, 
				goodsSpec, goodsVerify, now);
		
		goodsCommonService.modifyGoodsCommon(goodsId, goodsCommon);
		
		return goodsCommon;
	}
	
	
	/**
	 * 列表
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody()
	public Object getGoods(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
	        @RequestParam(value = "pageSize", defaultValue = "10")  Integer pageSize,
	        @RequestParam(value = "gc_no", required = false)  Integer gcNo,
	        @RequestParam(value = "brand_no", required = false)  Integer brandNo,
	        @RequestParam(value = "goods_name", required = false) String goodsName,
	        @RequestParam(value = "goods_id", required = false) Integer goodsId,
	        @RequestParam(value = "goods_verify", required = false) Integer goodsVerify,
						   @RequestParam(value = "goods_state", required = false) Integer goodsState) throws Exception {

		Sort sort = new Sort(Direction.DESC, "goodsId");
	    Pageable pageable = new PageRequest(pageNo - 1, pageSize, sort);
	    GoodsCommon goodsCommon = new GoodsCommon();
	    goodsCommon.setGoodsName(goodsName);
	    goodsCommon.setGoodsId(goodsId);
	    goodsCommon.setGoodsVerify(goodsVerify);
	    goodsCommon.setGcNo(gcNo);
	    goodsCommon.setBrandNo(brandNo);
		goodsCommon.setGoodsState(goodsState);
		Page<GoodsCommon> list = goodsCommonService.getGoodsCommonList(pageable, goodsCommon);
		return list;
	}
	
	/**
	 * 查看商品详情
	 * @return
	 */
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	@ResponseBody()
	public Object detailGoods(
			@RequestParam(value = "goods_id") Integer goodsId) throws Exception, RuntimeException {

		if(goodsId == null){
			
			throw new BusinessErrorException(ErrorCodes.PARAM_ERROR, "参数为空");
			
		}
		GoodsCommon goodsCommon = goodsCommonService.getGoodsCommon(goodsId);
		
		return goodsCommon;
	}
	
	/**
	 * 审核通过
	 * @return
	 */
	@RequestMapping(value = "/check/{goodsId}", method = RequestMethod.PUT)
	@ResponseBody()
	public Object checkGoods(@PathVariable Integer goodsId) throws Exception, RuntimeException {

		if(goodsId == null){
			
			throw new BusinessErrorException(ErrorCodes.PARAM_ERROR, "参数为空");
			
		}
		GoodsCommon goodsCommon = new GoodsCommon();
		goodsCommon.setGoodsVerify(1);
		GoodsCommon common = goodsCommonService.modifyGoodsCommonByVerify(goodsId, goodsCommon);
		
		return common;
	}
	
	/**
	 * 审核不通过
	 * 驳回
	 * @return
	 */
	@RequestMapping(value = "/uncheck/{goodsId}", method = RequestMethod.PUT)
	@ResponseBody()
	public Object uncheckGoods(@PathVariable Integer goodsId) throws Exception, RuntimeException {

		if(goodsId == null){
			
			throw new BusinessErrorException(ErrorCodes.PARAM_ERROR, "参数为空");
			
		}
		GoodsCommon goodsCommon = new GoodsCommon();
		goodsCommon.setGoodsVerify(2);
		GoodsCommon common = goodsCommonService.modifyGoodsCommonByVerify(goodsId, goodsCommon);
		
		return common;
	}

	/**
	 * 下架
	 *
	 * @return
	 */
	@RequestMapping(value = "/unshelve/{goodsId}", method = RequestMethod.PUT)
	@ResponseBody()
	public Object unshelveGoods(@PathVariable Integer goodsId) throws BusinessErrorException {
		if(goodsId == null){

			throw new BusinessErrorException(ErrorCodes.PARAM_ERROR, "参数为空");

		}
		GoodsCommon goodsCommon = new GoodsCommon();
		goodsCommon.setGoodsState(0);
		GoodsCommon common = goodsCommonService.modifyGoodsCommonByState(goodsId, goodsCommon);

		return common;
	}

	@RequestMapping(value="downloadExcel")
    public String download(HttpServletRequest request,HttpServletResponse response) throws IOException{
        String fileName="商品信息";
        //填充projects数据
        List<ExcelTest> projects=createData();
        List<Map<String,Object>> list=createExcelRecord(projects);
        String columnNames[]={"ID","项目名","销售人","负责人","所用技术","备注"};//列名
        String keys[]    =     {"id","name","saler","principal","technology","remarks"};//map中的key
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
    private List<ExcelTest> createData() {
        // TODO Auto-generated method stub
        //自己实现
    	List<ExcelTest> list = new ArrayList<ExcelTest>();
    	for(int i = 0; i < 20; i++){
    		ExcelTest excel = new ExcelTest();
    		excel.setId(1+i);
    		excel.setName("肖"+i);
    		excel.setTechnology("合肥"+i);
    		excel.setRemarks("备注"+i);
    		list.add(excel);
    	}
        return list;
    }
    private List<Map<String, Object>> createExcelRecord(List<ExcelTest> projects) {
        List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("sheetName", "sheet1");
        listmap.add(map);
        ExcelTest project=null;
        for (int j = 0; j < projects.size(); j++) {
            project=projects.get(j);
            Map<String, Object> mapValue = new HashMap<String, Object>();
	            mapValue.put("id", project.getId());
	            mapValue.put("name", project.getName());
	            mapValue.put("technology", project.getTechnology());
	            mapValue.put("remarks", project.getRemarks());
            listmap.add(mapValue);
        }
        return listmap;
    
}
}
