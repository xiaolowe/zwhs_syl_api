package cn.org.citycloud.zwhs.syl.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;


/**
 * The persistent class for the store_order_coupon database table.
 * 
 */
@Entity
@Table(name="store_order_coupon")
@NamedQuery(name="StoreOrderCoupon.findAll", query="SELECT s FROM StoreOrderCoupon s")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class StoreOrderCoupon implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="coupon_id")
	private int couponId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ins_date")
	private Date insDate;

	@Column(name="order_id")
	private int orderId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="upd_date")
	private Date updDate;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name="order_id", insertable = false, updatable = false)
	private StoreOrder storeOrder;
	
	@OneToOne(mappedBy = "storeOrderCoupon")
	private StoreCoupon storeCoupon;

	public StoreOrderCoupon() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCouponId() {
		return this.couponId;
	}

	public void setCouponId(int couponId) {
		this.couponId = couponId;
	}

	public Date getInsDate() {
		return this.insDate;
	}

	public void setInsDate(Date insDate) {
		this.insDate = insDate;
	}

	public int getOrderId() {
		return this.orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getUpdDate() {
		return this.updDate;
	}

	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}

	public StoreCoupon getStoreCoupon() {
		return storeCoupon;
	}

	public void setStoreCoupon(StoreCoupon storeCoupon) {
		this.storeCoupon = storeCoupon;
	}

	public StoreOrder getStoreOrder() {
		return storeOrder;
	}

	public void setStoreOrder(StoreOrder storeOrder) {
		this.storeOrder = storeOrder;
	}
	
	

}