package cn.org.citycloud.zwhs.syl.bean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class CashRecoderRemarkBean {
	
	@NotNull
	private Integer cash_no;
	
	@NotEmpty
	private String remark;

	public Integer getCash_no() {
		return cash_no;
	}

	public void setCash_no(Integer cash_no) {
		this.cash_no = cash_no;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
