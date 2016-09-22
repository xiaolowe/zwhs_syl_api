package cn.org.citycloud.zwhs.syl.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;


/**
 * The persistent class for the role_info database table.
 * 
 */
@Entity
@Table(name="role_info")
@NamedQuery(name="RoleInfo.findAll", query="SELECT r FROM RoleInfo r")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class RoleInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="role_id")
	private Integer roleId;

	@Column(name="order_flag")
	@JsonIgnore
	private Integer orderFlag;

	@Column(name="remark")
	@JsonIgnore
	private String remark;

	@Column(name="role_name")
	private String roleName;

	@Column(name="status")
	private String status;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonIgnore
	@Column(name="upd_date")
	private Date updDate;

	public RoleInfo() {
	}

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getOrderFlag() {
		return this.orderFlag;
	}

	public void setOrderFlag(Integer orderFlag) {
		this.orderFlag = orderFlag;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getUpdDate() {
		return this.updDate;
	}

	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}

}