package com.ky.dao;

import java.util.List;

import com.ky.entity.CarBrand;

public abstract interface CarBrandDao {
	public List<CarBrand> getAllBrand();

	public CarBrand getCarBrandById(Integer brandid);
}
