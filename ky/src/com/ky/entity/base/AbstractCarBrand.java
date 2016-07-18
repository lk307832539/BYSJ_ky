package com.ky.entity.base;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.DynamicUpdate;

/**
 * AbstractCarBrand entity provides the base persistence definition of the
 * CarBrand entity. @author MyEclipse Persistence Tools
 */
@DynamicUpdate(true)
public abstract class AbstractCarBrand implements java.io.Serializable {

	// Fields

	private Integer brandId;
	private String brandName;
	private Set carSerieses = new HashSet(0);
	private Set cars = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractCarBrand() {
	}

	/** full constructor */
	public AbstractCarBrand(String brandName, Set carSerieses, Set cars) {
		this.brandName = brandName;
		this.carSerieses = carSerieses;
		this.cars = cars;
	}

	// Property accessors

	public Integer getBrandId() {
		return this.brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

	public String getBrandName() {
		return this.brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public Set getCarSerieses() {
		return this.carSerieses;
	}

	public void setCarSerieses(Set carSerieses) {
		this.carSerieses = carSerieses;
	}

	public Set getCars() {
		return this.cars;
	}

	public void setCars(Set cars) {
		this.cars = cars;
	}

}