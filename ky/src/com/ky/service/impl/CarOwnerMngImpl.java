package com.ky.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ky.dao.CarOwnerDao;
import com.ky.entity.CarOwner;
import com.ky.service.CarOwnerMng;

@Service
public class CarOwnerMngImpl implements CarOwnerMng {
	@Resource
	private CarOwnerDao ownerDao;

	@Override
	public CarOwner addOwner(CarOwner carowner) {
		this.ownerDao.addOwner(carowner);
		return null;

	}
	
	@Override
	public List<CarOwner> getAllCarOwner() {
		List<CarOwner> list = this.ownerDao.getAllCarOwner();
		return list;
	}

	@Override
	public CarOwner getCarOwnerById(Integer ownerid) {
		CarOwner carOwner = this.ownerDao.getCarOwnerById(ownerid);
		return carOwner;
	}

	@Override
	public CarOwner updateOwner(CarOwner carOwner) {
		this.ownerDao.updateOwner(carOwner);
		return null;
	}
}
