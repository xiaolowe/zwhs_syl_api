package cn.org.citycloud.zwhs.syl.service;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import cn.org.citycloud.zwhs.syl.entity.EvaluateGood;
import cn.org.citycloud.zwhs.syl.repository.EvaluateGoodDao;
/**
 * @author Allen
 */
//Spring Bean的标识.
@Component
// 类中所有public函数都纳入事务管理的标识.
@Transactional
public class EvaluateGoodService {
	@Autowired
	private EvaluateGoodDao evaluateGoodDao;
	
	/**
	 * 动态查询评论列表
	 * @param pageable
	 * @param evaluateGood
	 * @return
	 */
	public Page<EvaluateGood> getEvaluateGoodList(Pageable pageable, EvaluateGood evaluateGood){
		
		Page<EvaluateGood> page = evaluateGoodDao.findAll(new Specification<EvaluateGood>() {
			@Override
			public Predicate toPredicate(Root<EvaluateGood> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				
				Predicate where = cb.conjunction();  
				if(evaluateGood != null && evaluateGood.getGoodsId() != null){
					Path<String> goodsId = root.get("goodsId");  
					where = cb.and(where, cb.equal(goodsId, evaluateGood.getGoodsId())); 
					
				}
				query.where(where);
				  
			    return null;  
			}
		}, pageable);
		
	    return page;
	}
	
	/**
	 * 修改评论显示
	 * @param gevalId
	 * @param evaluateGood
	 * @return
	 */
	public EvaluateGood modifyEvaluateGoodByState(Integer gevalId, EvaluateGood evaluateGood){
		
		EvaluateGood evaluate = evaluateGoodDao.findOne(gevalId);
		evaluate.setGevalState(evaluateGood.getGevalState());
		return evaluateGoodDao.save(evaluate);
		
	}
}
