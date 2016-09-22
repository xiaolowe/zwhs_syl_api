package cn.org.citycloud.zwhs.syl.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the goods_class database table.
 * 
 */
@Entity
@Table(name="goods_class")
@NamedQuery(name="GoodsClass.findAll", query="SELECT g FROM GoodsClass g")
public class GoodsClass implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="gc_no")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer gcNo;

	@Column(name="gc_description")
	private String gcDescription;

	@Column(name="gc_keywords")
	private String gcKeywords;

	@Column(name="gc_name")
	private String gcName;

	@Column(name="gc_parent_id")
	private Integer gcParentId;

	@Column(name="gc_sort")
	private Integer gcSort;

	@Column(name="gc_title")
	private String gcTitle;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ins_date")
	private Date insDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="upd_date")
	private Date updDate;

	public GoodsClass() {
	}
	
	public GoodsClass(String gcName, Integer gcParentId, Integer gcSort, String gcTitle, Date insDate) {
		super();
		this.gcName = gcName;
		this.gcParentId = gcParentId;
		this.gcSort = gcSort;
		this.gcTitle = gcTitle;
		this.insDate = insDate;
	}

	public Integer getGcNo() {
		return this.gcNo;
	}

	public void setGcNo(Integer gcNo) {
		this.gcNo = gcNo;
	}

	public String getGcDescription() {
		return this.gcDescription;
	}

	public void setGcDescription(String gcDescription) {
		this.gcDescription = gcDescription;
	}

	public String getGcKeywords() {
		return this.gcKeywords;
	}

	public void setGcKeywords(String gcKeywords) {
		this.gcKeywords = gcKeywords;
	}

	public String getGcName() {
		return this.gcName;
	}

	public void setGcName(String gcName) {
		this.gcName = gcName;
	}

	public Integer getGcParentId() {
		return this.gcParentId;
	}

	public void setGcParentId(Integer gcParentId) {
		this.gcParentId = gcParentId;
	}

	public Integer getGcSort() {
		return this.gcSort;
	}

	public void setGcSort(Integer gcSort) {
		this.gcSort = gcSort;
	}

	public String getGcTitle() {
		return this.gcTitle;
	}

	public void setGcTitle(String gcTitle) {
		this.gcTitle = gcTitle;
	}

	public Date getInsDate() {
		return this.insDate;
	}

	public void setInsDate(Date insDate) {
		this.insDate = insDate;
	}

	public Date getUpdDate() {
		return this.updDate;
	}

	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}

}