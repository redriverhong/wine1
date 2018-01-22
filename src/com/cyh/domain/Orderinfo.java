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
 * Orderinfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "orderinfo", catalog = "wine")
public class Orderinfo implements java.io.Serializable {

	// Fields

	private Integer ooId;
	private Wine wine;
	private Orderq orderq;
	private Integer orderCount;

	// Constructors

	/** default constructor */
	public Orderinfo() {
	}

	/** minimal constructor */
	public Orderinfo(Wine wine, Orderq orderq) {
		this.wine = wine;
		this.orderq = orderq;
	}

	/** full constructor */
	public Orderinfo(Wine wine, Orderq orderq, Integer orderCount) {
		this.wine = wine;
		this.orderq = orderq;
		this.orderCount = orderCount;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "ooID", unique = true, nullable = false)
	public Integer getOoId() {
		return this.ooId;
	}

	public void setOoId(Integer ooId) {
		this.ooId = ooId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "WineID", nullable = true)
	public Wine getWine() {
		return this.wine;
	}

	public void setWine(Wine wine) {
		this.wine = wine;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OrderID", nullable = true)
	public Orderq getOrderq() {
		return this.orderq;
	}

	public void setOrderq(Orderq orderq) {
		this.orderq = orderq;
	}

	@Column(name = "OrderCount")
	public Integer getOrderCount() {
		return this.orderCount;
	}

	public void setOrderCount(Integer orderCount) {
		this.orderCount = orderCount;
	}

}