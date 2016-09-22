package cn.org.citycloud.zwhs.syl.controller;
import java.util.Date;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.org.citycloud.zwhs.syl.bean.KnowledgeBean;
import cn.org.citycloud.zwhs.syl.constants.ErrorCodes;
import cn.org.citycloud.zwhs.syl.entity.ArticleClass;
import cn.org.citycloud.zwhs.syl.entity.KnowledgeInfo;
import cn.org.citycloud.zwhs.syl.entity.MaterialWarehouse;
import cn.org.citycloud.zwhs.syl.exception.BusinessErrorException;
import cn.org.citycloud.zwhs.syl.repository.ArticleClassDao;
import cn.org.citycloud.zwhs.syl.repository.KnowledgeInfoDao;

/**
 * 母婴知识管理API
 * 
 * @author lanbo
 *
 */
@RestController
public class KnowledgeInfoController {

	@Autowired
	private KnowledgeInfoDao knowledgeDao;
	
	@Autowired
	private ArticleClassDao articleClassDao;

	/**
	 * 获取母婴知识列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "/knowledgeInfo", method = RequestMethod.GET)
	public Object getKnowledgeInfo(
			@RequestParam(defaultValue = "1") int pageNo,
			@RequestParam(defaultValue = "10") int pageSize,
			@RequestParam(required = false, defaultValue = "0") int articleClassId,
			@RequestParam(required = false) String keyword) {

		Sort sort = new Sort(Direction.DESC, "id");
		Pageable pageable = new PageRequest(pageNo - 1, pageSize, sort);

		Page<MaterialWarehouse> page = knowledgeDao.findAll(
				new Specification<MaterialWarehouse>() {
					@Override
					public Predicate toPredicate(Root<MaterialWarehouse> root,
							CriteriaQuery<?> query, CriteriaBuilder cb) {

						Predicate where = cb.conjunction();
						
						Path<String> storeId = root
								.get("storeId");
						where = cb.and(where,
								cb.equal(storeId, 0));
						
						Path<String> type = root
								.get("materialType");
						where = cb.and(where,
								cb.equal(type, 2));

						if (articleClassId != 0) {
							Path<String> classIdCond = root
									.get("articleClassId");
							where = cb.and(where,
									cb.equal(classIdCond, articleClassId));

						}
						if (keyword != null && StringUtils.isNotBlank(keyword)) {
							Path<String> articleTitleCond = root
									.get("articleTitle");
							where = cb.and(
									where,
									cb.like(articleTitleCond, "%" + keyword
											+ "%"));
						}
						query.where(where);

						return null;
					}
				}, pageable);

		return page;
	}

	/**
	 * 新增母婴知识
	 * 
	 * @throws BusinessErrorException
	 */
	@RequestMapping(value = "/knowledgeInfo", method = RequestMethod.POST)
	public Object addKnowledgeInfo(@Valid @RequestBody KnowledgeBean knowledge)
			throws BusinessErrorException {

		long count = knowledgeDao.countByArticleTitle(knowledge
				.getArticleTitle());

		if (count > 0) {
			throw new BusinessErrorException(ErrorCodes.REPEAT_ERROR,
					"母婴知识标题已经存在");
		}
		ArticleClass articleClass = articleClassDao.getOne(knowledge.getArticleClassId());
		MaterialWarehouse entity = new MaterialWarehouse();
		BeanUtils.copyProperties(knowledge, entity);

		Date now = new Date();
		entity.setInsDate(now);
		entity.setUpdDate(now);
		entity.setArticleClassName(articleClass.getArticleClassName());
		entity.setArticleState(1);
		entity.setStoreId(0);
		entity.setMaterialType(2);

		return knowledgeDao.save(entity);
	}
	
	/**
	 * 母婴知识详情
	 * 
	 * @throws BusinessErrorException
	 */
	@RequestMapping(value = "/knowledgeInfo/detail/{id}", method = RequestMethod.GET)
	public Object knowledgeInfo(@PathVariable int id) throws BusinessErrorException {


		MaterialWarehouse entity = knowledgeDao.findOne(id);
		
		return entity;
	}

	/**
	 * 编辑母婴知识
	 * 
	 * @throws BusinessErrorException
	 */
	@RequestMapping(value = "/knowledgeInfo/{id}", method = RequestMethod.PUT)
	public Object editKnowledgeInfo(@PathVariable int id,
			@Valid @RequestBody KnowledgeBean knowledge) throws BusinessErrorException {

		KnowledgeInfo info = knowledgeDao.getKnowledgeByArticleTitle(id, knowledge.getArticleTitle());

		if (info != null) {
			throw new BusinessErrorException(ErrorCodes.REPEAT_ERROR,
					"母婴知识标题已经存在");
		}
		ArticleClass articleClass = articleClassDao.getOne(knowledge.getArticleClassId());
		MaterialWarehouse entity = knowledgeDao.findOne(id);
		BeanUtils.copyProperties(knowledge, entity);
		Date now = new Date();
		entity.setUpdDate(now);
		entity.setArticleClassName(articleClass.getArticleClassName());
		return knowledgeDao.save(entity);
	}

	/**
	 * 删除母婴知识
	 */
	@RequestMapping(value = "/knowledgeInfo/{id}", method = RequestMethod.DELETE)
	public void deleteKnowledgeInfo(@PathVariable int id) {

		knowledgeDao.delete(id);
	}
}
