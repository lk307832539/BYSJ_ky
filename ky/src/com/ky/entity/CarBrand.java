package com.ky.entity;

import java.util.Set;

import com.ky.entity.base.AbstractCarBrand;

/**
 * CarBrand entity. @author MyEclipse Persistence Tools
 */
public class CarBrand extends AbstractCarBrand implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public CarBrand() {
	}

	/** full constructor */
	public CarBrand(String brandName, Set carSerieses, Set cars) {
		super(brandName, carSerieses, cars);
	}

}
