package cn.org.citycloud.zwhs.syl.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the store_sg database table.
 * 
 */
@Entity
@Table(name="store_sg")
@NamedQuery(name="StoreSg.findAll", query="SELECT s FROM StoreSg s")
public class StoreSg implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="sg_id")
	private int sgId;

	@Column(name="commis_rates")
	private Double commisRates;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ins_date")
	private Date insDate;

	@Column(name="sg_name")
	private String sgName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="upd_date")
	private Date updDate;

	public StoreSg() {
	}

	public int getSgId() {
		return this.sgId;
	}

	public void setSgId(int sgId) {
		this.sgId = sgId;
	}

	public Double getCommisRates() {
		return this.commisRates;
	}

	public void setCommisRates(Double commisRates) {
		this.commisRates = commisRates;
	}

	public Date getInsDate() {
		return this.insDate;
	}

	public void setInsDate(Date insDate) {
		this.insDate = insDate;
	}

	public String getSgName() {
		return this.sgName;
	}

	public void setSgName(String sgName) {
		this.sgName = sgName;
	}

	public Date getUpdDate() {
		return this.updDate;
	}

	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}

}