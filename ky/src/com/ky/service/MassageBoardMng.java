package com.ky.service;

import java.util.List;

import com.ky.entity.MassageBoard;

public abstract interface MassageBoardMng {

	public abstract void addMassageBoard(MassageBoard massageBoard);

	public abstract List<MassageBoard> getCarMassageBoard(Integer carid);
	
}
