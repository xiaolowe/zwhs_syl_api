package cn.org.citycloud.zwhs.syl.entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * The persistent class for the store_pay database table.
 * 
 */
@Entity
@Table(name="store_pay")
@NamedQuery(name="StorePay.findAll", query="SELECT s FROM StorePay s")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class StorePay implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="pay_id")
	private Integer payId;

	@Column(name="commis_amount")
	private BigDecimal commisAmount;

	@Column(name="commis_rates")
	private BigDecimal commisRates;

	@Column(name="company_name")
	private String companyName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ins_date")
	private Date insDate;

	@Column(name="open_id")
	private String openId;

	@Column(name="order_type")
	private Integer orderType;

	@Column(name="pay_code")
	private String payCode;

	@Column(name="pay_member_id")
	private Integer payMemberId;

	@Column(name="pay_member_name")
	private String payMemberName;

	@Column(name="pay_member_phone")
	private String payMemberPhone;

	@Column(name="pay_money")
	private BigDecimal payMoney;

	@Column(name="pay_state")
	private Integer payState;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="pay_time")
	private Date payTime;

	private String remark;

	@Column(name="store_amount")
	private BigDecimal storeAmount;

	@Column(name="store_id")
	private Integer storeId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="upd_date")
	private Date updDate;

	@Column(name="wechat_pay_sn")
	private String wechatPaySn;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="order_id", insertable = false, updatable = false)
	private StoreOrder storeOrder;
	
	
	@ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.MERGE }, optional = true)
    @JoinColumn(name="pay_member_id", insertable = false, updatable = false)
    private WechatMember wechatMember;

	public StorePay() {
	}
	
	public StorePay(Integer payId, String companyName, String payMemberName, Integer payState) {
		super();
		this.payId = payId;
		this.companyName = companyName;
		this.payMemberName = payMemberName;
		this.payState = payState;
	}

	public Integer getPayId() {
		return this.payId;
	}

	public void setPayId(Integer payId) {
		this.payId = payId;
	}

	public BigDecimal getCommisAmount() {
		return this.commisAmount;
	}

	public void setCommisAmount(BigDecimal commisAmount) {
		this.commisAmount = commisAmount;
	}

	public BigDecimal getCommisRates() {
		return this.commisRates;
	}

	public void setCommisRates(BigDecimal commisRates) {
		this.commisRates = commisRates;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Date getInsDate() {
		return this.insDate;
	}

	public void setInsDate(Date insDate) {
		this.insDate = insDate;
	}

	public String getOpenId() {
		return this.openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public Integer getOrderType() {
		return this.orderType;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}

	public String getPayCode() {
		return this.payCode;
	}

	public void setPayCode(String payCode) {
		this.payCode = payCode;
	}

	public Integer getPayMemberId() {
		return this.payMemberId;
	}

	public void setPayMemberId(Integer payMemberId) {
		this.payMemberId = payMemberId;
	}

	public String getPayMemberName() {
		return this.payMemberName;
	}

	public void setPayMemberName(String payMemberName) {
		this.payMemberName = payMemberName;
	}

	public String getPayMemberPhone() {
		return this.payMemberPhone;
	}

	public void setPayMemberPhone(String payMemberPhone) {
		this.payMemberPhone = payMemberPhone;
	}

	public BigDecimal getPayMoney() {
		return this.payMoney;
	}

	public void setPayMoney(BigDecimal payMoney) {
		this.payMoney = payMoney;
	}

	public Integer getPayState() {
		return this.payState;
	}

	public void setPayState(Integer payState) {
		this.payState = payState;
	}

	public Date getPayTime() {
		return this.payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public BigDecimal getStoreAmount() {
		return this.storeAmount;
	}

	public void setStoreAmount(BigDecimal storeAmount) {
		this.storeAmount = storeAmount;
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

	public String getWechatPaySn() {
		return this.wechatPaySn;
	}

	public void setWechatPaySn(String wechatPaySn) {
		this.wechatPaySn = wechatPaySn;
	}


	public WechatMember getWechatMember() {
		return wechatMember;
	}

	public void setWechatMember(WechatMember wechatMember) {
		this.wechatMember = wechatMember;
	}

	public StoreOrder getStoreOrder() {
		return storeOrder;
	}

	public void setStoreOrder(StoreOrder storeOrder) {
		this.storeOrder = storeOrder;
	}
	
}