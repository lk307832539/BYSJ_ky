package com.ky.entity;

import java.util.Set;

import com.ky.entity.base.AbstractCar;

/**
 * Car entity. @author MyEclipse Persistence Tools
 */
public class Car extends AbstractCar implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Car() {
	}

	/** minimal constructor */
	public Car(CarLevel carLevel, CarBrand carBrand, CarSeries carSeries,
			CarOwner carOwner, Integer displacement, Integer gearbox,
			Double price, Boolean isSelled, Boolean isChecked,
			Boolean isVehicleLicense) {
		super(carLevel, carBrand, carSeries, carOwner, displacement, gearbox,
				price, isSelled, isChecked, isVehicleLicense);
	}

	/** full constructor */
	public Car(CarLevel carLevel, CarBrand carBrand, CarSeries carSeries,
			CarOwner carOwner, Integer carAge, Integer seatNum,
			Integer displacement, Integer gearbox, Boolean gps, Boolean dvd,
			Boolean reverseRadar, Integer airBag, Double price,
			Boolean isSelled, Boolean isChecked, Boolean isVehicleLicense,
			VehicleLicense vehicleLicenses, Set massageBoards, Set carImgs, Set orders) {
		super(carLevel, carBrand, carSeries, carOwner, carAge, seatNum,
				displacement, gearbox, gps, dvd, reverseRadar, airBag, price,
				isSelled, isChecked, isVehicleLicense, vehicleLicenses,
				massageBoards, carImgs, orders);
	}

}
