package cn.org.citycloud.zwhs.syl.bean;


public class ServiceStoreSearchBean {
	
	private Integer pageNo = 1;
	
	private Integer pageSize = 10;
	
	private String company_name;
	
	private Integer service_state;
	
	private Integer service_verify;


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


	public String getCompany_name() {
		return company_name;
	}


	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}


	public Integer getService_state() {
		return service_state;
	}


	public void setService_state(Integer service_state) {
		this.service_state = service_state;
	}


	public Integer getService_verify() {
		return service_verify;
	}


	public void setService_verify(Integer service_verify) {
		this.service_verify = service_verify;
	}

	

}
