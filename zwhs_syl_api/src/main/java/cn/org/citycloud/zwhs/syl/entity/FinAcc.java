package cn.org.citycloud.zwhs.syl.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * The persistent class for the fin_acc database table.
 * 
 */
@Entity
@Table(name="fin_acc")
@NamedQuery(name="FinAcc.findAll", query="SELECT f FROM FinAcc f")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class FinAcc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="acc_bal")
	private Double accBal;

	@Column(name="acc_income")
	private Double accIncome;

	@Column(name="acc_no")
	private Integer accNo;

	@Column(name="acc_pay")
	private Double accPay;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="upd_date")
	private Date updDate;
	
	public FinAcc() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getAccBal() {
		return this.accBal;
	}

	public void setAccBal(Double accBal) {
		this.accBal = accBal;
	}

	public Double getAccIncome() {
		return this.accIncome;
	}

	public void setAccIncome(Double accIncome) {
		this.accIncome = accIncome;
	}

	public Integer getAccNo() {
		return this.accNo;
	}

	public void setAccNo(Integer accNo) {
		this.accNo = accNo;
	}

	public Double getAccPay() {
		return this.accPay;
	}

	public void setAccPay(Double accPay) {
		this.accPay = accPay;
	}

	public Date getUpdDate() {
		return this.updDate;
	}

	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}

	

}