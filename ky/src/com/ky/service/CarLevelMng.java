package com.ky.service;

import java.util.List;

import com.ky.entity.CarLevel;

public abstract interface CarLevelMng {
	
	public abstract List<CarLevel> getAllCarLevel();

	public abstract CarLevel getCarLevelById(Integer levelid);
}
