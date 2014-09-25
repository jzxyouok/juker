package cn.juke.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Household entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "household", catalog = "juker")
public class Household implements java.io.Serializable {

	// Fields

	private Long id;
	private String houseType;
	private String typeName;

	// Constructors

	/** default constructor */
	public Household() {
	}

	/** full constructor */
	public Household(String houseType, String typeName) {
		this.houseType = houseType;
		this.typeName = typeName;
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

	@Column(name = "house_type", length = 20)
	public String getHouseType() {
		return this.houseType;
	}

	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}

	@Column(name = "type_name", length = 30)
	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

}