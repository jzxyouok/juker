package cn.juke.bean;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * House entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "house", catalog = "juker")
public class House implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String province;
	private String city;
	private String district;
	private String name;
	private String adress;
	private String area;
	private double price;
	private String feature;
	private String discount;
    private String picture;
	private String saleTime;
	private String descr;
	private String btype;
	private String dtype;
	private String saleAdress;
	private String salePhone;
	private String transport;
	private String stop;
	private String relat;
	private String developer;
	private String location;
	private String modifyTime;
	private Long comid;

	// Constructors


	/** default constructor */
	public House() {
	}

	public Long getComid() {
		return comid;
	}

	public void setComid(Long comid) {
		this.comid = comid;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/** full constructor */
	public House(String province, String city, String district, String name,
			String adress, String area, double price, String feature,
			String discount, String picyure, String picture, String saleTime,
			String descr, String btype, String dtype, String saleAdress,
			String salePhone, String transport, String stop, String relat,
			String developer, String location, String modifyTime) {
		this.province = province;
		this.city = city;
		this.district = district;
		this.name = name;
		this.adress = adress;
		this.area = area;
		this.price = price;
		this.feature = feature;
		this.discount = discount;
		this.picture=picture;
		this.saleTime = saleTime;
		this.descr = descr;
		this.btype = btype;
		this.dtype = dtype;
		this.saleAdress = saleAdress;
		this.salePhone = salePhone;
		this.transport = transport;
		this.stop = stop;
		this.relat = relat;
		this.developer = developer;
		this.location = location;
		this.modifyTime = modifyTime;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "province", length = 50)
	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Column(name = "city", length = 30)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "district", length = 30)
	public String getDistrict() {
		return this.district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	@Column(name = "name", length = 40)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "adress", length = 60)
	public String getAdress() {
		return this.adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	@Column(name = "area", precision = 20, scale = 0)
	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Column(name = "price", precision = 20, scale = 0)
	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Column(name = "feature", length = 300)
	public String getFeature() {
		return this.feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}

	@Column(name = "discount", precision = 50, scale = 0)
	public String getDiscount() {
		return this.discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	@Column(name="picture")
	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	@Column(name = "sale_time", length = 50)
	public String getSaleTime() {
		return this.saleTime;
	}

	public void setSaleTime(String saleTime) {
		this.saleTime = saleTime;
	}

	@Column(name = "descr", length = 500)
	public String getDescr() {
		return this.descr;
	}

	public void setDescr(String desc) {
		this.descr = desc;
	}

	@Column(name = "btype")
	public String getBtype() {
		return this.btype;
	}

	public void setBtype(String btype) {
		this.btype = btype;
	}

	@Column(name = "dtype")
	public String getDtype() {
		return this.dtype;
	}

	public void setDtype(String dtype) {
		this.dtype = dtype;
	}

	@Column(name = "sale_adress", length = 100)
	public String getSaleAdress() {
		return this.saleAdress;
	}

	public void setSaleAdress(String saleAdress) {
		this.saleAdress = saleAdress;
	}

	@Column(name = "sale_phone", length = 30)
	public String getSalePhone() {
		return this.salePhone;
	}

	public void setSalePhone(String salePhone) {
		this.salePhone = salePhone;
	}

	@Column(name = "transport", length = 100)
	public String getTransport() {
		return this.transport;
	}

	public void setTransport(String transport) {
		this.transport = transport;
	}

	@Column(name = "stop", length = 50)
	public String getStop() {
		return this.stop;
	}

	public void setStop(String stop) {
		this.stop = stop;
	}

	@Column(name = "relat", length = 300)
	public String getRelat() {
		return this.relat;
	}

	public void setRelat(String relat) {
		this.relat = relat;
	}

	@Column(name = "developer", length = 500)
	public String getDeveloper() {
		return this.developer;
	}

	public void setDeveloper(String developer) {
		this.developer = developer;
	}

	@Column(name = "location", length = 300)
	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Column(name = "modify_time", length = 50)
	public String getModifyTime() {
		return this.modifyTime;
	}

	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}
}