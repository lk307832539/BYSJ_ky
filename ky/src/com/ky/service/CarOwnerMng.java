package com.ky.service;

import java.util.List;

import com.ky.entity.CarOwner;

public abstract interface CarOwnerMng {
	public abstract CarOwner addOwner(CarOwner carOwner);

	public abstract CarOwner updateOwner(CarOwner carOwner);
	
	public abstract List<CarOwner> getAllCarOwner();

	public abstract CarOwner getCarOwnerById(Integer ownerid);
}
