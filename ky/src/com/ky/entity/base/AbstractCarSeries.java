package com.ky.entity.base;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.DynamicUpdate;

import com.ky.entity.CarBrand;

/**
 * AbstractCarSeries entity provides the base persistence definition of the
 * CarSeries entity. @author MyEclipse Persistence Tools
 */
@DynamicUpdate(true)
public abstract class AbstractCarSeries implements java.io.Serializable {

	// Fields

	private Integer seriesId;
	private CarBrand carBrand;
	private String seriesName;
	private Set cars = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractCarSeries() {
	}

	/** minimal constructor */
	public AbstractCarSeries(CarBrand carBrand, String seriesName) {
		this.carBrand = carBrand;
		this.seriesName = seriesName;
	}

	/** full constructor */
	public AbstractCarSeries(CarBrand carBrand, String seriesName, Set cars) {
		this.carBrand = carBrand;
		this.seriesName = seriesName;
		this.cars = cars;
	}

	// Property accessors

	public Integer getSeriesId() {
		return this.seriesId;
	}

	public void setSeriesId(Integer seriesId) {
		this.seriesId = seriesId;
	}

	public CarBrand getCarBrand() {
		return this.carBrand;
	}

	public void setCarBrand(CarBrand carBrand) {
		this.carBrand = carBrand;
	}

	public String getSeriesName() {
		return this.seriesName;
	}

	public void setSeriesName(String seriesName) {
		this.seriesName = seriesName;
	}

	public Set getCars() {
		return this.cars;
	}

	public void setCars(Set cars) {
		this.cars = cars;
	}

}