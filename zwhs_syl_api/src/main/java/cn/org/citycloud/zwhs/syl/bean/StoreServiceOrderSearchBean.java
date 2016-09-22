package cn.org.citycloud.zwhs.syl.bean;


public class StoreServiceOrderSearchBean {
	
	private Integer pageNo = 1;
	
	private Integer pageSize = 10;
	
	private Integer order_id;
	
	private String service_name;
	
	private String member_truename;
	
	private Integer service_type;
	
	private Integer order_status;
	

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}

	public String getService_name() {
		return service_name;
	}

	public void setService_name(String service_name) {
		this.service_name = service_name;
	}

	public String getMember_truename() {
		return member_truename;
	}

	public void setMember_truename(String member_truename) {
		this.member_truename = member_truename;
	}

	public Integer getService_type() {
		return service_type;
	}

	public void setService_type(Integer service_type) {
		this.service_type = service_type;
	}

	public Integer getOrder_status() {
		return order_status;
	}

	public void setOrder_status(Integer order_status) {
		this.order_status = order_status;
	}
	

	

}
