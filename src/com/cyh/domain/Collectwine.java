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
 * Collectwine entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "collectwine", catalog = "wine")
public class Collectwine implements java.io.Serializable {

	// Fields

	private Integer collectId;
	private Wine wine;
	private User user;

	// Constructors

	/** default constructor */
	public Collectwine() {
	}

	/** full constructor */
	public Collectwine(Wine wine, User user) {
		this.wine = wine;
		this.user = user;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "CollectID", unique = true, nullable = false)
	public Integer getCollectId() {
		return this.collectId;
	}

	public void setCollectId(Integer collectId) {
		this.collectId = collectId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
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

}