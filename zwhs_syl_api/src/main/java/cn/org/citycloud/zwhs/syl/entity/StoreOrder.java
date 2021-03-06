package cn.org.citycloud.zwhs.syl.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import cn.org.citycloud.zwhs.syl.entity.OrderGood;
import cn.org.citycloud.zwhs.syl.entity.RegionInfo;
import cn.org.citycloud.zwhs.syl.entity.StorePay;
import cn.org.citycloud.zwhs.syl.entity.WechatMember;


/**
 * The persistent class for the store_order database table.
 * 
 */
@Entity
@Table(name="store_order")
@NamedQuery(name="StoreOrder.findAll", query="SELECT s FROM StoreOrder s")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class StoreOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="order_id")
	private Integer orderId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="add_time")
	private Date addTime;

	@Column(name="commis_amount")
	private Double commisAmount;

	@Column(name="commis_rates")
	private Double commisRates;

	@Column(name="company_name")
	private String companyName;

	@Column(name="contacts_address")
	private String contactsAddress;

	@Column(name="contacts_name")
	private String contactsName;

	@Column(name="contacts_phone")
	private String contactsPhone;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="finish_time")
	private Date finishTime;

	@Column(name="geval_type")
	private Integer gevalType;

	@Column(name="goods_amount")
	private Double goodsAmount;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ins_date")
	private Date insDate;

	@Column(name="member_addr_id")
	private Integer memberAddrId;

	@Column(name="member_id")
	private Integer memberId;

	@Column(name="member_truename")
	private String memberTruename;

	@Column(name="menber_phone")
	private String menberPhone;

	@Column(name="order_amount")
	private Double orderAmount;

	@Column(name="order_status")
	private Integer orderStatus;

	@Column(name="order_type")
	private Integer orderType;

	@Column(name="pay_code")
	private String payCode;

	@Column(name="pay_id")
	private Integer payId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="pay_time")
	private Date payTime;

	@Column(name="post_code")
	private String postCode;

	@Column(name="pre_pay")
	private String prePay;

	@Column(name="region_area_name")
	private String regionAreaName;

	@Column(name="region_city")
	private Integer regionCity;

	@Column(name="region_city_name")
	private String regionCityName;

	@Column(name="region_code")
	private Integer regionCode;

	@Column(name="region_prov")
	private Integer regionProv;

	@Column(name="region_prov_name")
	private String regionProvName;

	private String remark;

	@Column(name="store_amount")
	private Double storeAmount;

	@Column(name="store_id")
	private Integer storeId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="upd_date")
	private Date updDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="visit_time")
	private Date visitTime;

	@Column(name = "is_retail")
	private int isRetail;

	@Column(name = "retail_amount")
	private BigDecimal retailAmount;

	@Column(name = "retail_member_name")
	private String retailMemberName;

    @Column(name = "retail_shop_name")
    private String retailShopName;

	// optional=true：可选，表示此对象可以没有，可以为null；false表示必须存在
    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.MERGE }, optional = true)
    @JoinColumn(name="member_id", insertable = false, updatable = false)
    private WechatMember wechatMember;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "storeOrder")
	private Set<OrderGood> orderGood = new HashSet<OrderGood>(0);
	
	@OneToOne(mappedBy = "storeOrder")
	@JsonIgnore
    private StorePay storePay;
	
	
	@ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.MERGE }, optional = true)
    @JoinColumn(name="region_prov", insertable = false, updatable = false)
    private RegionInfo provinceName;
	 
	@ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.MERGE }, optional = true)
    @JoinColumn(name="region_city", insertable = false, updatable = false)
    private RegionInfo cityName;
	
	// optional=true：可选，表示此对象可以没有，可以为null；false表示必须存在
    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.MERGE }, optional = true)
    @JoinColumn(name="region_code", insertable = false, updatable = false)
    private RegionInfo areaName;
    
    @OneToOne(mappedBy = "storeOrder")
    private StoreOrderCoupon storeOrderCoupon;

	public StoreOrder() {
	}
	
	public StoreOrder(Integer orderId, Integer orderStatus) {
		super();
		this.orderId = orderId;
		this.orderStatus = orderStatus;
	}

	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Date getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Double getCommisAmount() {
		return this.commisAmount;
	}

	public void setCommisAmount(Double commisAmount) {
		this.commisAmount = commisAmount;
	}

	public Double getCommisRates() {
		return this.commisRates;
	}

	public void setCommisRates(Double commisRates) {
		this.commisRates = commisRates;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getContactsAddress() {
		return this.contactsAddress;
	}

	public void setContactsAddress(String contactsAddress) {
		this.contactsAddress = contactsAddress;
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

	public Date getFinishTime() {
		return this.finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	public Integer getGevalType() {
		return this.gevalType;
	}

	public void setGevalType(Integer gevalType) {
		this.gevalType = gevalType;
	}

	public Double getGoodsAmount() {
		return this.goodsAmount;
	}

	public void setGoodsAmount(Double goodsAmount) {
		this.goodsAmount = goodsAmount;
	}

	public Date getInsDate() {
		return this.insDate;
	}

	public void setInsDate(Date insDate) {
		this.insDate = insDate;
	}

	public Integer getMemberAddrId() {
		return this.memberAddrId;
	}

	public void setMemberAddrId(Integer memberAddrId) {
		this.memberAddrId = memberAddrId;
	}

	public Integer getMemberId() {
		return this.memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public String getMemberTruename() {
		return this.memberTruename;
	}

	public void setMemberTruename(String memberTruename) {
		this.memberTruename = memberTruename;
	}

	public String getMenberPhone() {
		return this.menberPhone;
	}

	public void setMenberPhone(String menberPhone) {
		this.menberPhone = menberPhone;
	}

	public Double getOrderAmount() {
		return this.orderAmount;
	}

	public void setOrderAmount(Double orderAmount) {
		this.orderAmount = orderAmount;
	}

	public Integer getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
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

	public Integer getPayId() {
		return this.payId;
	}

	public void setPayId(Integer payId) {
		this.payId = payId;
	}

	public Date getPayTime() {
		return this.payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public String getPostCode() {
		return this.postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getPrePay() {
		return this.prePay;
	}

	public void setPrePay(String prePay) {
		this.prePay = prePay;
	}

	public String getRegionAreaName() {
		return this.regionAreaName;
	}

	public void setRegionAreaName(String regionAreaName) {
		this.regionAreaName = regionAreaName;
	}

	public Integer getRegionCity() {
		return this.regionCity;
	}

	public void setRegionCity(Integer regionCity) {
		this.regionCity = regionCity;
	}

	public String getRegionCityName() {
		return this.regionCityName;
	}

	public void setRegionCityName(String regionCityName) {
		this.regionCityName = regionCityName;
	}

	public Integer getRegionCode() {
		return this.regionCode;
	}

	public void setRegionCode(Integer regionCode) {
		this.regionCode = regionCode;
	}

	public Integer getRegionProv() {
		return this.regionProv;
	}

	public void setRegionProv(Integer regionProv) {
		this.regionProv = regionProv;
	}

	public String getRegionProvName() {
		return this.regionProvName;
	}

	public void setRegionProvName(String regionProvName) {
		this.regionProvName = regionProvName;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Double getStoreAmount() {
		return this.storeAmount;
	}

	public void setStoreAmount(Double storeAmount) {
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

	public Date getVisitTime() {
		return this.visitTime;
	}

	public void setVisitTime(Date visitTime) {
		this.visitTime = visitTime;
	}

	public WechatMember getWechatMember() {
		return wechatMember;
	}

	public void setWechatMember(WechatMember wechatMember) {
		this.wechatMember = wechatMember;
	}

	public Set<OrderGood> getOrderGood() {
		return orderGood;
	}

	public void setOrderGood(Set<OrderGood> orderGood) {
		this.orderGood = orderGood;
	}

	public StorePay getStorePay() {
		return storePay;
	}

	public void setStorePay(StorePay storePay) {
		this.storePay = storePay;
	}

	public RegionInfo getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(RegionInfo provinceName) {
		this.provinceName = provinceName;
	}

	public RegionInfo getCityName() {
		return cityName;
	}

	public void setCityName(RegionInfo cityName) {
		this.cityName = cityName;
	}

	public RegionInfo getAreaName() {
		return areaName;
	}

	public void setAreaName(RegionInfo areaName) {
		this.areaName = areaName;
	}

	public StoreOrderCoupon getStoreOrderCoupon() {
		return storeOrderCoupon;
	}

	public void setStoreOrderCoupon(StoreOrderCoupon storeOrderCoupon) {
		this.storeOrderCoupon = storeOrderCoupon;
	}

	public int getIsRetail() {
		return isRetail;
	}

	public void setIsRetail(int isRetail) {
		this.isRetail = isRetail;
	}

	public BigDecimal getRetailAmount() {
		return retailAmount;
	}

	public void setRetailAmount(BigDecimal retailAmount) {
		this.retailAmount = retailAmount;
	}

	public String getRetailMemberName() {
		return retailMemberName;
	}

	public void setRetailMemberName(String retailMemberName) {
		this.retailMemberName = retailMemberName;
	}

    public String getRetailShopName() {
        return retailShopName;
    }

    public void setRetailShopName(String retailShopName) {
        this.retailShopName = retailShopName;
    }
}