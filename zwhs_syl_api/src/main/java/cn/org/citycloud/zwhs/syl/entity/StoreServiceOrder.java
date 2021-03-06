package cn.org.citycloud.zwhs.syl.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;


/**
 * The persistent class for the store_service_order database table.
 * 
 */
@Entity
@Table(name="store_service_order")
@NamedQuery(name="StoreServiceOrder.findAll", query="SELECT s FROM StoreServiceOrder s")
public class StoreServiceOrder implements Serializable {
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

	@Column(name="pay_sn")
	private BigInteger paySn;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="pay_time")
	private Date payTime;

	@Column(name="post_code")
	private String postCode;

	@Column(name="pre_pay")
	private String prePay;

	@Column(name="provider_id")
	private Integer providerId;

	@Column(name="provider_rates")
	private Double providerRates;

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

	@Column(name="service_id")
	private Integer serviceId;

	@Column(name="service_num")
	private Integer serviceNum;

	@Column(name="service_price")
	private Double servicePrice;

	@Column(name="service_type")
	private Integer serviceType;
	
	@Column(name="provider_amount")
	private Double providerAmount;

	@Column(name="store_amount")
	private Double storeAmount;

	@Column(name="store_id")
	private Integer storeId;

	@Column(name="store_rates")
	private Double storeRates;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="upd_date")
	private Date updDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="visit_time")
	private Date visitTime;
	
	@ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.MERGE }, optional = true)
    @JoinColumn(name="service_id", insertable = false, updatable = false)
    private ServiceInfo serviceInfo;
	

	public StoreServiceOrder(Integer orderId, String memberTruename, Integer orderStatus,
			Integer serviceType) {
		super();
		this.orderId = orderId;
		this.memberTruename = memberTruename;
		this.orderStatus = orderStatus;
		this.serviceType = serviceType;
	}

	public StoreServiceOrder() {
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

	public BigInteger getPaySn() {
		return this.paySn;
	}

	public void setPaySn(BigInteger paySn) {
		this.paySn = paySn;
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

	public Integer getProviderId() {
		return this.providerId;
	}

	public void setProviderId(Integer providerId) {
		this.providerId = providerId;
	}

	public Double getProviderRates() {
		return this.providerRates;
	}

	public void setProviderRates(Double providerRates) {
		this.providerRates = providerRates;
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

	public Integer getServiceId() {
		return this.serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	public Integer getServiceNum() {
		return this.serviceNum;
	}

	public void setServiceNum(Integer serviceNum) {
		this.serviceNum = serviceNum;
	}

	public Double getServicePrice() {
		return this.servicePrice;
	}

	public void setServicePrice(Double servicePrice) {
		this.servicePrice = servicePrice;
	}

	public Integer getServiceType() {
		return this.serviceType;
	}

	public void setServiceType(Integer serviceType) {
		this.serviceType = serviceType;
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

	public Double getStoreRates() {
		return this.storeRates;
	}

	public void setStoreRates(Double storeRates) {
		this.storeRates = storeRates;
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

	public ServiceInfo getServiceInfo() {
		return serviceInfo;
	}

	public void setServiceInfo(ServiceInfo serviceInfo) {
		this.serviceInfo = serviceInfo;
	}

	public Double getProviderAmount() {
		return providerAmount;
	}

	public void setProviderAmount(Double providerAmount) {
		this.providerAmount = providerAmount;
	}

	
	
	

}