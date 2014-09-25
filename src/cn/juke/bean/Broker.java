package cn.juke.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Broker entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "broker", catalog = "juker")
public class Broker implements java.io.Serializable {

	// Fields

	private Long id;
	private String name;
	private String phone;
	private Integer dealNum;
	private Integer recNum;
	private Integer arvNum;
	private String bank;
	private String account;
	private int state;
	private String bankname;
	private String password;
	private String createtime;//注册时间

   
	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name="create_time")
	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	/** default constructor */
	public Broker() {
	}

	/** full constructor */
	public Broker(String name, String phone, Integer dealNum, Integer recNum,
			Integer arvNum, String bank, String account,int state,String createtime) {
		this.name = name;
		this.phone = phone;
		this.dealNum = dealNum;
		this.recNum = recNum;
		this.arvNum = arvNum;
		this.bank = bank;
		this.account = account;	
		this.createtime=createtime;}
	
	public Broker(Long id,String phone,String name,  Integer recNum,
			Integer arvNum,Integer dealNum,String account,String createtime) {
		this.id=id;
		this.name = name;
		this.dealNum = dealNum;
		this.recNum = recNum;
		this.arvNum = arvNum;
		this.phone=phone;
		this.account=account;
		this.createtime=createtime;
			}

	public Broker(Long id,String phone,String name) {
		this.id=id;
		this.name = name;
		
		this.phone=phone;
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

	@Transient
	public Integer getDealNum() {
		return this.dealNum;
	}

	public void setDealNum(Integer dealNum) {
		this.dealNum = dealNum;
	}

	@Transient
	public Integer getRecNum() {
		return this.recNum;
	}

	public void setRecNum(Integer recNum) {
		this.recNum = recNum;
	}

	@Transient
	public Integer getArvNum() {
		return this.arvNum;
	}

	public void setArvNum(Integer arvNum) {
		this.arvNum = arvNum;
	}

	@Column(name = "bank", length = 30)
	public String getBank() {
		return this.bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	@Column(name = "account", length = 30)
	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}
	
	@Column(name = "state")
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
}