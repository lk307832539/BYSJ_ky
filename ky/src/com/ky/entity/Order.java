package com.ky.entity;

import java.sql.Timestamp;

import com.ky.entity.base.AbstractOrder;

/**
 * Order entity. @author MyEclipse Persistence Tools
 */
public class Order extends AbstractOrder implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Order() {
	}

	/** full constructor */
	public Order(Car car, Tenant tenant, String code, Double rentalPrice,
			Integer status, Timestamp startTime, Timestamp endTime) {
		super(car, tenant, code, rentalPrice, status, startTime, endTime);
	}

}
