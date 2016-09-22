package cn.org.citycloud.zwhs.syl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import cn.org.citycloud.zwhs.syl.entity.KnowledgeInfo;
import cn.org.citycloud.zwhs.syl.entity.MaterialWarehouse;

/**
 * 母婴知识Dao
 * 
 * @author lanbo
 *
 */
public interface KnowledgeInfoDao extends
		JpaRepository<MaterialWarehouse, Integer>,
		JpaSpecificationExecutor<MaterialWarehouse> {

	public long countByArticleTitle(String articleTitle);
	
	public long countByarticleClassId(int articleClassId);
	
	@Query("SELECT a FROM MaterialWarehouse a WHERE a.id <> ?1 and a.articleTitle = ?2 ")
	public KnowledgeInfo getKnowledgeByArticleTitle(int id, String articleTitle);
	
}
