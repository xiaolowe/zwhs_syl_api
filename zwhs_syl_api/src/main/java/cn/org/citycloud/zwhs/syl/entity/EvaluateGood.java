package cn.org.citycloud.zwhs.syl.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the evaluate_goods database table.
 * 
 */
@Entity
@Table(name="evaluate_goods")
@NamedQuery(name="EvaluateGood.findAll", query="SELECT e FROM EvaluateGood e")
public class EvaluateGood implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="geval_id")
	private Integer gevalId;

	@Column(name="company_name")
	private String companyName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="geval_addtime")
	private Date gevalAddtime;

	@Column(name="geval_content")
	private String gevalContent;

	@Column(name="geval_explain")
	private String gevalExplain;

	@Column(name="geval_image")
	private String gevalImage;

	@Column(name="geval_isanonymous")
	private Integer gevalIsanonymous;

	@Column(name="geval_remark")
	private String gevalRemark;

	@Column(name="geval_scores")
	private Integer gevalScores;

	@Column(name="geval_state")
	private Integer gevalState;

	@Column(name="goods_id")
	private Integer goodsId;

	@Column(name="goods_name")
	private String goodsName;

	@Column(name="goods_price")
	private BigDecimal goodsPrice;

	@Column(name="member_id")
	private Integer memberId;

	@Column(name="member_truename")
	private String memberTruename;

	@Column(name="order_goods_id")
	private Integer orderGoodsId;

	@Column(name="order_id")
	private Integer orderId;

	@Column(name="order_type")
	private Integer orderType;

	@Column(name="store_id")
	private Integer storeId;

	public EvaluateGood() {
	}

	public Integer getGevalId() {
		return this.gevalId;
	}

	public void setGevalId(Integer gevalId) {
		this.gevalId = gevalId;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Date getGevalAddtime() {
		return this.gevalAddtime;
	}

	public void setGevalAddtime(Date gevalAddtime) {
		this.gevalAddtime = gevalAddtime;
	}

	public String getGevalContent() {
		return this.gevalContent;
	}

	public void setGevalContent(String gevalContent) {
		this.gevalContent = gevalContent;
	}

	public String getGevalExplain() {
		return this.gevalExplain;
	}

	public void setGevalExplain(String gevalExplain) {
		this.gevalExplain = gevalExplain;
	}

	public String getGevalImage() {
		return this.gevalImage;
	}

	public void setGevalImage(String gevalImage) {
		this.gevalImage = gevalImage;
	}

	public Integer getGevalIsanonymous() {
		return this.gevalIsanonymous;
	}

	public void setGevalIsanonymous(Integer gevalIsanonymous) {
		this.gevalIsanonymous = gevalIsanonymous;
	}

	public String getGevalRemark() {
		return this.gevalRemark;
	}

	public void setGevalRemark(String gevalRemark) {
		this.gevalRemark = gevalRemark;
	}

	public Integer getGevalScores() {
		return this.gevalScores;
	}

	public void setGevalScores(Integer gevalScores) {
		this.gevalScores = gevalScores;
	}

	public Integer getGevalState() {
		return this.gevalState;
	}

	public void setGevalState(Integer gevalState) {
		this.gevalState = gevalState;
	}

	public Integer getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return this.goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public BigDecimal getGoodsPrice() {
		return this.goodsPrice;
	}

	public void setGoodsPrice(BigDecimal goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public Integer getMemberId() {
		return this.memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public String getMemberTruename() {
		return this.memberTruename;
	}

	public void setMemberTruename(String memberTruename) {
		this.memberTruename = memberTruename;
	}

	public Integer getOrderGoodsId() {
		return this.orderGoodsId;
	}

	public void setOrderGoodsId(Integer orderGoodsId) {
		this.orderGoodsId = orderGoodsId;
	}

	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getOrderType() {
		return this.orderType;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}

	public Integer getStoreId() {
		return this.storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

}