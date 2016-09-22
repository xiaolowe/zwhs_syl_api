package cn.org.citycloud.zwhs.syl.bean;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 母婴知识Bean
 * 
 * @author lanbo
 *
 */
public class KnowledgeBean {

	@Min(0)
	private int articleClassId;

	@NotEmpty
	private String articleComments;

	@Min(0)
	private int articleState;

	@NotEmpty
	@Length(max=30)
	private String articleTitle;

	@NotEmpty
	@Length(max=100)
	private String coverPic;


	public int getArticleClassId() {
		return articleClassId;
	}

	public void setArticleClassId(int articleClassId) {
		this.articleClassId = articleClassId;
	}


	public String getArticleComments() {
		return articleComments;
	}

	public void setArticleComments(String articleComments) {
		this.articleComments = articleComments;
	}

	public int getArticleState() {
		return articleState;
	}

	public void setArticleState(int articleState) {
		this.articleState = articleState;
	}

	public String getArticleTitle() {
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public String getCoverPic() {
		return coverPic;
	}

	public void setCoverPic(String coverPic) {
		this.coverPic = coverPic;
	}

}
