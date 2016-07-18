package com.ky.entity;

import com.ky.entity.base.AbstractCarImg;

/**
 * CarImg entity. @author MyEclipse Persistence Tools
 */
public class CarImg extends AbstractCarImg implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public CarImg() {
	}

	/** minimal constructor */
	public CarImg(Car car) {
		super(car);
	}

	/** full constructor */
	public CarImg(Car car, String img1, String img2, String img3, String img4,
			String other) {
		super(car, img1, img2, img3, img4, other);
	}

}
