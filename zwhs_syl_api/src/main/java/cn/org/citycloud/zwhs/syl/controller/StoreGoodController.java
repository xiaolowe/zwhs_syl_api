package cn.org.citycloud.zwhs.syl.controller;

import cn.org.citycloud.zwhs.syl.constants.ErrorCodes;
import cn.org.citycloud.zwhs.syl.entity.Store;
import cn.org.citycloud.zwhs.syl.entity.StoreGood;
import cn.org.citycloud.zwhs.syl.exception.BusinessErrorException;
import cn.org.citycloud.zwhs.syl.service.StoreGoodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("storegood")
@Api(tags = "上架商品管理")
public class StoreGoodController {
	
	@Autowired
	private StoreGoodService storeGoodService;
	
	
	/**
	 * 获取母婴店店铺列表
	 * 列表
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ApiOperation(value="获取商品列表",notes="获取商品列表",consumes="application/json",produces="application/json")
	@ResponseBody()
	public Object getStoreGood(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
	        @RequestParam(value = "pageSize", defaultValue = "10")  Integer pageSize,
	        @RequestParam(value = "gc_no", required = false)  Integer gcNo,
		    @RequestParam(value = "goods_state", required = false)  Integer goodsState,
		    @RequestParam(value = "goods_verify", required = false)  Integer goodsVerify,
	        @RequestParam(value = "goods_name", required = false)  String goodsName,
	        @RequestParam(value = "store_name", required = false)  String storeName,
	        @RequestParam(value = "start_time", required = false)  String startTime,
	        @RequestParam(value = "end_time", required = false)  String endTime) throws Exception, RuntimeException {

		
		Sort sort = new Sort(Direction.DESC, "goodsId");
	    Pageable pageable = new PageRequest(pageNo - 1, pageSize, sort);
	    StoreGood storeGood = new StoreGood();
	    if (gcNo != null) {
			storeGood.setGcNo(gcNo);
		} else {
			storeGood.setGcNo(-1);
		}
	    storeGood.setGoodsName(goodsName);
	    Store store = new Store();
	    store.setCompanyName(storeName);
	    storeGood.setStore(store);
		if (goodsState != null) {
			storeGood.setGoodsState(goodsState);
		} else {
			storeGood.setGoodsState(-1);
		}
		if (goodsVerify != null) {
			storeGood.setGoodsVerify(goodsVerify);
		} else {
			storeGood.setGoodsVerify(-1);
		}
	    Page<StoreGood> list = storeGoodService.getStoreList(pageable, storeGood, startTime, endTime);
		return list;
	}
	
	/**
	 * 查看店铺详情
	 * @return
	 */
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	@ResponseBody()
	public Object detailStoreGoods(
			@RequestParam(value = "goods_id") Integer goodsId) throws Exception, RuntimeException {

		if(goodsId == null){
			
			throw new BusinessErrorException(ErrorCodes.PARAM_ERROR, "参数为空");
			
		}
		StoreGood storeGood = storeGoodService.getStoreGoodByGoodsId(goodsId);
		return storeGood;
	}

	@RequestMapping(value="/{goodsId}/passed",method=RequestMethod.PUT)
	@ApiOperation(value="审核通过",notes="审核通过",consumes="application/json",produces="application/json",httpMethod="PUT")
	@ResponseBody()
	public Object passedGood(@ApiParam(name="goodsId",value="商品Id",required=true) @PathVariable int goodsId) {
		return storeGoodService.passGood(goodsId);
	}

	@RequestMapping(value="/{goodsId}/rejected",method=RequestMethod.PUT)
	@ApiOperation(value="审核驳回",notes="审核驳回",consumes="application/json",produces="application/json",httpMethod="PUT")
	@ResponseBody()
	public Object rejectedGood(@ApiParam(name="goodsId",value="商品Id",required=true) @PathVariable int goodsId) {
		return storeGoodService.rejectedGood(goodsId);
	}

	@RequestMapping(value="/{goodsId}/unshelved",method=RequestMethod.PUT)
	@ApiOperation(value="商品下架",notes="商品下架",consumes="application/json",produces="application/json",httpMethod="PUT")
	@ResponseBody()
	public Object unshelved(@ApiParam(name="goodsId",value="商品Id",required=true) @PathVariable int goodsId) {
		return storeGoodService.unshelved(goodsId);
	}
}
