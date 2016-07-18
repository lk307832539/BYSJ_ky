package com.ky.entity;

import java.sql.Timestamp;

import com.ky.entity.base.AbstractVehicleLicense;

/**
 * VehicleLicense entity. @author MyEclipse Persistence Tools
 */
public class VehicleLicense extends AbstractVehicleLicense implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public VehicleLicense() {
	}

	/** minimal constructor */
	public VehicleLicense(Car car, Boolean isChecked) {
		super(car, isChecked);
	}

	/** full constructor */
	public VehicleLicense(Car car, String plateNo, String vehicleType,
			String owener, String address, String useCharacter, String model,
			String vin, String engineNo, Timestamp registerDate,
			Timestamp lssueDate, String vehicleLicenseFirImg,
			String vehicleLicenseSecImg, Boolean isChecked) {
		super(car, plateNo, vehicleType, owener, address, useCharacter, model,
				vin, engineNo, registerDate, lssueDate, vehicleLicenseFirImg,
				vehicleLicenseSecImg, isChecked);
	}

}
