package cn.org.citycloud.zwhs.syl.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the service_outlets database table.
 * 
 */
@Entity
@Table(name="service_outlets")
@NamedQuery(name="ServiceOutlet.findAll", query="SELECT s FROM ServiceOutlet s")
public class ServiceOutlet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="outlets_id")
	private int outletsId;

	private String address;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ins_date")
	private Date insDate;

	private String latitude;

	private String longitude;

	@Column(name="outlets_name")
	private String outletsName;

	private String phone;

	@Column(name="service_id")
	private int serviceId;

	private int status;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="upd_date")
	private Date updDate;

	public ServiceOutlet() {
	}

	public int getOutletsId() {
		return this.outletsId;
	}

	public void setOutletsId(int outletsId) {
		this.outletsId = outletsId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getInsDate() {
		return this.insDate;
	}

	public void setInsDate(Date insDate) {
		this.insDate = insDate;
	}

	public String getLatitude() {
		return this.latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return this.longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getOutletsName() {
		return this.outletsName;
	}

	public void setOutletsName(String outletsName) {
		this.outletsName = outletsName;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getServiceId() {
		return this.serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getUpdDate() {
		return this.updDate;
	}

	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}

}