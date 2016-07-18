package com.ky.dao;

import java.util.List;

import com.ky.entity.CarSeries;

public abstract interface CarSeriesDao {
	public List<CarSeries> getCarSeriesByBrandId(Integer brandid);

	public CarSeries getCarSeriesById(Integer seriesid);
}
