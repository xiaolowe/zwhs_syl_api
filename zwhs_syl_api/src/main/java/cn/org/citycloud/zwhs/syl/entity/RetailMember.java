package cn.org.citycloud.zwhs.syl.entity;

import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the retail_member database table.
 * 
 */
@Entity
@Table(name="retail_member")
@NamedQuery(name="RetailMember.findAll", query="SELECT r FROM RetailMember r")
public class RetailMember implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="account_bank")
	private String accountBank;

	@Column(name="account_owner")
	private String accountOwner;

	@Column(name="bank_name")
	private String bankName;

	@Column(name="card_no")
	private String cardNo;

	@Column(name="card_owner")
	private String cardOwner;

	@Column(name="identity_image")
	private String identityImage;

	@Column(name="identity_no")
	private String identityNo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ins_date")
	private Date insDate;

	@Column(name="member_avatar")
	private String memberAvatar;

	@Column(name="member_email")
	private String memberEmail;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="member_id")
	private int memberId;

	@Column(name="member_login_num")
	private int memberLoginNum;

	@Column(name="member_phone")
	private String memberPhone;

	@Column(name="member_pwd")
	private String memberPwd;

	@Column(name="member_region")
	private int memberRegion;

	@Column(name="member_sex")
	private byte memberSex;

	@Column(name="member_state")
	private int memberState;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="member_time")
	private Date memberTime;

	@Column(name="member_truename")
	private String memberTruename;

	@Column(name="open_id")
	private String openId;

	@Column(name="region_area_name")
	private String regionAreaName;

	@Column(name="region_city")
	private int regionCity;

	@Column(name="region_city_name")
	private String regionCityName;

	@Column(name="region_prov")
	private int regionProv;

	@Column(name="region_prov_name")
	private String regionProvName;

	@OneToOne
	@JoinColumn(name = "store_id")
	private Store store;

	@Column(name="union_id")
	private String unionId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="upd_date")
	private Date updDate;

	@Column(name="wechat_aliasname")
	private String wechatAliasname;

	@Column(name="wechat_no")
	private String wechatNo;

	public RetailMember() {
	}

	public String getAccountBank() {
		return this.accountBank;
	}

	public void setAccountBank(String accountBank) {
		this.accountBank = accountBank;
	}

	public String getAccountOwner() {
		return this.accountOwner;
	}

	public void setAccountOwner(String accountOwner) {
		this.accountOwner = accountOwner;
	}

	public String getBankName() {
		return this.bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getCardNo() {
		return this.cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getCardOwner() {
		return this.cardOwner;
	}

	public void setCardOwner(String cardOwner) {
		this.cardOwner = cardOwner;
	}

	public String getIdentityImage() {
		return this.identityImage;
	}

	public void setIdentityImage(String identityImage) {
		this.identityImage = identityImage;
	}

	public String getIdentityNo() {
		return this.identityNo;
	}

	public void setIdentityNo(String identityNo) {
		this.identityNo = identityNo;
	}

	public Date getInsDate() {
		return this.insDate;
	}

	public void setInsDate(Date insDate) {
		this.insDate = insDate;
	}

	public String getMemberAvatar() {
		return this.memberAvatar;
	}

	public void setMemberAvatar(String memberAvatar) {
		this.memberAvatar = memberAvatar;
	}

	public String getMemberEmail() {
		return this.memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public int getMemberId() {
		return this.memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public int getMemberLoginNum() {
		return this.memberLoginNum;
	}

	public void setMemberLoginNum(int memberLoginNum) {
		this.memberLoginNum = memberLoginNum;
	}

	public String getMemberPhone() {
		return this.memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getMemberPwd() {
		return this.memberPwd;
	}

	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}

	public int getMemberRegion() {
		return this.memberRegion;
	}

	public void setMemberRegion(int memberRegion) {
		this.memberRegion = memberRegion;
	}

	public byte getMemberSex() {
		return this.memberSex;
	}

	public void setMemberSex(byte memberSex) {
		this.memberSex = memberSex;
	}

	public int getMemberState() {
		return this.memberState;
	}

	public void setMemberState(int memberState) {
		this.memberState = memberState;
	}

	public Date getMemberTime() {
		return this.memberTime;
	}

	public void setMemberTime(Date memberTime) {
		this.memberTime = memberTime;
	}

	public String getMemberTruename() {
		return this.memberTruename;
	}

	public void setMemberTruename(String memberTruename) {
		this.memberTruename = memberTruename;
	}

	public String getOpenId() {
		return this.openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getRegionAreaName() {
		return this.regionAreaName;
	}

	public void setRegionAreaName(String regionAreaName) {
		this.regionAreaName = regionAreaName;
	}

	public int getRegionCity() {
		return this.regionCity;
	}

	public void setRegionCity(int regionCity) {
		this.regionCity = regionCity;
	}

	public String getRegionCityName() {
		return this.regionCityName;
	}

	public void setRegionCityName(String regionCityName) {
		this.regionCityName = regionCityName;
	}

	public int getRegionProv() {
		return this.regionProv;
	}

	public void setRegionProv(int regionProv) {
		this.regionProv = regionProv;
	}

	public String getRegionProvName() {
		return this.regionProvName;
	}

	public void setRegionProvName(String regionProvName) {
		this.regionProvName = regionProvName;
	}

	public String getUnionId() {
		return this.unionId;
	}

	public void setUnionId(String unionId) {
		this.unionId = unionId;
	}

	public Date getUpdDate() {
		return this.updDate;
	}

	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}

	public String getWechatAliasname() {
		return this.wechatAliasname;
	}

	public void setWechatAliasname(String wechatAliasname) {
		this.wechatAliasname = wechatAliasname;
	}

	public String getWechatNo() {
		return this.wechatNo;
	}

	public void setWechatNo(String wechatNo) {
		this.wechatNo = wechatNo;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}
}