package com.ky.entity;

import java.util.Set;

import com.ky.entity.base.AbstractTenant;

/**
 * Tenant entity. @author MyEclipse Persistence Tools
 */
public class Tenant extends AbstractTenant implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Tenant() {
	}

	/** minimal constructor */
	public Tenant(User user, String realName, String idCard,
			String drivingLicence, String drivingType, String phone,
			Boolean isChecked) {
		super(user, realName, idCard, drivingLicence, drivingType, phone,
				isChecked);
	}

	/** full constructor */
	public Tenant(User user, String realName, String idCard,
			String drivingLicence, String drivingType, String phone,
			String idCardFirImg, String idCardSecImg, Boolean isChecked,
			Set orders) {
		super(user, realName, idCard, drivingLicence, drivingType, phone,
				idCardFirImg, idCardSecImg, isChecked, orders);
	}

}
