package com.ky.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ky.dao.CarLevelDao;
import com.ky.entity.CarLevel;
import com.ky.service.CarLevelMng;

@Service
public class CarLevelMngImpl implements CarLevelMng{
	@Resource
	private CarLevelDao carLevelDao;

	@Override
	public List<CarLevel> getAllCarLevel() {
		List<CarLevel> list = this.carLevelDao.getAllCarLevel();
		return list;
	}

	@Override
	public CarLevel getCarLevelById(Integer levelid) {
		CarLevel carLevel = this.carLevelDao.getCarLevelById(levelid);
		return carLevel;
	}

}
