package cn.org.citycloud.zwhs.syl.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the wechat_member_coupon database table.
 * 
 */
@Entity
@Table(name="wechat_member_coupon")
@NamedQuery(name="WechatMemberCoupon.findAll", query="SELECT w FROM WechatMemberCoupon w")
public class WechatMemberCoupon implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="coupon_id")
	private int couponId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ins_date")
	private Date insDate;

	@Column(name="is_used")
	private byte isUsed;

	@Column(name="member_id")
	private int memberId;

	@Column(name="store_id")
	private int storeId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="upd_date")
	private Date updDate;

	public WechatMemberCoupon() {
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

	public byte getIsUsed() {
		return this.isUsed;
	}

	public void setIsUsed(byte isUsed) {
		this.isUsed = isUsed;
	}

	public int getMemberId() {
		return this.memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
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

}