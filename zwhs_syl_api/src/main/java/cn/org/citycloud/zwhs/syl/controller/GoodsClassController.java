package cn.org.citycloud.zwhs.syl.controller;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.org.citycloud.zwhs.syl.bean.GoodsClassBean;
import cn.org.citycloud.zwhs.syl.constants.ErrorCodes;
import cn.org.citycloud.zwhs.syl.entity.GoodsClass;
import cn.org.citycloud.zwhs.syl.exception.BusinessErrorException;
import cn.org.citycloud.zwhs.syl.service.GoodsClassService;
import cn.org.citycloud.zwhs.syl.utils.APIInfo;
import cn.org.citycloud.zwhs.syl.utils.InfoEntity;


@Controller
@RequestMapping("goodsclass")
public class GoodsClassController {
	
	@Autowired
	private GoodsClassService goodsClassService;
	
	/**
	 * 根据分类父id
	 * 获取商品分类
	 * 列表
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody()
	public Object getGoodsClass(@RequestParam("parent_id")  Integer parentId) throws Exception, RuntimeException {

		if(parentId == null){
			
			throw new BusinessErrorException(ErrorCodes.PARAM_ERROR, "参数为空");
			
		}
		
		List<GoodsClass> list = goodsClassService.getGoodClassByPid(parentId);
		
		return list;
	}
	
	
	/**
	 * 添加商品分类
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody()
	public Object addGoodsClass(@Valid @RequestBody GoodsClassBean bean) throws Exception, RuntimeException {

		Date now = new Date();
		
		GoodsClass goodsClass = new GoodsClass(bean.getGc_name(), bean.getGc_parent_id(),
				bean.getGc_sort(), bean.getGc_title(), now);
		
		return goodsClassService.addGoodsClass(goodsClass);
		
	}
	
	/**
	 * 编辑商品分类
	 * @return
	 */
	@RequestMapping(value = "/edit/{gcNo}", method = RequestMethod.PUT)
	@ResponseBody()
	public Object modifyGoodsClass(@PathVariable Integer gcNo, 
			@Valid @RequestBody GoodsClassBean bean) throws Exception, RuntimeException {

		
		if(gcNo == null ){
			
			throw new BusinessErrorException(ErrorCodes.PARAM_ERROR, "参数为空");
			
		}
		Date now = new Date();
		GoodsClass goodsClass = new GoodsClass(bean.getGc_name(), null,
				bean.getGc_sort(), bean.getGc_title(), now);
		
		return goodsClassService.modifyGoodsClass(gcNo, goodsClass);
		
	}
	
	/**
	 * 删除商品分类
	 * @return
	 */
	@RequestMapping(value = "/delete/{gcNo}", method = RequestMethod.DELETE)
	@ResponseBody()
	public Object deleteGoodsClass(@PathVariable Integer gcNo) throws Exception, RuntimeException {

		
		if(gcNo == null ){
			
			throw new BusinessErrorException(ErrorCodes.PARAM_ERROR, "参数为空");
			
		}
		List<GoodsClass> list = goodsClassService.getGoodsClassByParentId(gcNo);
		if(list != null && list.size() > 0){
			
			throw new BusinessErrorException(ErrorCodes.OPERATION_ERROR, "存在二级分类删除失败!");
		}
		 goodsClassService.removeGoodsClass(gcNo);
		 
		 return new InfoEntity(APIInfo.SUCCESS);
		
	}
	
}
