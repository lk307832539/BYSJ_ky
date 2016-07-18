package com.ky.entity.base;

import java.sql.Timestamp;

import org.hibernate.annotations.DynamicUpdate;

import com.ky.entity.Car;
import com.ky.entity.Tenant;

/**
 * AbstractOrder entity provides the base persistence definition of the Order
 * entity. @author MyEclipse Persistence Tools
 */
@DynamicUpdate(true)
public abstract class AbstractOrder implements java.io.Serializable {

	// Fields

	private Integer orderId;
	private Car car;
	private Tenant tenant;
	private String code;
	private Double rentalPrice;
	private Integer status;
	private Timestamp startTime;
	private Timestamp endTime;

	// Constructors

	/** default constructor */
	public AbstractOrder() {
	}

	/** full constructor */
	public AbstractOrder(Car car, Tenant tenant, String code,
			Double rentalPrice, Integer status, Timestamp startTime,
			Timestamp endTime) {
		this.car = car;
		this.tenant = tenant;
		this.code = code;
		this.rentalPrice = rentalPrice;
		this.status = status;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	// Property accessors

	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Car getCar() {
		return this.car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Tenant getTenant() {
		return this.tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Double getRentalPrice() {
		return this.rentalPrice;
	}

	public void setRentalPrice(Double rentalPrice) {
		this.rentalPrice = rentalPrice;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Timestamp getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

}