package cn.org.citycloud.zwhs.syl.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the brand database table.
 * 
 */
@Entity
@NamedQuery(name="Brand.findAll", query="SELECT b FROM Brand b")
public class Brand implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="brand_no")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer brandNo;

	@Column(name="brand_name")
	private String brandName;

	@Column(name="brand_pic")
	private String brandPic;

	@Column(name="brand_sort")
	private Integer brandSort;

	@Column(name="brand_stat")
	private Integer brandStat;

	@Column(name="contacts_name")
	private String contactsName;

	@Column(name="goods_source")
	private Integer goodsSource;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ins_date")
	private Date insDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="upd_date")
	private Date updDate;

	public Brand() {
	}
	
	public Brand(String brandName, String brandPic, 
			String contactsName, Integer goodsSource,Date insDate) {
		super();
		this.brandName = brandName;
		this.brandPic = brandPic;
		this.contactsName = contactsName;
		this.goodsSource = goodsSource;
		this.insDate = insDate;
	}



	public Integer getBrandNo() {
		return this.brandNo;
	}

	public void setBrandNo(Integer brandNo) {
		this.brandNo = brandNo;
	}

	public String getBrandName() {
		return this.brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getBrandPic() {
		return this.brandPic;
	}

	public void setBrandPic(String brandPic) {
		this.brandPic = brandPic;
	}

	public Integer getBrandSort() {
		return this.brandSort;
	}

	public void setBrandSort(Integer brandSort) {
		this.brandSort = brandSort;
	}

	public Integer getBrandStat() {
		return this.brandStat;
	}

	public void setBrandStat(Integer brandStat) {
		this.brandStat = brandStat;
	}

	public String getContactsName() {
		return this.contactsName;
	}

	public void setContactsName(String contactsName) {
		this.contactsName = contactsName;
	}

	public Integer getGoodsSource() {
		return this.goodsSource;
	}

	public void setGoodsSource(Integer goodsSource) {
		this.goodsSource = goodsSource;
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