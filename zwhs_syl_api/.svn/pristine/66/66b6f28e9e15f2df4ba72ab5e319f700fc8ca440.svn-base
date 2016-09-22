package cn.org.citycloud.zwhs.syl.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;


/**
 * The persistent class for the order_goods database table.
 * 
 */
@Entity
@Table(name="order_goods")
@NamedQuery(name="OrderGood.findAll", query="SELECT o FROM OrderGood o")
public class OrderGood implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="order_goods_id")
	private Integer orderGoodsId;

	@Column(name="brand_name")
	private String brandName;

	@Column(name="commis_rate")
	private BigDecimal commisRate;

	@Column(name="goods_id")
	private Integer goodsId;

	@Column(name="goods_image")
	private String goodsImage;

	@Column(name="goods_name")
	private String goodsName;

	@Column(name="goods_num")
	private Integer goodsNum;

	@Column(name="goods_pay_price")
	private BigDecimal goodsPayPrice;

	@Column(name="goods_price")
	private BigDecimal goodsPrice;

	@Lob
	@Column(name="goods_spec")
	private String goodsSpec;

	@Column(name="goods_type")
	private Integer goodsType;

	@Column(name="member_id")
	private Integer memberId;

	@Column(name="order_type")
	private Integer orderType;

	@Column(name="promotions_id")
	private Integer promotionsId;

	@Column(name="store_id")
	private Integer storeId;
	
	@ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.MERGE }, optional = true)
    @JoinColumn(name="order_id", insertable = false, updatable = false)
    @JsonIgnore
    private StoreOrder storeOrder;

	public OrderGood() {
	}

	public Integer getOrderGoodsId() {
		return this.orderGoodsId;
	}

	public void setOrderGoodsId(Integer orderGoodsId) {
		this.orderGoodsId = orderGoodsId;
	}

	public String getBrandName() {
		return this.brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public BigDecimal getCommisRate() {
		return this.commisRate;
	}

	public void setCommisRate(BigDecimal commisRate) {
		this.commisRate = commisRate;
	}

	public Integer getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsImage() {
		return this.goodsImage;
	}

	public void setGoodsImage(String goodsImage) {
		this.goodsImage = goodsImage;
	}

	public String getGoodsName() {
		return this.goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public Integer getGoodsNum() {
		return this.goodsNum;
	}

	public void setGoodsNum(Integer goodsNum) {
		this.goodsNum = goodsNum;
	}

	public BigDecimal getGoodsPayPrice() {
		return this.goodsPayPrice;
	}

	public void setGoodsPayPrice(BigDecimal goodsPayPrice) {
		this.goodsPayPrice = goodsPayPrice;
	}

	public BigDecimal getGoodsPrice() {
		return this.goodsPrice;
	}

	public void setGoodsPrice(BigDecimal goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public String getGoodsSpec() {
		return this.goodsSpec;
	}

	public void setGoodsSpec(String goodsSpec) {
		this.goodsSpec = goodsSpec;
	}

	public Integer getGoodsType() {
		return this.goodsType;
	}

	public void setGoodsType(Integer goodsType) {
		this.goodsType = goodsType;
	}

	public Integer getMemberId() {
		return this.memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}


	public Integer getOrderType() {
		return this.orderType;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}

	public Integer getPromotionsId() {
		return this.promotionsId;
	}

	public void setPromotionsId(Integer promotionsId) {
		this.promotionsId = promotionsId;
	}

	public Integer getStoreId() {
		return this.storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public StoreOrder getStoreOrder() {
		return storeOrder;
	}

	public void setStoreOrder(StoreOrder storeOrder) {
		this.storeOrder = storeOrder;
	}
	
	

}