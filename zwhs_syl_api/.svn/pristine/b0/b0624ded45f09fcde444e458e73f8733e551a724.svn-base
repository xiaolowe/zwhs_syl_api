package cn.org.citycloud.zwhs.syl.bean;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

/**
 * desc the file.
 *
 * @author demon
 * @Date 2016/7/26 16:30
 */
public class RetailShopBean {
    @ApiModelProperty(value = "店铺名称", required = true)
    @NotBlank(message = "店铺名称不能为空")
    private String retailShop;

    @ApiModelProperty(value = "logo", required = true)
    @NotBlank(message = "logo不能为空")
    private String logoImage;

    @ApiModelProperty(value = "店铺banner", required = true)
    @NotBlank(message = "店铺banner不能为空")
    private String bannerImage;

    public String getRetailShop() {
        return retailShop;
    }

    public void setRetailShop(String retailShop) {
        this.retailShop = retailShop;
    }

    public String getLogoImage() {
        return logoImage;
    }

    public void setLogoImage(String logoImage) {
        this.logoImage = logoImage;
    }

    public String getBannerImage() {
        return bannerImage;
    }

    public void setBannerImage(String bannerImage) {
        this.bannerImage = bannerImage;
    }
}
