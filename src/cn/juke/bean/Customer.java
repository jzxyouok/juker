package cn.juke.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Customer entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "customer", catalog = "juker")
public class Customer implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 2725933317825822554L;
	private Long id;
	private String name;
	private String phone;
	private String weixin;
	private String qq;
	private String comid;
	private Integer status;
	private String house_name;
	private String broker_name;
	private String dealtime;
	private String dealer;
	private String statusName;

	// Constructors

	@Transient
	public String getComid() {
		return comid;
	}

	public void setComid(String comid) {
		this.comid = comid;
	}

	/** default constructor */
	public Customer() {
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "name", length = 20)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "phone", length = 20)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "weixin", length = 50)
	public String getWeixin() {
		return this.weixin;
	}

	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}

	@Column(name = "qq", length = 20)
	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	@Transient
	public String getBroker_name() {
		return broker_name;
	}

	public void setBroker_name(String broker_name) {
		this.broker_name = broker_name;
	}
	
	@Transient
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Transient
	public String getHouse_name() {
		return house_name;
	}

	public void setHouse_name(String house_name) {
		this.house_name = house_name;
	}

	@Transient
	public String getDealtime() {
		return dealtime;
	}

	public void setDealtime(String dealtime) {
		this.dealtime = dealtime;
	}
    
	@Transient
	public String getDealer() {
		return dealer;
	}

	public void setDealer(String dealer) {
		this.dealer = dealer;
	}

	@Transient
	public String getStatusName() {
		return statusName;
	}

	public void setStatusName() {
		switch (status) {
		case 0:
			statusName = "待处理";
			break;
		case 1:
			statusName = "无效";
			break;
		case 2:
			statusName = "意向";
			break;
		case 3:
			statusName = "到访";
			break;
		case 4:
			statusName = "定金";
			break;
		case 5:
			statusName = "成交";
			break;
		default:
			statusName = "";
		}
	}

	public Customer(Long id, String name, String phone, String weixin,
			String qq,  Integer status, String house_name,
			String broker_name, String dealtime, String dealer) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.weixin = weixin;
		this.qq = qq;
		this.status = status;
		this.house_name = house_name;
		this.broker_name = broker_name;
		this.dealtime = dealtime;
		this.dealer = dealer;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", phone=" + phone
				+ ", weixin=" + weixin + ", qq=" + qq + ", comid=" + comid
				+ ", status=" + status + ", house_name=" + house_name
				+ ", broker_name=" + broker_name + ", dealtime=" + dealtime
				+ ", dealer=" + dealer + ", statusName=" + statusName + "]";
	}
}