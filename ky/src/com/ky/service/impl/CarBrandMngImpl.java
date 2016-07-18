package com.ky.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ky.dao.CarBrandDao;
import com.ky.entity.CarBrand;
import com.ky.service.CarBrandMng;

@Service
public class CarBrandMngImpl implements CarBrandMng{
	@Resource
	private CarBrandDao carBrandDao;

	@Override
	public List<CarBrand> getAllCarBrand() {
		List<CarBrand> list = this.carBrandDao.getAllBrand();
		return list;
	}

	@Override
	public CarBrand getCarBrandById(Integer brandid) {
		CarBrand carBrand = this.carBrandDao.getCarBrandById(brandid);
		return carBrand;
	}

}
