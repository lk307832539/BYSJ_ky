package com.ky.entity;

import java.util.Set;

import com.ky.entity.base.AbstractCarSeries;

/**
 * CarSeries entity. @author MyEclipse Persistence Tools
 */
public class CarSeries extends AbstractCarSeries implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public CarSeries() {
	}

	/** minimal constructor */
	public CarSeries(CarBrand carBrand, String seriesName) {
		super(carBrand, seriesName);
	}

	/** full constructor */
	public CarSeries(CarBrand carBrand, String seriesName, Set cars) {
		super(carBrand, seriesName, cars);
	}

}
