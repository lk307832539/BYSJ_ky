package com.ky.entity;

import java.sql.Timestamp;

import com.ky.entity.base.AbstractMassageBoard;

/**
 * MassageBoard entity. @author MyEclipse Persistence Tools
 */
public class MassageBoard extends AbstractMassageBoard implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public MassageBoard() {
	}

	/** minimal constructor */
	public MassageBoard(User user, Car car, Timestamp sendTime) {
		super(user, car, sendTime);
	}

	/** full constructor */
	public MassageBoard(User user, Car car, String content, Timestamp sendTime) {
		super(user, car, content, sendTime);
	}

}
