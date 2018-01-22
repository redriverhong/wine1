package com.cyh.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Orderq entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "orderq", catalog = "wine")
public class Orderq implements java.io.Serializable {

	// Fields

	private Long orderId;
	private User user;
	private String uname;
	private Integer payorno;
	private Integer phone;
	private String address;
	private Integer youbian;
	private Set<Orderinfo> orderinfos = new HashSet<Orderinfo>(0);

	// Constructors

	/** default constructor */
	public Orderq() {
	}

	/** full constructor */
	public Orderq(User user, String uname, Integer payorno, Integer phone,
			String address, Integer youbian, Set<Orderinfo> orderinfos) {
		this.user = user;
		this.uname = uname;
		this.payorno = payorno;
		this.phone = phone;
		this.address = address;
		this.youbian = youbian;
		this.orderinfos = orderinfos;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "OrderID", unique = true, nullable = false)
	public Long getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UserID")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "uname", length = 10)
	public String getUname() {
		return this.uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	@Column(name = "Payorno")
	public Integer getPayorno() {
		return this.payorno;
	}

	public void setPayorno(Integer payorno) {
		this.payorno = payorno;
	}

	@Column(name = "Phone")
	public Integer getPhone() {
		return this.phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	@Column(name = "Address", length = 50)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "youbian")
	public Integer getYoubian() {
		return this.youbian;
	}

	public void setYoubian(Integer youbian) {
		this.youbian = youbian;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "orderq")
	public Set<Orderinfo> getOrderinfos() {
		return this.orderinfos;
	}

	public void setOrderinfos(Set<Orderinfo> orderinfos) {
		this.orderinfos = orderinfos;
	}

}