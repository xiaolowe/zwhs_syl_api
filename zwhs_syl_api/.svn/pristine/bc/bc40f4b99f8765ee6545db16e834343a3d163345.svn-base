package cn.org.citycloud.zwhs.syl.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.org.citycloud.zwhs.syl.bean.ArticleClassBean;
import cn.org.citycloud.zwhs.syl.constants.ErrorCodes;
import cn.org.citycloud.zwhs.syl.entity.ArticleClass;
import cn.org.citycloud.zwhs.syl.exception.BusinessErrorException;
import cn.org.citycloud.zwhs.syl.repository.ArticleClassDao;
import cn.org.citycloud.zwhs.syl.repository.KnowledgeInfoDao;

/**
 * 知识分类管理API
 * 
 * @author lanbo
 *
 */
@RestController
public class ArticleClassController {

	@Autowired
	private ArticleClassDao articleClassDao;
	
	@Autowired
	private KnowledgeInfoDao knowledgeDao;

	/**
	 * 获取知识分类信息
	 */
	@RequestMapping(value = "/articleClasses", method = RequestMethod.GET)
	public Object getArticleClass() {

		return articleClassDao.findAll();
	}

	/**
	 * 新增母婴知识分类
	 * 
	 * @throws BusinessErrorException
	 */
	@RequestMapping(value = "/articleClasses", method = RequestMethod.POST)
	public void addArticleClass(@Valid @RequestBody ArticleClassBean articleClass)
			throws BusinessErrorException {

		long count = articleClassDao
				.countByArticleClassName(articleClass.getArticleClassName());

		if (count > 0) {

			throw new BusinessErrorException(ErrorCodes.REPEAT_ERROR,
					"此分类名称已经存在！");
		}
		ArticleClass article = new ArticleClass();
		article.setArticleClassName(articleClass.getArticleClassName());
		Date now = new Date();
		article.setInsDate(now);
		article.setUpdDate(now);

		articleClassDao.save(article);
	}

	/**
	 * 删除母婴知识分类
	 * @throws BusinessErrorException 
	 */
	@RequestMapping(value = "/articleClasses/{id}", method = RequestMethod.DELETE)
	public void deleteArticleClass(@PathVariable int id) throws BusinessErrorException {
		
		long count = knowledgeDao.countByarticleClassId(id);
		
		// 知识分类下 已经有 母婴知识信息无法删除分类
		if(count > 0) {
			
			throw new BusinessErrorException(ErrorCodes.OPERATION_ERROR, "知识分类下已经有母婴知识信息无法删除分类");
		}

		articleClassDao.delete(id);

	}
}
