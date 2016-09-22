package cn.org.citycloud.zwhs.syl.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

/**
 * The persistent class for the cash_recoder_remark database table.
 */
@Entity
@Table(name="cash_recoder_remark")
@NamedQuery(name="CashRecoderRemark.findAll", query="SELECT c FROM CashRecoderRemark c")
public class CashRecoderRemark implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name="cash_no")
	private Integer cashNo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ins_date")
	private Date insDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="pub_time")
	private Date pubTime;

	private String remark;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="upd_date")
	private Date updDate;

	@Column(name="user_id")
	private Integer userId;

	@Column(name="user_name")
	private String userName;
	
	@ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.MERGE }, optional = true)
    @JoinColumn(name="cash_no", insertable = false, updatable = false)
	@JsonIgnore
	private CashRecoder cashRecoder;

	public CashRecoderRemark() {
	}

	
	public CashRecoderRemark(Integer cashNo, Date insDate, Date pubTime, String remark, String userName) {
		super();
		this.cashNo = cashNo;
		this.insDate = insDate;
		this.pubTime = pubTime;
		this.remark = remark;
		this.userName = userName;
	}



	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCashNo() {
		return this.cashNo;
	}

	public void setCashNo(Integer cashNo) {
		this.cashNo = cashNo;
	}

	public Date getInsDate() {
		return this.insDate;
	}

	public void setInsDate(Date insDate) {
		this.insDate = insDate;
	}

	public Date getPubTime() {
		return this.pubTime;
	}

	public void setPubTime(Date pubTime) {
		this.pubTime = pubTime;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getUpdDate() {
		return this.updDate;
	}

	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public CashRecoder getCashRecoder() {
		return cashRecoder;
	}

	public void setCashRecoder(CashRecoder cashRecoder) {
		this.cashRecoder = cashRecoder;
	}
	

}