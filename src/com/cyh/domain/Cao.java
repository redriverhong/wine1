package com.cyh.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Cao entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "cao", catalog = "myssh")
public class Cao implements java.io.Serializable {

	// Fields

	private Integer userId;
	private String userName;
	private String password;
	private String phone;
	private String address;
	private String userType;

	// Constructors

	/** default constructor */
	public Cao() {
	}

	/** full constructor */
	public Cao(String userName, String password, String phone, String address,
			String userType) {
		this.userName = userName;
		this.password = password;
		this.phone = phone;
		this.address = address;
		this.userType = userType;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "userId", unique = true, nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "userName", length = 45)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "password", length = 45)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "phone", length = 45)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "address", length = 45)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "userType", length = 45)
	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

}