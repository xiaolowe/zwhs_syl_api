package cn.org.citycloud.zwhs.syl.entity;
import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;


/**
 * The persistent class for the store_coupon database table.
 * 
 */
@Entity
@Table(name="store_coupon")
@NamedQuery(name="StoreCoupon.findAll", query="SELECT s FROM StoreCoupon s")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class StoreCoupon implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="coupon_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int couponId;

	@Column(name="coupon_condition")
	private Double couponCondition;

	@Column(name="coupon_limit")
	private int couponLimit;

	@Column(name="coupon_money")
	private Double couponMoney;

	@Column(name="coupon_name")
	private String couponName;

	@Column(name="coupon_number")
	private int couponNumber;

	@Column(name="coupon_status")
	private int couponStatus;

	@Column(name="coupon_symbol")
	private String couponSymbol;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="effective_time")
	private Date effectiveTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="expiration_time")
	private Date expirationTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ins_date")
	private Date insDate;

	@Column(name="store_id")
	private Integer storeId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="upd_date")
	private Date updDate;
	
	@Column(name="coupon_amount")
	private int couponAmount;
	
	@Column(name="coupon_desc")
	private String couponDesc;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name="coupon_id", insertable = false, updatable = false)
	private StoreOrderCoupon storeOrderCoupon;

	public StoreCoupon() {
	}

	public StoreCoupon(Double couponCondition, int couponLimit, Double couponMoney, String couponName,
			int couponNumber, String couponSymbol,  Date insDate, String couponDesc) {
		super();
		this.couponCondition = couponCondition;
		this.couponLimit = couponLimit;
		this.couponMoney = couponMoney;
		this.couponName = couponName;
		this.couponNumber = couponNumber;
		this.couponSymbol = couponSymbol;
		this.insDate = insDate;
		this.couponDesc = couponDesc;
	}



	public int getCouponId() {
		return this.couponId;
	}

	public void setCouponId(int couponId) {
		this.couponId = couponId;
	}

	public Double getCouponCondition() {
		return this.couponCondition;
	}

	public void setCouponCondition(Double couponCondition) {
		this.couponCondition = couponCondition;
	}

	public int getCouponLimit() {
		return this.couponLimit;
	}

	public void setCouponLimit(int couponLimit) {
		this.couponLimit = couponLimit;
	}

	public Double getCouponMoney() {
		return this.couponMoney;
	}

	public void setCouponMoney(Double couponMoney) {
		this.couponMoney = couponMoney;
	}

	public String getCouponName() {
		return this.couponName;
	}

	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}

	public int getCouponNumber() {
		return this.couponNumber;
	}

	public void setCouponNumber(int couponNumber) {
		this.couponNumber = couponNumber;
	}

	public int getCouponStatus() {
		return this.couponStatus;
	}

	public void setCouponStatus(int couponStatus) {
		this.couponStatus = couponStatus;
	}

	public String getCouponSymbol() {
		return this.couponSymbol;
	}

	public void setCouponSymbol(String couponSymbol) {
		this.couponSymbol = couponSymbol;
	}

	public Date getEffectiveTime() {
		return this.effectiveTime;
	}

	public void setEffectiveTime(Date effectiveTime) {
		this.effectiveTime = effectiveTime;
	}

	public Date getExpirationTime() {
		return this.expirationTime;
	}

	public void setExpirationTime(Date expirationTime) {
		this.expirationTime = expirationTime;
	}

	public Date getInsDate() {
		return this.insDate;
	}

	public void setInsDate(Date insDate) {
		this.insDate = insDate;
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

	public int getCouponAmount() {
		return couponAmount;
	}

	public void setCouponAmount(int couponAmount) {
		this.couponAmount = couponAmount;
	}

	public String getCouponDesc() {
		return couponDesc;
	}

	public void setCouponDesc(String couponDesc) {
		this.couponDesc = couponDesc;
	}

	public StoreOrderCoupon getStoreOrderCoupon() {
		return storeOrderCoupon;
	}

	public void setStoreOrderCoupon(StoreOrderCoupon storeOrderCoupon) {
		this.storeOrderCoupon = storeOrderCoupon;
	}

	
}