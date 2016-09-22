package cn.org.citycloud.zwhs.syl.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the page_template database table.
 * 
 */
@Entity
@Table(name="page_template")
@NamedQuery(name="PageTemplate.findAll", query="SELECT p FROM PageTemplate p")
public class PageTemplate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="tpl_id")
	private int tplId;

	@Lob
	private String content;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ins_date")
	private Date insDate;

	@Column(name="store_id")
	private int storeId;

	private String title;

	private int type;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="upd_date")
	private Date updDate;

	public PageTemplate() {
	}

	public int getTplId() {
		return this.tplId;
	}

	public void setTplId(int tplId) {
		this.tplId = tplId;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getInsDate() {
		return this.insDate;
	}

	public void setInsDate(Date insDate) {
		this.insDate = insDate;
	}

	public int getStoreId() {
		return this.storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Date getUpdDate() {
		return this.updDate;
	}

	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}

}