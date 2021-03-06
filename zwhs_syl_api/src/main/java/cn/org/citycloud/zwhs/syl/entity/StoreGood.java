package cn.org.citycloud.zwhs.syl.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the store_goods database table.
 * 
 */
@Entity
@Table(name="store_goods")
@NamedQuery(name="StoreGood.findAll", query="SELECT s FROM StoreGood s")
public class StoreGood implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="goods_id")
	private Integer goodsId;

	@Column(name="avg_score")
	private BigDecimal avgScore;

	@Column(name="brand_name")
	private String brandName;

	@Column(name="brand_no")
	private Integer brandNo;

	@Column(name="evaluated_num")
	private Integer evaluatedNum;

	@Column(name="gc_lit_id")
	private Integer gcLitId;

	@Column(name="gc_lit_name")
	private String gcLitName;

	@Column(name="gc_name")
	private String gcName;

	@Column(name="gc_no")
	private Integer gcNo;

	@Lob
	@Column(name="goods_attr")
	private String goodsAttr;

	@Lob
	@Column(name="goods_body")
	private String goodsBody;

	@Column(name="goods_costprice")
	private BigDecimal goodsCostprice;

	@Column(name="goods_image")
	private String goodsImage;

	@Column(name="goods_image_small")
	private String goodsImageSmall;

	@Column(name="goods_marketprice")
	private BigDecimal goodsMarketprice;

	@Column(name="goods_name")
	private String goodsName;

	@Column(name="goods_number")
	private Integer goodsNumber;

	@Column(name="goods_price")
	private BigDecimal goodsPrice;

	@Column(name="goods_sellprice")
	private BigDecimal goodsSellprice;

	@Column(name="goods_sn")
	private String goodsSn;

	@Lob
	@Column(name="goods_spec")
	private String goodsSpec;

	@Column(name="goods_state")
	private Integer goodsState;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ins_date")
	private Date insDate;

	@Column(name="is_recommend")
	private Integer isRecommend;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="offline_time")
	private Date offlineTime;

	@Column(name="sell_number")
	private Integer sellNumber;

	@Column(name="stock_number")
	private Integer stockNumber;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="upd_date")
	private Date updDate;

	@Column(name = "is_add_retail")
	private int isAddRetail;

	@Column(name = "goods_verify")
	private int goodsVerify;

	@Column(name = "retail_sale_price")
	private BigDecimal retailSalePrice;

	@Column(name="retail_init_price", precision=10, scale=2)
	private BigDecimal retailInitPrice;

	// optional=true：可选，表示此对象可以没有，可以为null；false表示必须存在
    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.MERGE }, optional = true)
    @JoinColumn(name="store_id", insertable = false, updatable = false)
    private Store store;

	public StoreGood() {
	}
	

	public Integer getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public BigDecimal getAvgScore() {
		return this.avgScore;
	}

	public void setAvgScore(BigDecimal avgScore) {
		this.avgScore = avgScore;
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

	public Integer getEvaluatedNum() {
		return this.evaluatedNum;
	}

	public void setEvaluatedNum(Integer evaluatedNum) {
		this.evaluatedNum = evaluatedNum;
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

	public BigDecimal getGoodsCostprice() {
		return this.goodsCostprice;
	}

	public void setGoodsCostprice(BigDecimal goodsCostprice) {
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

	public BigDecimal getGoodsMarketprice() {
		return this.goodsMarketprice;
	}

	public void setGoodsMarketprice(BigDecimal goodsMarketprice) {
		this.goodsMarketprice = goodsMarketprice;
	}

	public String getGoodsName() {
		return this.goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public Integer getGoodsNumber() {
		return this.goodsNumber;
	}

	public void setGoodsNumber(Integer goodsNumber) {
		this.goodsNumber = goodsNumber;
	}

	public BigDecimal getGoodsPrice() {
		return this.goodsPrice;
	}

	public void setGoodsPrice(BigDecimal goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public BigDecimal getGoodsSellprice() {
		return this.goodsSellprice;
	}

	public void setGoodsSellprice(BigDecimal goodsSellprice) {
		this.goodsSellprice = goodsSellprice;
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

	public Date getInsDate() {
		return this.insDate;
	}

	public void setInsDate(Date insDate) {
		this.insDate = insDate;
	}

	public Integer getIsRecommend() {
		return this.isRecommend;
	}

	public void setIsRecommend(Integer isRecommend) {
		this.isRecommend = isRecommend;
	}

	public Date getOfflineTime() {
		return this.offlineTime;
	}

	public void setOfflineTime(Date offlineTime) {
		this.offlineTime = offlineTime;
	}

	public Integer getSellNumber() {
		return this.sellNumber;
	}

	public void setSellNumber(Integer sellNumber) {
		this.sellNumber = sellNumber;
	}

	public Integer getStockNumber() {
		return this.stockNumber;
	}

	public void setStockNumber(Integer stockNumber) {
		this.stockNumber = stockNumber;
	}

	public Date getUpdDate() {
		return this.updDate;
	}

	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public int getGoodsVerify() {
		return goodsVerify;
	}

	public void setGoodsVerify(int goodsVerify) {
		this.goodsVerify = goodsVerify;
	}

	public int getIsAddRetail() {
		return isAddRetail;
	}

	public void setIsAddRetail(int isAddRetail) {
		this.isAddRetail = isAddRetail;
	}

	public BigDecimal getRetailSalePrice() {
		return retailSalePrice;
	}

	public void setRetailSalePrice(BigDecimal retailSalePrice) {
		this.retailSalePrice = retailSalePrice;
	}

	public BigDecimal getRetailInitPrice() {
		return retailInitPrice;
	}

	public void setRetailInitPrice(BigDecimal retailInitPrice) {
		this.retailInitPrice = retailInitPrice;
	}
}