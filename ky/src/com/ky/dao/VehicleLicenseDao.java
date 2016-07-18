package com.ky.dao;

import com.ky.entity.VehicleLicense;

public abstract interface VehicleLicenseDao {
	
	public VehicleLicense getVehicleLicenseByCarId(Integer carid);

	public void saveOrUpdate(VehicleLicense vehicleLicense);
	
}
