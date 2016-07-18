package com.ky.dao;

import java.util.List;

import com.ky.entity.CarOwner;

public abstract interface CarOwnerDao {
	public void addOwner(CarOwner carowner);
	
	public List<CarOwner> getAllCarOwner();

	public CarOwner getCarOwnerById(Integer ownerid);

	public void updateOwner(CarOwner carOwner);

}
