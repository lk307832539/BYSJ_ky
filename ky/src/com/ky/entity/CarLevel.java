package com.ky.entity;

import java.util.Set;

import com.ky.entity.base.AbstractCarLevel;

/**
 * CarLevel entity. @author MyEclipse Persistence Tools
 */
public class CarLevel extends AbstractCarLevel implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public CarLevel() {
	}

	/** minimal constructor */
	public CarLevel(String levelName) {
		super(levelName);
	}

	/** full constructor */
	public CarLevel(String levelName, Set cars) {
		super(levelName, cars);
	}

}
