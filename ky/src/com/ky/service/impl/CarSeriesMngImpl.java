package com.ky.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ky.dao.CarSeriesDao;
import com.ky.entity.CarSeries;
import com.ky.service.CarSeriesMng;

@Service
public class CarSeriesMngImpl implements CarSeriesMng {
	@Resource
	private CarSeriesDao carSeriesMngDao;

	@Override
	public List<CarSeries> GetCarSeriesByBrand(Integer brandid) {
		List<CarSeries> list = this.carSeriesMngDao.getCarSeriesByBrandId(brandid);
		return list;
	}

	@Override
	public CarSeries getCarSeriesById(Integer seriesid) {
		CarSeries carSeries = this.carSeriesMngDao.getCarSeriesById(seriesid);
		return carSeries;
	}

}
