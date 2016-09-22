package cn.org.citycloud.zwhs.syl.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * The persistent class for the store database table.
 * 
 */
@Entity
@NamedQuery(name="Store.findAll", query="SELECT s FROM Store s")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Store implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="store_id")
	private Integer storeId;

	@Column(name="app_id")
	private String appId;

	@Column(name="app_secret")
	private String appSecret;

	@Column(name="bank_acc_name")
	private String bankAccName;

	@Column(name="bank_acc_number")
	private String bankAccNumber;

	@Column(name="bank_name")
	private String bankName;

	@Column(name="bank_owner")
	private String bankOwner;

	@Column(name="business_licence")
	private String businessLicence;

	@Column(name="commis_rates")
	private Double commisRates;

	@Column(name="company_address")
	private String companyAddress;

	@Column(name="company_fax")
	private String companyFax;

	@Column(name="company_name")
	private String companyName;

	@Column(name="company_postcode")
	private String companyPostcode;

	@Column(name="company_region")
	private String companyRegion;

	@Lob
	private String content;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_time")
	private Date createTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ins_date")
	private Date insDate;

	@Column(name="joinin_message")
	private String joininMessage;

	@Column(name="joinin_state")
	private String joininState;

	@Column(name="organization_code")
	private String organizationCode;

	@Column(name="owner_card_back")
	private String ownerCardBack;

	@Column(name="owner_card_front")
	private String ownerCardFront;

	@Column(name="region_area_name")
	private String regionAreaName;

	@Column(name="region_city")
	private String regionCity;

	@Column(name="region_city_name")
	private String regionCityName;

	@Column(name="region_prov")
	private String regionProv;

	@Column(name="region_prov_name")
	private String regionProvName;

	@Column(name="sg_id")
	private Integer sgId;

	@Column(name="store_alias_name")
	private String storeAliasName;

	@Column(name="store_image")
	private String storeImage;

	@Column(name="store_owner")
	private String storeOwner;

	@Column(name="store_owner_card")
	private String storeOwnerCard;

	@Column(name="store_state")
	private Integer storeState;

	@Column(name="tax_reg_cert")
	private String taxRegCert;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="upd_date")
	private Date updDate;

	@Column(name="user_phone")
	private String userPhone;

	@Column(name="wechar_ent_id")
	private String wecharEntId;

	@Column(name="wechat_ent_name")
	private String wechatEntName;

	@Column(name="wechat_id")
	private String wechatId;

	@Column(name="wechat_token")
	private String wechatToken;

	@Column(name="wechat_type")
	private Integer wechatType;

	@Column(name="wechat_url")
	private String wechatUrl;

	@Column(name="retail_code", length = 50)
	private String retailCode;

	@Column(name = "store_type")
	private int storeType;
	
	@ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.MERGE }, optional = true)
    @JoinColumn(name="region_prov", insertable = false, updatable = false)
    private RegionInfo provinceName;
	 
	@ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.MERGE }, optional = true)
    @JoinColumn(name="region_city", insertable = false, updatable = false)
    private RegionInfo cityName;
	
	// optional=true：可选，表示此对象可以没有，可以为null；false表示必须存在
    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.MERGE }, optional = true)
    @JoinColumn(name="company_region", insertable = false, updatable = false)
    private RegionInfo areaName;
    
    @OneToOne(mappedBy = "store")
    private StoreUser storeUser;
    
 // optional=true：可选，表示此对象可以没有，可以为null；false表示必须存在
    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.MERGE }, optional = true)
    @JoinColumn(name="sg_id", insertable = false, updatable = false)
    private StoreSg storeSg;

	public Store() {
	}
	
	public Store(String companyName, String companyRegion, 
			String regionCity, String regionProv, Integer storeState) {
		super();
		this.companyName = companyName;
		this.companyRegion = companyRegion;
		this.regionCity = regionCity;
		this.regionProv = regionProv;
		this.storeState = storeState;
	}
	

	public Store(String companyAddress, String companyName, String companyRegion,
			 String regionCity, String regionProv,
			Integer sgId, Integer storeState, Date updDate) {
		super();
		this.companyAddress = companyAddress;
		this.companyName = companyName;
		this.companyRegion = companyRegion;
		this.regionCity = regionCity;
		this.regionProv = regionProv;
		this.sgId = sgId;
		this.storeState = storeState;
		this.updDate = updDate;
	}

	public Integer getStoreId() {
		return this.storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public String getAppId() {
		return this.appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAppSecret() {
		return this.appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	public String getBankAccName() {
		return this.bankAccName;
	}

	public void setBankAccName(String bankAccName) {
		this.bankAccName = bankAccName;
	}

	public String getBankAccNumber() {
		return this.bankAccNumber;
	}

	public void setBankAccNumber(String bankAccNumber) {
		this.bankAccNumber = bankAccNumber;
	}

	public String getBankName() {
		return this.bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankOwner() {
		return this.bankOwner;
	}

	public void setBankOwner(String bankOwner) {
		this.bankOwner = bankOwner;
	}

	public String getBusinessLicence() {
		return this.businessLicence;
	}

	public void setBusinessLicence(String businessLicence) {
		this.businessLicence = businessLicence;
	}

	public Double getCommisRates() {
		return this.commisRates;
	}

	public void setCommisRates(Double commisRates) {
		this.commisRates = commisRates;
	}

	public String getCompanyAddress() {
		return this.companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getCompanyFax() {
		return this.companyFax;
	}

	public void setCompanyFax(String companyFax) {
		this.companyFax = companyFax;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyPostcode() {
		return this.companyPostcode;
	}

	public void setCompanyPostcode(String companyPostcode) {
		this.companyPostcode = companyPostcode;
	}

	public String getCompanyRegion() {
		return this.companyRegion;
	}

	public void setCompanyRegion(String companyRegion) {
		this.companyRegion = companyRegion;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getInsDate() {
		return this.insDate;
	}

	public void setInsDate(Date insDate) {
		this.insDate = insDate;
	}

	public String getJoininMessage() {
		return this.joininMessage;
	}

	public void setJoininMessage(String joininMessage) {
		this.joininMessage = joininMessage;
	}

	public String getJoininState() {
		return this.joininState;
	}

	public void setJoininState(String joininState) {
		this.joininState = joininState;
	}

	public String getOrganizationCode() {
		return this.organizationCode;
	}

	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}

	public String getOwnerCardBack() {
		return this.ownerCardBack;
	}

	public void setOwnerCardBack(String ownerCardBack) {
		this.ownerCardBack = ownerCardBack;
	}

	public String getOwnerCardFront() {
		return this.ownerCardFront;
	}

	public void setOwnerCardFront(String ownerCardFront) {
		this.ownerCardFront = ownerCardFront;
	}

	public String getRegionAreaName() {
		return this.regionAreaName;
	}

	public void setRegionAreaName(String regionAreaName) {
		this.regionAreaName = regionAreaName;
	}

	public String getRegionCity() {
		return this.regionCity;
	}

	public void setRegionCity(String regionCity) {
		this.regionCity = regionCity;
	}

	public String getRegionCityName() {
		return this.regionCityName;
	}

	public void setRegionCityName(String regionCityName) {
		this.regionCityName = regionCityName;
	}

	public String getRegionProv() {
		return this.regionProv;
	}

	public void setRegionProv(String regionProv) {
		this.regionProv = regionProv;
	}

	public String getRegionProvName() {
		return this.regionProvName;
	}

	public void setRegionProvName(String regionProvName) {
		this.regionProvName = regionProvName;
	}

	public Integer getSgId() {
		return this.sgId;
	}

	public void setSgId(Integer sgId) {
		this.sgId = sgId;
	}

	public String getStoreAliasName() {
		return this.storeAliasName;
	}

	public void setStoreAliasName(String storeAliasName) {
		this.storeAliasName = storeAliasName;
	}

	public String getStoreImage() {
		return this.storeImage;
	}

	public void setStoreImage(String storeImage) {
		this.storeImage = storeImage;
	}

	public String getStoreOwner() {
		return this.storeOwner;
	}

	public void setStoreOwner(String storeOwner) {
		this.storeOwner = storeOwner;
	}

	public String getStoreOwnerCard() {
		return this.storeOwnerCard;
	}

	public void setStoreOwnerCard(String storeOwnerCard) {
		this.storeOwnerCard = storeOwnerCard;
	}

	public Integer getStoreState() {
		return this.storeState;
	}

	public void setStoreState(Integer storeState) {
		this.storeState = storeState;
	}

	public String getTaxRegCert() {
		return this.taxRegCert;
	}

	public void setTaxRegCert(String taxRegCert) {
		this.taxRegCert = taxRegCert;
	}

	public Date getUpdDate() {
		return this.updDate;
	}

	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}

	public String getUserPhone() {
		return this.userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getWecharEntId() {
		return this.wecharEntId;
	}

	public void setWecharEntId(String wecharEntId) {
		this.wecharEntId = wecharEntId;
	}

	public String getWechatEntName() {
		return this.wechatEntName;
	}

	public void setWechatEntName(String wechatEntName) {
		this.wechatEntName = wechatEntName;
	}

	public String getWechatId() {
		return this.wechatId;
	}

	public void setWechatId(String wechatId) {
		this.wechatId = wechatId;
	}

	public String getWechatToken() {
		return this.wechatToken;
	}

	public void setWechatToken(String wechatToken) {
		this.wechatToken = wechatToken;
	}

	public Integer getWechatType() {
		return this.wechatType;
	}

	public void setWechatType(Integer wechatType) {
		this.wechatType = wechatType;
	}

	public String getWechatUrl() {
		return this.wechatUrl;
	}

	public void setWechatUrl(String wechatUrl) {
		this.wechatUrl = wechatUrl;
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

	public StoreUser getStoreUser() {
		return storeUser;
	}

	public void setStoreUser(StoreUser storeUser) {
		this.storeUser = storeUser;
	}

	public StoreSg getStoreSg() {
		return storeSg;
	}

	public void setStoreSg(StoreSg storeSg) {
		this.storeSg = storeSg;
	}

	public String getRetailCode() {
		return retailCode;
	}

	public void setRetailCode(String retailCode) {
		this.retailCode = retailCode;
	}

	public int getStoreType() {
		return storeType;
	}

	public void setStoreType(int storeType) {
		this.storeType = storeType;
	}
}