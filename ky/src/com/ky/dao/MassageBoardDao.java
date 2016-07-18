package com.ky.dao;

import java.util.List;

import com.ky.entity.MassageBoard;

public abstract interface MassageBoardDao {

	public void addMassageBoard(MassageBoard massageBoard);

	public List<MassageBoard> getCarMassageBoard(Integer carid);

}
