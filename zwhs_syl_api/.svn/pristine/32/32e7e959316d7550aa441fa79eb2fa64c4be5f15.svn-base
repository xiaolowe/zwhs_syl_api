package cn.org.citycloud.zwhs.syl.controller;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
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

import cn.org.citycloud.zwhs.syl.bean.BrandBean;
import cn.org.citycloud.zwhs.syl.constants.ErrorCodes;
import cn.org.citycloud.zwhs.syl.entity.Brand;
import cn.org.citycloud.zwhs.syl.exception.BusinessErrorException;
import cn.org.citycloud.zwhs.syl.service.BrandService;


@Controller
@RequestMapping("brand")
public class BrandController {
	
	@Autowired
	private BrandService brandService;
	
	/**
	 * 获取品牌列表
	 * 列表
	 * @return
	 */
	@RequestMapping(value = "/listall", method = RequestMethod.GET)
	@ResponseBody()
	public Object getBrandList() throws Exception, RuntimeException {

		List<Brand> list = brandService.getBrandListAll();
		return list;
	}
	
	/**
	 * 获取品牌列表
	 * 列表
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody()
	public Object getGoods(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
	        @RequestParam(value = "pageSize", defaultValue = "10")  Integer pageSize,
	        @RequestParam(value = "brand_no", required = false)  Integer brandNo,
	        @RequestParam(value = "brand_name", required = false) String brandName) throws Exception, RuntimeException {

		Sort sort = new Sort(Direction.DESC, "brandNo");
	    Pageable pageable = new PageRequest(pageNo - 1, pageSize, sort);
	    Brand brand = new Brand();
	    brand.setBrandNo(brandNo);
	    brand.setBrandName(brandName);
		Page<Brand> list = brandService.getBrandList(pageable, brand);
		return list;
	}
	
	/**
	 * 添加品牌信息
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody()
	public Object addBrand(@Valid @RequestBody BrandBean brandBean) throws Exception, RuntimeException {

		
		Date now = new Date();
		Brand brand = new Brand(brandBean.getBrand_name(), brandBean.getBrand_pic(),
				brandBean.getContacts_name(), brandBean.getGoods_source(), now);
		
		Brand  brand2= brandService.getBrandByBrandName(brandBean.getBrand_name());
		if(brand2 != null){
			throw new BusinessErrorException(ErrorCodes.REPEAT_ERROR, "该商品品牌已经存在");
		}
		
		brandService.addBrand(brand);
		
		return brand;
	}
	
	/**
	 * 更新品牌信息
	 * @return
	 */
	@RequestMapping(value = "/edit/{brandNo}", method = RequestMethod.PUT)
	@ResponseBody()
	public Object modifyBrand(@PathVariable Integer brandNo, @Valid @RequestBody BrandBean brandBean) throws Exception, RuntimeException {

		
		Date now = new Date();
		Brand brand = new Brand(brandBean.getBrand_name(), brandBean.getBrand_pic(),
				brandBean.getContacts_name(), brandBean.getGoods_source(), now);
		brandService.modifyBrand(brandNo, brand);
		
		return brand;
	}
	
	
	/**
	 * 查看品牌详情
	 * @return
	 */
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	@ResponseBody()
	public Object detailBrand(
			@RequestParam(value = "brand_no") Integer brandNo) throws Exception, RuntimeException {

		if(brandNo == null){
			
			throw new BusinessErrorException(ErrorCodes.PARAM_ERROR, "参数为空");
			
		}
		Brand brand = brandService.getBrandByBrandNo(brandNo);
		
		return brand;
	}
	
}
