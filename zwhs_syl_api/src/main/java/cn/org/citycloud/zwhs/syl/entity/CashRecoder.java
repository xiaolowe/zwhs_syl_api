package cn.org.citycloud.zwhs.syl.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the cash_recoder database table.
 * 
 */
@Entity
@Table(name="cash_recoder")
@NamedQuery(name="CashRecoder.findAll", query="SELECT c FROM CashRecoder c")
public class CashRecoder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cash_no")
	private Integer cashNo;

	@Column(name="acc_surplus")
	private Double accSurplus;

	@Column(name="apply_money")
	private Double applyMoney;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="apply_time")
	private Date applyTime;

	@Column(name="apply_type")
	private Integer applyType;

	@Column(name="store_user_id")
	private Integer applyUserId;
	
	@Column(name="provider_user_id")
	private Integer providerUserId;

	@Column(name="apply_user_name")
	private String applyUserName;

	@Column(name="bank_acc_name")
	private String bankAccName;

	@Column(name="bank_acc_number")
	private String bankAccNumber;

	@Column(name="bank_name")
	private String bankName;

	@Column(name="company_name")
	private String companyName;

	@Column(name="confirm_stat")
	private Integer confirmStat;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="confirm_time")
	private Date confirmTime;

	@Column(name="confirm_user_id")
	private Integer confirmUserId;

	@Column(name="confirm_user_name")
	private String confirmUserName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ins_date")
	private Date insDate;

	@Column(name="paying_certificate")
	private String payingCertificate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="paying_time")
	private Date payingTime;

	@Column(name="paying_user_name")
	private String payingUserName;

	@Column(name="paying_user_no")
	private Integer payingUserNo;

	@Column(name="store_id")
	private Integer storeId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="upd_date")
	private Date updDate;
	
	@Column(name="bank_owner")
	private String bankOwner;
	
	@Column(name="acc_type")
	private Integer accType;
	
	@ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.MERGE }, optional = true)
    @JoinColumn(name="store_user_id", insertable = false, updatable = false)
    private StoreUser storeUser;
	
	public CashRecoder() {
	}
	

	public CashRecoder(Integer cashNo, String companyName, Integer confirmStat) {
		super();
		this.cashNo = cashNo;
		this.companyName = companyName;
		this.confirmStat = confirmStat;
	}


	public Integer getCashNo() {
		return this.cashNo;
	}

	public void setCashNo(Integer cashNo) {
		this.cashNo = cashNo;
	}

	public Double getAccSurplus() {
		return this.accSurplus;
	}

	public void setAccSurplus(Double accSurplus) {
		this.accSurplus = accSurplus;
	}

	public Double getApplyMoney() {
		return this.applyMoney;
	}

	public void setApplyMoney(Double applyMoney) {
		this.applyMoney = applyMoney;
	}

	public Date getApplyTime() {
		return this.applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	public Integer getApplyType() {
		return this.applyType;
	}

	public void setApplyType(Integer applyType) {
		this.applyType = applyType;
	}

	public Integer getApplyUserId() {
		return this.applyUserId;
	}

	public void setApplyUserId(Integer applyUserId) {
		this.applyUserId = applyUserId;
	}

	public String getApplyUserName() {
		return this.applyUserName;
	}

	public void setApplyUserName(String applyUserName) {
		this.applyUserName = applyUserName;
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

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Integer getConfirmStat() {
		return this.confirmStat;
	}

	public void setConfirmStat(Integer confirmStat) {
		this.confirmStat = confirmStat;
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

	public Date getInsDate() {
		return this.insDate;
	}

	public void setInsDate(Date insDate) {
		this.insDate = insDate;
	}

	public String getPayingCertificate() {
		return this.payingCertificate;
	}

	public void setPayingCertificate(String payingCertificate) {
		this.payingCertificate = payingCertificate;
	}

	public Date getPayingTime() {
		return this.payingTime;
	}

	public void setPayingTime(Date payingTime) {
		this.payingTime = payingTime;
	}

	public String getPayingUserName() {
		return this.payingUserName;
	}

	public void setPayingUserName(String payingUserName) {
		this.payingUserName = payingUserName;
	}

	public Integer getPayingUserNo() {
		return this.payingUserNo;
	}

	public void setPayingUserNo(Integer payingUserNo) {
		this.payingUserNo = payingUserNo;
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


	public String getBankOwner() {
		return bankOwner;
	}


	public void setBankOwner(String bankOwner) {
		this.bankOwner = bankOwner;
	}


	public StoreUser getStoreUser() {
		return storeUser;
	}


	public void setStoreUser(StoreUser storeUser) {
		this.storeUser = storeUser;
	}


	public Integer getAccType() {
		return accType;
	}


	public void setAccType(Integer accType) {
		this.accType = accType;
	}


	public Integer getProviderUserId() {
		return providerUserId;
	}


	public void setProviderUserId(Integer providerUserId) {
		this.providerUserId = providerUserId;
	}
	
	
}