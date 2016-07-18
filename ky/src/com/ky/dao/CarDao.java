package com.ky.dao;

import java.util.List;

import com.ky.entity.Car;

public abstract interface CarDao {
	
	public void addCar(Car car);

	public List<Car> getAllCar();

	//根据车主获取car
	public List<Car> getAllCar(Integer userid);

	//根据查询条件获取car
	public List<Car> getAllCar(Integer brandId,Integer seriesId,Integer levelId,Integer minPrice,Integer maxPrice,boolean GPS,boolean DVD);
	
	public boolean delCar(Integer id);
	
	public Car getCar(Integer id);
	
	public boolean updateCar(Car car);

	public List<Car> getAllCarNoSelle();

	public List<Car> getCarBySearch(Double minprice, Double maxprice, Integer gearbox, Integer displacement,
			boolean gps, boolean dvd);
	
	
}
