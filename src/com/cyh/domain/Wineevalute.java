package com.cyh.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Wineevalute entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wineevalute", catalog = "wine")
public class Wineevalute implements java.io.Serializable {

	// Fields

	private Integer evaluteId;
	private Wine wine;
	private User user;
	private String evalute;
	private String eorno;
	private Date date;

	// Constructors

	/** default constructor */
	public Wineevalute() {
	}

	/** minimal constructor */
	public Wineevalute(Wine wine, User user) {
		this.wine = wine;
		this.user = user;
	}

	/** full constructor */
	public Wineevalute(Wine wine, User user, String evalute, String eorno,
			Date date) {
		this.wine = wine;
		this.user = user;
		this.evalute = evalute;
		this.eorno = eorno;
		this.date = date;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "EvaluteID", unique = true, nullable = false)
	public Integer getEvaluteId() {
		return this.evaluteId;
	}

	public void setEvaluteId(Integer evaluteId) {
		this.evaluteId = evaluteId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "WineID", nullable = false)
	public Wine getWine() {
		return this.wine;
	}

	public void setWine(Wine wine) {
		this.wine = wine;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UserID", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "Evalute", length = 100)
	public String getEvalute() {
		return this.evalute;
	}

	public void setEvalute(String evalute) {
		this.evalute = evalute;
	}

	@Column(name = "Eorno", length = 1)
	public String getEorno() {
		return this.eorno;
	}

	public void setEorno(String eorno) {
		this.eorno = eorno;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "Date", length = 10)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}