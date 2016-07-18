package com.ky.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ky.dao.VehicleLicenseDao;
import com.ky.entity.VehicleLicense;
import com.ky.service.VehicleLicenseMng;

@Service
public class VehicleLicenseMngImpl implements VehicleLicenseMng {
	@Resource
	private VehicleLicenseDao vehicleLicenseDao;

	@Override
	public VehicleLicense getVehicleLicenseByCarId(Integer carid) {
		VehicleLicense vehicleLicense = this.vehicleLicenseDao.getVehicleLicenseByCarId(carid);
		return vehicleLicense;
	}

	@Override
	public void addNewVehicleLicense(VehicleLicense vehicleLicense) {
		this.vehicleLicenseDao.saveOrUpdate(vehicleLicense);
		
	}

}
