package cn.org.citycloud.zwhs.syl.bean;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

/**
 * desc the file.
 *
 * @author demon
 * @Date 2016/7/26 16:42
 */
public class RetailMemberBean {
    @ApiModelProperty(value = "银行卡", required = true)
    @NotBlank(message = "银行卡不能为空")
    private String cardNo;

    @ApiModelProperty(value = "开户人", required = true)
    @NotBlank(message = "开户人不能为空")
    private String accountOwner;

    @ApiModelProperty(value = "开户行", required = true)
    @NotBlank(message = "开户行不能为空")
    private String accountBank;

    @ApiModelProperty(value = "手机号", required = true)
    @NotBlank(message="联系电话不能为空")
    @Pattern(regexp = "0?(13|14|15|18)[0-9]{9}", message = "联系电话格式不正确")
    private String memberPhone;

    @ApiModelProperty(value = "省Id", required = true)
    @Min(1)
    private int regionProv;

    @ApiModelProperty(value = "市Id", required = true)
    @Min(1)
    private int regionCity;

    @ApiModelProperty(value = "省", required = true)
    private String regionProvName;

    @ApiModelProperty(value = "市", required = true)
    private String regionCityName;

    @ApiModelProperty(value = "身份证", required = true)
    @NotBlank(message="身份证不能为空")
    @Pattern(regexp = "\\d{17}[\\d|x]|\\d{15}", message = "身份证格式不正确")
    private String identityNo;

    @ApiModelProperty(value = "身份证图片", required = true)
    @NotBlank(message = "身份证图片不能为空")
    private String identityImage;

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getAccountOwner() {
        return accountOwner;
    }

    public void setAccountOwner(String accountOwner) {
        this.accountOwner = accountOwner;
    }

    public String getAccountBank() {
        return accountBank;
    }

    public void setAccountBank(String accountBank) {
        this.accountBank = accountBank;
    }

    public String getMemberPhone() {
        return memberPhone;
    }

    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }

    public int getRegionProv() {
        return regionProv;
    }

    public void setRegionProv(int regionProv) {
        this.regionProv = regionProv;
    }

    public int getRegionCity() {
        return regionCity;
    }

    public void setRegionCity(int regionCity) {
        this.regionCity = regionCity;
    }

    public String getRegionProvName() {
        return regionProvName;
    }

    public void setRegionProvName(String regionProvName) {
        this.regionProvName = regionProvName;
    }

    public String getRegionCityName() {
        return regionCityName;
    }

    public void setRegionCityName(String regionCityName) {
        this.regionCityName = regionCityName;
    }

    public String getIdentityNo() {
        return identityNo;
    }

    public void setIdentityNo(String identityNo) {
        this.identityNo = identityNo;
    }

    public String getIdentityImage() {
        return identityImage;
    }

    public void setIdentityImage(String identityImage) {
        this.identityImage = identityImage;
    }
}
