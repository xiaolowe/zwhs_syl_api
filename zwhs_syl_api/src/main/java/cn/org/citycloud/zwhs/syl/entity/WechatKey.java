package cn.org.citycloud.zwhs.syl.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the wechat_key database table.
 * 
 */
@Entity
@Table(name="wechat_key")
@NamedQuery(name="WechatKey.findAll", query="SELECT w FROM WechatKey w")
public class WechatKey implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="key_id", unique=true, nullable=false)
	private int keyId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ins_date")
	private Date insDate;

	@Column(name="keyword_search")
	private int keywordSearch;

	@Column(name="reply_con_type")
	private Integer replyConType;

	@Column(name="reply_keyword", length=30)
	private String replyKeyword;

	@Column(name="reply_text", length=300)
	private String replyText;

	@Column(name="reply_type")
	private int replyType;

	@Column(name="store_id")
	private int storeId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="upd_date")
	private Date updDate;
	
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="wechat_key_pic",joinColumns=@JoinColumn(name="key_id"),inverseJoinColumns=@JoinColumn(name="material_id"))
	private Set<MaterialWarehouse> materialWarehouses;
	
	
	public WechatKey() {
	}

	public int getKeyId() {
		return this.keyId;
	}

	public void setKeyId(int keyId) {
		this.keyId = keyId;
	}

	public Date getInsDate() {
		return this.insDate;
	}

	public void setInsDate(Date insDate) {
		this.insDate = insDate;
	}

	public int getKeywordSearch() {
		return this.keywordSearch;
	}

	public void setKeywordSearch(int keywordSearch) {
		this.keywordSearch = keywordSearch;
	}

	public int getReplyConType() {
		return this.replyConType;
	}

	public void setReplyConType(int replyConType) {
		this.replyConType = replyConType;
	}

	public String getReplyKeyword() {
		return this.replyKeyword;
	}

	public void setReplyKeyword(String replyKeyword) {
		this.replyKeyword = replyKeyword;
	}

	public String getReplyText() {
		return this.replyText;
	}

	public void setReplyText(String replyText) {
		this.replyText = replyText;
	}

	public int getReplyType() {
		return this.replyType;
	}

	public void setReplyType(int replyType) {
		this.replyType = replyType;
	}

	public int getStoreId() {
		return this.storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public Date getUpdDate() {
		return this.updDate;
	}

	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}

	public Set<MaterialWarehouse> getMaterialWarehouses() {
		return materialWarehouses;
	}

	public void setMaterialWarehouses(Set<MaterialWarehouse> materialWarehouses) {
		this.materialWarehouses = materialWarehouses;
	}

}