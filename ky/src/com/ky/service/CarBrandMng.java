package com.ky.service;

import java.util.List;

import com.ky.entity.CarBrand;

public abstract interface CarBrandMng {

	public abstract List<CarBrand> getAllCarBrand();

	public abstract CarBrand getCarBrandById(Integer brandid);
}
