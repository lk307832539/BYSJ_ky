package com.ky.service;

import java.util.List;

import com.ky.entity.CarSeries;

public abstract interface CarSeriesMng {
	public abstract List<CarSeries> GetCarSeriesByBrand(Integer brandid);

	public abstract CarSeries getCarSeriesById(Integer seriesid);
}
