package cn.org.citycloud.zwhs.syl.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;


/**
 * The persistent class for the wechat_member_addr database table.
 * 
 */
@Entity
@Table(name="wechat_member_addr")
@NamedQuery(name="WechatMemberAddr.findAll", query="SELECT w FROM WechatMemberAddr w")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class WechatMemberAddr implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="member_addr_id")
	private Integer memberAddrId;

	@Column(name="contacts_address")
	private String contactsAddress;

	@Column(name="contacts_name")
	private String contactsName;

	@Column(name="contacts_phone")
	private String contactsPhone;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ins_date")
	private Date insDate;

//	@Column(name="member_id")
//	private Integer memberId;

	@Column(name="post_code")
	private String postCode;


	@Column(name="region_code")
	private Integer regionCode;

	
    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.MERGE }, optional = true)
    @JoinColumn(name="member_id", insertable = false, updatable = false)
    @JsonIgnore
    private WechatMember wechatMember;

	public WechatMemberAddr() {
	}

	public Integer getMemberAddrId() {
		return this.memberAddrId;
	}

	public void setMemberAddrId(Integer memberAddrId) {
		this.memberAddrId = memberAddrId;
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

	public Date getInsDate() {
		return this.insDate;
	}

	public void setInsDate(Date insDate) {
		this.insDate = insDate;
	}

	public String getPostCode() {
		return this.postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}


	public Integer getRegionCode() {
		return this.regionCode;
	}

	public void setRegionCode(Integer regionCode) {
		this.regionCode = regionCode;
	}


	public WechatMember getWechatMember() {
		return wechatMember;
	}

	public void setWechatMember(WechatMember wechatMember) {
		this.wechatMember = wechatMember;
	}
	
}