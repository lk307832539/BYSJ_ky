package com.ky.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ky.dao.MassageBoardDao;
import com.ky.entity.MassageBoard;
import com.ky.service.MassageBoardMng;

@Service
public class MassageBoardMngImpl implements MassageBoardMng {
	@Resource
	private MassageBoardDao massageBoardDao;

	@Override
	public void addMassageBoard(MassageBoard massageBoard) {
		this.massageBoardDao.addMassageBoard(massageBoard);
	}

	@Override
	public List<MassageBoard> getCarMassageBoard(Integer carid) {
		List<MassageBoard> list =  this.massageBoardDao.getCarMassageBoard(carid);
		return list;
	}

}
