package cn.org.citycloud.zwhs.syl.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * The persistent class for the service_info database table.
 * 
 */
@Entity
@Table(name="service_info")
@NamedQuery(name="ServiceInfo.findAll", query="SELECT s FROM ServiceInfo s")
public class ServiceInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="service_id")
	private int serviceId;

	@Column(name="business_end")
	private Time businessEnd;

	@Column(name="business_start")
	private Time businessStart;

	@Column(name="commis_rates")
	private Double commisRates;

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

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ins_date")
	private Date insDate;

	@Column(name="provider_id")
	private Integer providerId;

	@Column(name="provider_rates")
	private Double providerRates;

	@Column(name="remark")
	private String remark;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="service_addtime")
	private Date serviceAddtime;

	@Column(name="service_logo")
	private String serviceLogo;

	@Column(name="service_name")
	private String serviceName;

	@Column(name="service_pic1")
	private String servicePic1;

	@Column(name="service_pic2")
	private String servicePic2;

	@Column(name="service_pic3")
	private String servicePic3;

	@Column(name="service_pic4")
	private String servicePic4;

	@Column(name="service_pic5")
	private String servicePic5;

	@Column(name="service_price")
	private Double servicePrice;

	@Column(name="service_state")
	private Integer serviceState;

	@Column(name="service_time")
	private String serviceTime;

	@Column(name="service_verify")
	private Integer serviceVerify;

	@Column(name="store_rates")
	private Double storeRates;

	private Integer type;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="upd_date")
	private Date updDate;

	@ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.MERGE }, optional = true)
    @JoinColumn(name="provider_id", insertable = false, updatable = false)
    private ServiceProvider serviceProvider;
	
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "serviceInfo")
	private Set<ServiceCoverageArea> serviceCoverageArea = new HashSet<ServiceCoverageArea>();
	
	
	public ServiceInfo() {
	}

	public int getServiceId() {
		return this.serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public Time getBusinessEnd() {
		return this.businessEnd;
	}

	public void setBusinessEnd(Time businessEnd) {
		this.businessEnd = businessEnd;
	}

	public Time getBusinessStart() {
		return this.businessStart;
	}

	public void setBusinessStart(Time businessStart) {
		this.businessStart = businessStart;
	}

	public Double getCommisRates() {
		return this.commisRates;
	}

	public void setCommisRates(Double commisRates) {
		this.commisRates = commisRates;
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

	public Date getInsDate() {
		return this.insDate;
	}

	public void setInsDate(Date insDate) {
		this.insDate = insDate;
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

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getServiceAddtime() {
		return this.serviceAddtime;
	}

	public void setServiceAddtime(Date serviceAddtime) {
		this.serviceAddtime = serviceAddtime;
	}

	public String getServiceLogo() {
		return this.serviceLogo;
	}

	public void setServiceLogo(String serviceLogo) {
		this.serviceLogo = serviceLogo;
	}

	public String getServiceName() {
		return this.serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServicePic1() {
		return this.servicePic1;
	}

	public void setServicePic1(String servicePic1) {
		this.servicePic1 = servicePic1;
	}

	public String getServicePic2() {
		return this.servicePic2;
	}

	public void setServicePic2(String servicePic2) {
		this.servicePic2 = servicePic2;
	}

	public String getServicePic3() {
		return this.servicePic3;
	}

	public void setServicePic3(String servicePic3) {
		this.servicePic3 = servicePic3;
	}

	public String getServicePic4() {
		return this.servicePic4;
	}

	public void setServicePic4(String servicePic4) {
		this.servicePic4 = servicePic4;
	}

	public String getServicePic5() {
		return this.servicePic5;
	}

	public void setServicePic5(String servicePic5) {
		this.servicePic5 = servicePic5;
	}

	public Double getServicePrice() {
		return this.servicePrice;
	}

	public void setServicePrice(Double servicePrice) {
		this.servicePrice = servicePrice;
	}

	public Integer getServiceState() {
		return this.serviceState;
	}

	public void setServiceState(Integer serviceState) {
		this.serviceState = serviceState;
	}

	public String getServiceTime() {
		return this.serviceTime;
	}

	public void setServiceTime(String serviceTime) {
		this.serviceTime = serviceTime;
	}

	public Integer getServiceVerify() {
		return this.serviceVerify;
	}

	public void setServiceVerify(Integer serviceVerify) {
		this.serviceVerify = serviceVerify;
	}

	public Double getStoreRates() {
		return this.storeRates;
	}

	public void setStoreRates(Double storeRates) {
		this.storeRates = storeRates;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Date getUpdDate() {
		return this.updDate;
	}

	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}

	public ServiceProvider getServiceProvider() {
		return serviceProvider;
	}

	public void setServiceProvider(ServiceProvider serviceProvider) {
		this.serviceProvider = serviceProvider;
	}

	public Set<ServiceCoverageArea> getServiceCoverageArea() {
		return serviceCoverageArea;
	}

	public void setServiceCoverageArea(Set<ServiceCoverageArea> serviceCoverageArea) {
		this.serviceCoverageArea = serviceCoverageArea;
	}
	
	
}