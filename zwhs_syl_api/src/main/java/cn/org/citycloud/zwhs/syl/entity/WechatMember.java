package cn.org.citycloud.zwhs.syl.entity;

import java.io.Serializable;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * The persistent class for the wechat_member database table.
 * 
 */
@Entity
@Table(name="wechat_member")
@NamedQuery(name="WechatMember.findAll", query="SELECT w FROM WechatMember w")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class WechatMember implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="member_id")
	private Integer memberId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ins_date")
	private Date insDate;

	@Column(name="member_avatar")
	private String memberAvatar;

	@Column(name="member_email")
	private String memberEmail;

	@Column(name="member_login_ip")
	private String memberLoginIp;

	@Column(name="member_login_num")
	private Integer memberLoginNum;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="member_login_time")
	private Date memberLoginTime;

	@Column(name="member_old_login_ip")
	private String memberOldLoginIp;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="member_old_login_time")
	private Date memberOldLoginTime;

	@Column(name="member_phone")
	private String memberPhone;

	@Column(name="member_pwd")
	private String memberPwd;

	@Column(name="member_sex")
	private Integer memberSex;

	@Column(name="member_state")
	private Integer memberState;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="member_time")
	private Date memberTime;

	@Column(name="member_truename")
	private String memberTruename;

	@Column(name="open_id")
	private String openId;

	@Column(name="union_id")
	private String unionId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="upd_date")
	private Date updDate;

	@Column(name="wechat_aliasname")
	private String wechatAliasname;

	@Column(name="wechat_no")
	private String wechatNo;
	
	@Column(name="region_prov_name")
	private String regionProvName;
	
	@Column(name="region_city_name")
	private String regionCityName;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "wechatMember")
	private Set<WechatMemberAddr> wechatMemberAddrs = new HashSet<WechatMemberAddr>(0);
	
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "wechatMember")
//	private Set<StoreOrder> storeOrder = new HashSet<StoreOrder>(0);
	

	public Set<WechatMemberAddr> getWechatMemberAddrs() {
		return wechatMemberAddrs;
	}

	public void setWechatMemberAddrs(Set<WechatMemberAddr> wechatMemberAddrs) {
		this.wechatMemberAddrs = wechatMemberAddrs;
	}

	public WechatMember() {
	}
	
	public WechatMember(String wechatAliasname) {
		super();
		this.wechatAliasname = wechatAliasname;
	}
	
	public Integer getMemberId() {
		return this.memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
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

	public String getMemberLoginIp() {
		return this.memberLoginIp;
	}

	public void setMemberLoginIp(String memberLoginIp) {
		this.memberLoginIp = memberLoginIp;
	}

	public Integer getMemberLoginNum() {
		return this.memberLoginNum;
	}

	public void setMemberLoginNum(Integer memberLoginNum) {
		this.memberLoginNum = memberLoginNum;
	}

	public Date getMemberLoginTime() {
		return this.memberLoginTime;
	}

	public void setMemberLoginTime(Date memberLoginTime) {
		this.memberLoginTime = memberLoginTime;
	}

	public String getMemberOldLoginIp() {
		return this.memberOldLoginIp;
	}

	public void setMemberOldLoginIp(String memberOldLoginIp) {
		this.memberOldLoginIp = memberOldLoginIp;
	}

	public Date getMemberOldLoginTime() {
		return this.memberOldLoginTime;
	}

	public void setMemberOldLoginTime(Date memberOldLoginTime) {
		this.memberOldLoginTime = memberOldLoginTime;
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

	public Integer getMemberSex() {
		return this.memberSex;
	}

	public void setMemberSex(Integer memberSex) {
		this.memberSex = memberSex;
	}

	public Integer getMemberState() {
		return this.memberState;
	}

	public void setMemberState(Integer memberState) {
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

//	public Set<StoreOrder> getStoreOrder() {
//		return storeOrder;
//	}
//
//	public void setStoreOrder(Set<StoreOrder> storeOrder) {
//		this.storeOrder = storeOrder;
//	}

	public String getRegionProvName() {
		return regionProvName;
	}

	public void setRegionProvName(String regionProvName) {
		this.regionProvName = regionProvName;
	}

	public String getRegionCityName() {
		return regionCityName;
	}

	public void setRegionCityName(String regionCityName) {
		this.regionCityName = regionCityName;
	}

}