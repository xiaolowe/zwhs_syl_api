package cn.org.citycloud.zwhs.syl.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * The persistent class for the region_info database table.
 * 
 */
@Entity
@Table(name="region_info")
@NamedQuery(name="RegionInfo.findAll", query="SELECT r FROM RegionInfo r")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class RegionInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="region_code")
	private Integer regionCode;

	@Column(name="region_level")
	private Integer regionLevel;

	@Column(name="region_name")
	private String regionName;
	
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "areaName")
//	@JsonIgnore
//	private Set<Store> store = new HashSet<Store>(0);
	
	public RegionInfo() {
	}

	public Integer getRegionCode() {
		return this.regionCode;
	}

	public void setRegionCode(Integer regionCode) {
		this.regionCode = regionCode;
	}

	public Integer getRegionLevel() {
		return this.regionLevel;
	}

	public void setRegionLevel(Integer regionLevel) {
		this.regionLevel = regionLevel;
	}

	public String getRegionName() {
		return this.regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	
//	public Set<Store> getStore() {
//		return store;
//	}
//
//	public void setStore(Set<Store> store) {
//		this.store = store;
//	}
	

}