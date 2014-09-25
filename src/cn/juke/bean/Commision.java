package cn.juke.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Commision entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "commision", catalog = "juker")
public class Commision implements java.io.Serializable {

	// Fields

	private Long id;
	private Integer sum;
	private String rate;

	// Constructors

	/** default constructor */
	public Commision() {
	}

	/** full constructor */
	public Commision(Integer sum, String rate) {
		this.sum = sum;
		this.rate = rate;
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

	@Column(name = "sum", precision = 25, scale = 0)
	public double getSum() {
		return this.sum;
	}

	public void setSum(Integer sum) {
		this.sum = sum;
	}

	@Column(name = "rate", length = 20)
	public String getRate() {
		return this.rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

}