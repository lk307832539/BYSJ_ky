package com.ky.service;

import com.ky.entity.VehicleLicense;

public abstract interface VehicleLicenseMng {

	public abstract VehicleLicense getVehicleLicenseByCarId(Integer carid);

	public abstract void addNewVehicleLicense(VehicleLicense vehicleLicense);
	
}
