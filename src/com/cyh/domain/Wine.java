package com.cyh.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Wine entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wine", catalog = "wine")
public class Wine implements java.io.Serializable {

	// Fields

	private Integer wineId;
	private String wineName;
	private String wineType;
	private String winePhoto;
	private Long winePrice;
	private Integer wineCount;
	private Integer wineCapacity;
	private String wineIntroduce;
	private String origin;

	// Constructors

	/** default constructor */
	public Wine() {
	}

	/** full constructor */
	public Wine(String wineName, String wineType, String winePhoto,
			Long winePrice, Integer wineCount, Integer wineCapacity,
			String wineIntroduce, String origin) {
		this.wineName = wineName;
		this.wineType = wineType;
		this.winePhoto = winePhoto;
		this.winePrice = winePrice;
		this.wineCount = wineCount;
		this.wineCapacity = wineCapacity;
		this.wineIntroduce = wineIntroduce;
		this.origin = origin;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "WineID", unique = true, nullable = false)
	public Integer getWineId() {
		return this.wineId;
	}

	public void setWineId(Integer wineId) {
		this.wineId = wineId;
	}

	@Column(name = "WineName", length = 10)
	public String getWineName() {
		return this.wineName;
	}

	public void setWineName(String wineName) {
		this.wineName = wineName;
	}

	@Column(name = "WineType", length = 10)
	public String getWineType() {
		return this.wineType;
	}

	public void setWineType(String wineType) {
		this.wineType = wineType;
	}

	@Column(name = "WinePhoto", length = 10)
	public String getWinePhoto() {
		return this.winePhoto;
	}

	public void setWinePhoto(String winePhoto) {
		this.winePhoto = winePhoto;
	}

	@Column(name = "WinePrice", precision = 10, scale = 0)
	public Long getWinePrice() {
		return this.winePrice;
	}

	public void setWinePrice(Long winePrice) {
		this.winePrice = winePrice;
	}

	@Column(name = "WineCount")
	public Integer getWineCount() {
		return this.wineCount;
	}

	public void setWineCount(Integer wineCount) {
		this.wineCount = wineCount;
	}

	@Column(name = "WineCapacity")
	public Integer getWineCapacity() {
		return this.wineCapacity;
	}

	public void setWineCapacity(Integer wineCapacity) {
		this.wineCapacity = wineCapacity;
	}

	@Column(name = "WineIntroduce", length = 10)
	public String getWineIntroduce() {
		return this.wineIntroduce;
	}

	public void setWineIntroduce(String wineIntroduce) {
		this.wineIntroduce = wineIntroduce;
	}

	@Column(name = "Origin", length = 10)
	public String getOrigin() {
		return this.origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

}