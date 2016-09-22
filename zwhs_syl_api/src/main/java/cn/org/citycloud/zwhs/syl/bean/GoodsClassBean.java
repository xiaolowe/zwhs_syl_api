package cn.org.citycloud.zwhs.syl.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class GoodsClassBean {
	
	@NotEmpty
	private String gc_name;
	
	@NotNull
	private Integer gc_parent_id;
	
	@NotNull
	private Integer gc_sort;
	
	@NotEmpty
	private String gc_title;

	public String getGc_name() {
		return gc_name;
	}

	public void setGc_name(String gc_name) {
		this.gc_name = gc_name;
	}

	public Integer getGc_parent_id() {
		return gc_parent_id;
	}

	public void setGc_parent_id(Integer gc_parent_id) {
		this.gc_parent_id = gc_parent_id;
	}

	public Integer getGc_sort() {
		return gc_sort;
	}

	public void setGc_sort(Integer gc_sort) {
		this.gc_sort = gc_sort;
	}

	public String getGc_title() {
		return gc_title;
	}

	public void setGc_title(String gc_title) {
		this.gc_title = gc_title;
	}
	
	
}
