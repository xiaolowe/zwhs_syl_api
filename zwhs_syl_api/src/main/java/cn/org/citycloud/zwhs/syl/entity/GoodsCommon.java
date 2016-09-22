package cn.org.citycloud.zwhs.syl.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the goods_common database table.
 * 
 */
@Entity
@Table(name="goods_common")
@NamedQuery(name="GoodsCommon.findAll", query="SELECT g FROM GoodsCommon g")
public class GoodsCommon implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="goods_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer goodsId;

	@Column(name="brand_name")
	private String brandName;

	@Column(name="brand_no")
	private Integer brandNo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="confirm_time")
	private Date confirmTime;

	@Column(name="confirm_user_id")
	private Integer confirmUserId;

	@Column(name="confirm_user_name")
	private String confirmUserName;

	@Column(name="contacts_name")
	private String contactsName;

	@Column(name="contacts_phone")
	private String contactsPhone;

	@Column(name="gc_lit_id")
	private Integer gcLitId;

	@Column(name="gc_lit_name")
	private String gcLitName;

	@Column(name="gc_name")
	private String gcName;

	@Column(name="gc_no")
	private Integer gcNo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="goods_addtime")
	private Date goodsAddtime;

	@Lob
	@Column(name="goods_attr")
	private String goodsAttr;

	@Lob
	@Column(name="goods_body")
	private String goodsBody;

	@Column(name="goods_costprice")
	private Double goodsCostprice;

	@Column(name="goods_image")
	private String goodsImage;

	@Column(name="goods_image_small")
	private String goodsImageSmall;

	@Column(name="goods_marketprice")
	private Double goodsMarketprice;

	@Column(name="goods_name")
	private String goodsName;

	@Column(name="goods_price")
	private Double goodsPrice;

	@Column(name="goods_sn")
	private String goodsSn;

	@Lob
	@Column(name="goods_spec")
	private String goodsSpec;

	@Column(name="goods_state")
	private Integer goodsState;

	@Column(name="goods_verify")
	private Integer goodsVerify;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ins_date")
	private Date insDate;

	@Column(name="member_id")
	private Integer memberId;

	@Column(name="store_id")
	private Integer storeId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="upd_date")
	private Date updDate;

	public GoodsCommon() {
	}
	//添加
	public GoodsCommon(String brandName, Integer brandNo, String contactsName, Integer gcLitId, String gcLitName,
			String gcName, Integer gcNo, String goodsBody, String goodsImage, String goodsImageSmall, String goodsName,
			String goodsSn, String goodsSpec, Integer goodsState,  Integer goodsVerify, Date insDate) {
		super();
		this.brandName = brandName;
		this.brandNo = brandNo;
		this.contactsName = contactsName;
		this.gcLitId = gcLitId;
		this.gcLitName = gcLitName;
		this.gcName = gcName;
		this.gcNo = gcNo;
		this.goodsBody = goodsBody;
		this.goodsImage = goodsImage;
		this.goodsImageSmall = goodsImageSmall;
		this.goodsName = goodsName;
		this.goodsSn = goodsSn;
		this.goodsSpec = goodsSpec;
		this.goodsState = goodsState;
		this.goodsVerify = goodsVerify;
		this.insDate = insDate;
	}
	//修改
	public GoodsCommon(String brandName, Integer brandNo, String contactsName, Integer gcLitId, String gcLitName,
			String gcName, Integer gcNo, String goodsBody, String goodsImage, String goodsImageSmall, String goodsName,
			String goodsSn, String goodsSpec,  Integer goodsVerify, Date insDate) {
		super();
		this.brandName = brandName;
		this.brandNo = brandNo;
		this.contactsName = contactsName;
		this.gcLitId = gcLitId;
		this.gcLitName = gcLitName;
		this.gcName = gcName;
		this.gcNo = gcNo;
		this.goodsBody = goodsBody;
		this.goodsImage = goodsImage;
		this.goodsImageSmall = goodsImageSmall;
		this.goodsName = goodsName;
		this.goodsSn = goodsSn;
		this.goodsSpec = goodsSpec;
		this.goodsVerify = goodsVerify;
		this.insDate = insDate;
	}
	
	public Integer getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public String getBrandName() {
		return this.brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public Integer getBrandNo() {
		return this.brandNo;
	}

	public void setBrandNo(Integer brandNo) {
		this.brandNo = brandNo;
	}

	public Date getConfirmTime() {
		return this.confirmTime;
	}

	public void setConfirmTime(Date confirmTime) {
		this.confirmTime = confirmTime;
	}

	public Integer getConfirmUserId() {
		return this.confirmUserId;
	}

	public void setConfirmUserId(Integer confirmUserId) {
		this.confirmUserId = confirmUserId;
	}

	public String getConfirmUserName() {
		return this.confirmUserName;
	}

	public void setConfirmUserName(String confirmUserName) {
		this.confirmUserName = confirmUserName;
	}

	public String getContactsName() {
		return this.contactsName;
	}

	public void setContactsName(String contactsName) {
		this.contactsName = contactsName;
	}

	public String getContactsPhone() {
		return this.contactsPhone;
	}

	public void setContactsPhone(String contactsPhone) {
		this.contactsPhone = contactsPhone;
	}

	public Integer getGcLitId() {
		return this.gcLitId;
	}

	public void setGcLitId(Integer gcLitId) {
		this.gcLitId = gcLitId;
	}

	public String getGcLitName() {
		return this.gcLitName;
	}

	public void setGcLitName(String gcLitName) {
		this.gcLitName = gcLitName;
	}

	public String getGcName() {
		return this.gcName;
	}

	public void setGcName(String gcName) {
		this.gcName = gcName;
	}

	public Integer getGcNo() {
		return this.gcNo;
	}

	public void setGcNo(Integer gcNo) {
		this.gcNo = gcNo;
	}

	public Date getGoodsAddtime() {
		return this.goodsAddtime;
	}

	public void setGoodsAddtime(Date goodsAddtime) {
		this.goodsAddtime = goodsAddtime;
	}

	public String getGoodsAttr() {
		return this.goodsAttr;
	}

	public void setGoodsAttr(String goodsAttr) {
		this.goodsAttr = goodsAttr;
	}

	public String getGoodsBody() {
		return this.goodsBody;
	}

	public void setGoodsBody(String goodsBody) {
		this.goodsBody = goodsBody;
	}

	public Double getGoodsCostprice() {
		return this.goodsCostprice;
	}

	public void setGoodsCostprice(Double goodsCostprice) {
		this.goodsCostprice = goodsCostprice;
	}

	public String getGoodsImage() {
		return this.goodsImage;
	}

	public void setGoodsImage(String goodsImage) {
		this.goodsImage = goodsImage;
	}

	public String getGoodsImageSmall() {
		return this.goodsImageSmall;
	}

	public void setGoodsImageSmall(String goodsImageSmall) {
		this.goodsImageSmall = goodsImageSmall;
	}

	public Double getGoodsMarketprice() {
		return this.goodsMarketprice;
	}

	public void setGoodsMarketprice(Double goodsMarketprice) {
		this.goodsMarketprice = goodsMarketprice;
	}

	public String getGoodsName() {
		return this.goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public Double getGoodsPrice() {
		return this.goodsPrice;
	}

	public void setGoodsPrice(Double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public String getGoodsSn() {
		return this.goodsSn;
	}

	public void setGoodsSn(String goodsSn) {
		this.goodsSn = goodsSn;
	}

	public String getGoodsSpec() {
		return this.goodsSpec;
	}

	public void setGoodsSpec(String goodsSpec) {
		this.goodsSpec = goodsSpec;
	}

	public Integer getGoodsState() {
		return this.goodsState;
	}

	public void setGoodsState(Integer goodsState) {
		this.goodsState = goodsState;
	}

	public Integer getGoodsVerify() {
		return this.goodsVerify;
	}

	public void setGoodsVerify(Integer goodsVerify) {
		this.goodsVerify = goodsVerify;
	}

	public Date getInsDate() {
		return this.insDate;
	}

	public void setInsDate(Date insDate) {
		this.insDate = insDate;
	}

	public Integer getMemberId() {
		return this.memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Integer getStoreId() {
		return this.storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public Date getUpdDate() {
		return this.updDate;
	}

	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}

}