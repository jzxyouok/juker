package cn.juke.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Deal entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "deal", catalog = "juker")
public class Deal implements java.io.Serializable {

	// Fields

	private Long id;
	private Long house_id;
	private Long broker_id;
	private Long customer_id;
	private String house_name;
	private String customer_name;
	private String broker_name;
	private Integer house_type;
	private String house_type_name;
	private Integer status;
	private double money;
	private double commision;
	private String cstate;// 支付状态
	private String dealtime;
	private String comid;
	private String dealer;
	private String createtime;// 经纪人推荐时间
	private String cstate_name;// 支付状态名字
	private String status_name;// 状态名字

	// Constructors

	@Transient
	public String getCstate_name() {
		return cstate_name;
	}

	public void setCstate_name(String cstate_name) {
		this.cstate_name = cstate_name;
	}

	public void setCstate_name() {
		if ("0".equals(cstate))
			setCstate_name("未支付");
		else if ("1".equals(cstate))
			setCstate_name("已支付");
	}

	@Transient
	public String getStatus_name() {
		return status_name;
	}

	public void setStatus_name(String status_name) {
		this.status_name = status_name;
	}

	public void setStatus_name() {
		switch (status) {
		case 0:
			setStatus_name("待处理");
			break;
		case 1:
			setStatus_name("无效");
			break;
		case 2:
			setStatus_name("到访");
			break;
		case 3:
			setStatus_name("意向");
			break;
		case 4:
			setStatus_name("定金");
			break;
		case 5:
			setStatus_name("成交");
			break;
		}
	}

	@Column(name = "create_time")
	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getComid() {
		return comid;
	}

	public void setComid(String comid) {
		this.comid = comid;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	/** default constructor */
	public Deal() {
	}

	@Transient
	public String getHouse_name() {
		return house_name;
	}

	public void setHouse_name(String house_name) {
		this.house_name = house_name;
	}

	@Transient
	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	@Transient
	public String getBroker_name() {
		return broker_name;
	}

	public void setBroker_name(String broker_name) {
		this.broker_name = broker_name;
	}

	public Deal(Long id, String customer_name, String house_name,
			Integer house_type, String broker_name, String dealtime,
			double money, double commision, String cstate) {
		super();
		this.id = id;
		this.customer_name = customer_name;
		this.house_name = house_name;
		this.house_type = house_type;
		this.broker_name = broker_name;
		this.dealtime = dealtime;
		this.money = money;
		this.commision = commision;
		this.cstate = cstate;
	}

	/** full constructor */
	public Deal(Long house_id, Long broker_id, Long customer_id, double money,
			double commision, String cstate, String dealtime) {
		this.house_id = house_id;
		this.broker_id = broker_id;
		this.customer_id = customer_id;
		this.money = money;
		this.commision = commision;
		this.cstate = cstate;
		this.dealtime = dealtime;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	@Column(name = "house_id")
	public Long getHouse_id() {
		return this.house_id;
	}

	public void setHouse_id(Long house_id) {
		this.house_id = house_id;
	}

	@Column(name = "broker_id")
	public Long getBroker_id() {
		return this.broker_id;
	}

	public void setBroker_id(Long broker_id) {
		this.broker_id = broker_id;
	}

	@Column(name = "customer_id")
	public Long getCustomer_id() {
		return this.customer_id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}

	@Column(name = "money", precision = 30, scale = 0)
	public double getMoney() {
		return this.money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	@Column(name = "commision", precision = 30, scale = 0)
	public double getCommision() {
		return this.commision;
	}

	public void setCommision(double commision) {
		this.commision = commision;
	}

	@Column(name = "cstate")
	public String getCstate() {
		return this.cstate;
	}

	public void setCstate(String cstate) {
		this.cstate = cstate;
	}

	@Column(name = "deal_time", length = 30)
	public String getDealtime() {
		return this.dealtime;
	}

	public void setDealtime(String dealtime) {
		this.dealtime = dealtime;
	}

	public String getDealer() {
		return dealer;
	}

	public void setDealer(String dealer) {
		this.dealer = dealer;
	}

	public Integer getHouse_type() {
		return house_type;
	}

	public void setHouse_type(Integer house_type) {
		this.house_type = house_type;
	}

	@Transient
	public String getHouse_type_name() {
		return house_type_name;
	}

	public void setHouse_type_name(String house_type_name) {
		this.house_type_name = house_type_name;
	}

	public void setHouse_type_name() {
		switch (house_type) {
		case 1:
			setHouse_type_name("一居");
			break;
		case 2:
			setHouse_type_name("两居");
			break;
		case 3:
			setHouse_type_name("三居");
			break;
		case 4:
			setHouse_type_name("四居");
			break;
		case 5:
			setHouse_type_name("别墅");
			break;
		}
	}

	public Deal(Long broker_id, String broker_name, String house_name,
			Integer house_type, String customer_name, Integer status,
			double money, double commision, String createtime, String dealtime,
			String cstate, String dealer) {
		super();
		this.broker_id = broker_id;
		this.house_name = house_name;
		this.customer_name = customer_name;
		this.broker_name = broker_name;
		this.house_type = house_type;
		this.status = status;
		this.money = money;
		this.commision = commision;
		this.cstate = cstate;
		this.dealtime = dealtime;
		this.dealer = dealer;
		this.createtime = createtime;
	}
}