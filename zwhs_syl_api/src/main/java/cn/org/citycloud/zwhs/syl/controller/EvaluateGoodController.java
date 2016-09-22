package cn.org.citycloud.zwhs.syl.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.org.citycloud.zwhs.syl.constants.ErrorCodes;
import cn.org.citycloud.zwhs.syl.entity.EvaluateGood;
import cn.org.citycloud.zwhs.syl.exception.BusinessErrorException;
import cn.org.citycloud.zwhs.syl.service.EvaluateGoodService;

@Controller
@RequestMapping("evaluategood")
public class EvaluateGoodController {
	
	@Autowired
	private EvaluateGoodService evaluateGoodService;
	
	
	/**
	 * 列表
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody()
	public Object getEvaluateGood(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
	        @RequestParam(value = "pageSize", defaultValue = "10")  Integer pageSize,
	        @RequestParam(value = "store_goods_id")  Integer storeGoodsId) throws Exception, RuntimeException {

		Sort sort = new Sort(Direction.DESC, "gevalId");
	    Pageable pageable = new PageRequest(pageNo - 1, pageSize, sort);
	    
	    if(storeGoodsId == null){
			throw new BusinessErrorException(ErrorCodes.PARAM_ERROR, "参数为空");
		}
	    EvaluateGood evaluateGood = new EvaluateGood();
	    evaluateGood.setGoodsId(storeGoodsId);
	   
		Page<EvaluateGood> list = evaluateGoodService.getEvaluateGoodList(pageable, evaluateGood);
		return list;
	}
	
	
	/**
	 * 屏蔽评论
	 * @return
	 */
	@RequestMapping(value = "/block/{gevalId}", method = RequestMethod.PUT)
	@ResponseBody()
	public Object checkGoods(@PathVariable Integer gevalId,
			@RequestParam(value = "geval_state")  Integer gevalState) throws Exception, RuntimeException {

		if(gevalId == null){
			
			throw new BusinessErrorException(ErrorCodes.PARAM_ERROR, "参数为空");
			
		}
		EvaluateGood evaluateGood = new EvaluateGood();
		evaluateGood.setGevalState(gevalState);
		EvaluateGood evaluate = evaluateGoodService.modifyEvaluateGoodByState(gevalId, evaluateGood);
		
		return evaluate;
	}
}
