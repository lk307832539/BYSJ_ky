package com.ky.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ky.dao.CarDao;
import com.ky.entity.Car;
import com.ky.service.CarMng;

@Service
public class CarMngImpl implements CarMng {

	@Resource
	private CarDao carDao;

	@Override
	public Car addCar(Car car) {
		this.carDao.addCar(car);
		return null;
	}

	@Override
	public List<Car> getAllCar() {
		List<Car> list = this.carDao.getAllCar();
		return list;
	}

	@Override
	public List<Car> getAllCar(Integer userid) {
		List<Car> list = this.carDao.getAllCar(userid);
		return list;
	}

	@Override
	public List<Car> getAllCar(Integer brandId, Integer seriesId, Integer levelId, Integer minPrice, Integer maxPrice,
			boolean GPS, boolean DVD) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Car delCar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Car getCar(Integer carid) {
		Car car = this.carDao.getCar(carid);
		return car;
	}

	@Override
	public Car updateCar(Car car) {
		this.carDao.updateCar(car);
		return null;
	}

	@Override
	public List<Car> getAllCarNoSelle() {
		List<Car> list = this.carDao.getAllCarNoSelle();
		return list;
	}

	@Override
	public List<Car> getCarBySearch(Double minprice, Double maxprice, Integer gearbox, Integer displacement,
			boolean gps, boolean dvd) {
		List<Car> list = this.carDao.getCarBySearch(minprice, maxprice, gearbox, displacement, gps, dvd);
		return list;
	}
}
