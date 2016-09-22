package cn.org.citycloud.zwhs.syl.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class BrandBean {
	
	
	@NotEmpty
	private String brand_name;
	
	@NotEmpty
	private String contacts_name;
	
	@NotNull
	private Integer goods_source;
	
	@NotEmpty
	private String brand_pic;



	public String getBrand_name() {
		return brand_name;
	}

	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}

	public String getContacts_name() {
		return contacts_name;
	}

	public void setContacts_name(String contacts_name) {
		this.contacts_name = contacts_name;
	}

	public Integer getGoods_source() {
		return goods_source;
	}

	public void setGoods_source(Integer goods_source) {
		this.goods_source = goods_source;
	}

	public String getBrand_pic() {
		return brand_pic;
	}

	public void setBrand_pic(String brand_pic) {
		this.brand_pic = brand_pic;
	}
	

}
