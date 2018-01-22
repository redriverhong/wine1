package com.cyh.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Shoppingcart entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "shoppingcart", catalog = "wine")
public class Shoppingcart implements java.io.Serializable {

	// Fields

	private Integer cartId;
	private Wine wine;
	private User user;
	private Integer cartCount;

	// Constructors

	/** default constructor */
	public Shoppingcart() {
	}

	/** full constructor */
	public Shoppingcart(Wine wine, User user, Integer cartCount) {
		this.wine = wine;
		this.user = user;
		this.cartCount = cartCount;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "CartID", unique = true, nullable = false)
	public Integer getCartId() {
		return this.cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "WineID")
	public Wine getWine() {
		return this.wine;
	}

	public void setWine(Wine wine) {
		this.wine = wine;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UserID")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "CartCount")
	public Integer getCartCount() {
		return this.cartCount;
	}

	public void setCartCount(Integer cartCount) {
		this.cartCount = cartCount;
	}

}