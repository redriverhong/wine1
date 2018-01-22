package com.cyh.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user", catalog = "wine")
public class User implements java.io.Serializable {

	// Fields

	private Integer userId;
	private String userName;
	private String passWord;
	private String photo;
	private String phone;
	private String address;
	private String userType;
	private Long balance;
	private Integer youbian;
	private String trueName;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String userName, String passWord, String userType, Long balance,Integer youbian,String trueName) {
		this.userName = userName;
		this.passWord = passWord;
		this.userType = userType;
		this.balance = balance;
		this.youbian=youbian;
		this.trueName=trueName;
	}

	/** full constructor */
	public User(String userName, String passWord, String photo, String phone,
			String address, String userType, Long balance,Integer youbian,String trueName) {
		this.userName = userName;
		this.passWord = passWord;
		this.photo = photo;
		this.phone = phone;
		this.address = address;
		this.userType = userType;
		this.balance = balance;
		this.youbian=youbian;
		this.trueName=trueName;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "UserID", unique = true, nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "UserName", nullable = false, length = 100)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "PassWord", nullable = false, length = 100)
	public String getPassWord() {
		return this.passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	@Column(name = "Photo", length = 256)
	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Column(name = "Phone", length = 10)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "Address", length = 11)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "UserType", length = 50)
	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Column(name = "Balance", precision=3)
	public Long getBalance() {
		return this.balance;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}
	@Column(name = "Youbian", length=6)
	public Integer getYoubian() {
		return this.youbian;
	}

	public void setYoubian(Integer youbian) {
		this.youbian = youbian;
	}
	@Column(name = "TrueName", length=10)
	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

}