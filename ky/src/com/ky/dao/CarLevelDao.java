package com.ky.dao;

import java.util.List;

import com.ky.entity.CarLevel;

public abstract interface CarLevelDao {
	public List<CarLevel> getAllCarLevel();

	public CarLevel getCarLevelById(Integer levelid);
}
