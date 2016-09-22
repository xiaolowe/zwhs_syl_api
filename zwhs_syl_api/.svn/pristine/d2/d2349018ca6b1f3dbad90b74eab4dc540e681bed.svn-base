package cn.org.citycloud.zwhs.syl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import cn.org.citycloud.zwhs.syl.entity.ArticleClass;

/**
 * 母婴知识分类Dao
 * 
 * @author lanbo
 *
 */
public interface ArticleClassDao extends JpaRepository<ArticleClass, Integer>,
		JpaSpecificationExecutor<ArticleClass> {
	
	public long countByArticleClassName(String className);
	
	
	
}
