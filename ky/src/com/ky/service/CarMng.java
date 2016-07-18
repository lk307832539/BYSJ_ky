package com.ky.service;

import java.util.List;

import com.ky.entity.Car;
import com.ky.entity.User;


public abstract interface CarMng {
	
	public abstract Car addCar(Car car);

	public abstract List<Car> getAllCar();

	//根据车主获取car
	public abstract List<Car> getAllCar(Integer userid);

	//根据查询条件获取car
	public abstract List<Car> getAllCar(Integer brandId,Integer seriesId,Integer levelId,Integer minPrice,Integer maxPrice,boolean GPS,boolean DVD);
	
	public abstract Car delCar(Integer id);
	
	public abstract Car getCar(Integer id);
	
	public abstract Car updateCar(Car car);

	public abstract List<Car> getAllCarNoSelle();

	public abstract List<Car> getCarBySearch(Double minprice, Double maxprice, Integer gearbox, Integer displacement,
			boolean gps, boolean dvd);

}
