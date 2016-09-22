package cn.org.citycloud.zwhs.syl.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;


public class TopBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

    private String province;
    private String city;
    private BigInteger storenum;
    private BigInteger ordernum;
    private BigDecimal ordermoney;
    
      
	public TopBean(String province, String city, BigInteger storenum, BigInteger ordernum, BigDecimal ordermoney) {
		super();
		this.province = province;
		this.city = city;
		this.storenum = storenum;
		this.ordernum = ordernum;
		this.ordermoney = ordermoney;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public BigInteger getStorenum() {
		return storenum;
	}
	public void setStorenum(BigInteger storenum) {
		this.storenum = storenum;
	}
	public BigInteger getOrdernum() {
		return ordernum;
	}
	public void setOrdernum(BigInteger ordernum) {
		this.ordernum = ordernum;
	}
	public BigDecimal getOrdermoney() {
		return ordermoney;
	}
	public void setOrdermoney(BigDecimal ordermoney) {
		this.ordermoney = ordermoney;
	}
	
      
	
}
