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
	private String house_btype;
	private Integer status;
	private double money;
	private double commision;
	private String cstate;//支付状态
	private String dealtime;
	private String comid;
	private String dealer;
	private String createtime;//经纪人推荐时间
	
	// Constructors

	@Column(name="create_time")
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

	@Transient
	public String getHouse_btype() {
		return house_btype;
	}

	public void setHouse_btype(String house_btype) {
		this.house_btype = house_btype;
	}

	public Deal(Long id, String customer_name, String house_name,
			String house_btype, String broker_name, String dealtime,
			double money, double commision, String cstate) {
		super();
		this.id = id;
		this.customer_name = customer_name;
		this.house_name = house_name;
		this.house_btype = house_btype;
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

}