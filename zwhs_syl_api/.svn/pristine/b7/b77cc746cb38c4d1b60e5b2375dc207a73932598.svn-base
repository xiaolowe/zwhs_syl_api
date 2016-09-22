package cn.org.citycloud.zwhs.syl.bean;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;


public class StoreSgBean {
	
	@NotEmpty
	private String sg_name;
	
	@NotNull
	@Min(1)
	@Max(99)
	private Double commis_rates;

	public String getSg_name() {
		return sg_name;
	}

	public void setSg_name(String sg_name) {
		this.sg_name = sg_name;
	}

	public Double getCommis_rates() {
		return commis_rates;
	}

	public void setCommis_rates(Double commis_rates) {
		this.commis_rates = commis_rates;
	}
	
	

}
