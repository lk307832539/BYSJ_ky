package com.ky.entity;

import java.util.Set;

import com.ky.entity.base.AbstractCarOwner;

/**
 * CarOwner entity. @author MyEclipse Persistence Tools
 */
public class CarOwner extends AbstractCarOwner implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public CarOwner() {
	}

	/** minimal constructor */
	public CarOwner(User user, String realName, String idCard, String phone) {
		super(user, realName, idCard, phone);
	}

	/** full constructor */
	public CarOwner(User user, String realName, String idCard, String phone,
			String idCardFirImg, String idCardSecImg, Boolean isChecked,
			Set cars) {
		super(user, realName, idCard, phone, idCardFirImg, idCardSecImg,
				isChecked, cars);
	}

}
