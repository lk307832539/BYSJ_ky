package com.ky.entity.base;

import java.sql.Timestamp;

import org.hibernate.annotations.DynamicUpdate;

import com.ky.entity.Car;
import com.ky.entity.User;

/**
 * AbstractMassageBoard entity provides the base persistence definition of the
 * MassageBoard entity. @author MyEclipse Persistence Tools
 */
@DynamicUpdate(true)
public abstract class AbstractMassageBoard implements java.io.Serializable {

	// Fields

	private Integer massageBoardId;
	private User user;
	private Car car;
	private String content;
	private Timestamp sendTime;

	// Constructors

	/** default constructor */
	public AbstractMassageBoard() {
	}

	/** minimal constructor */
	public AbstractMassageBoard(User user, Car car, Timestamp sendTime) {
		this.user = user;
		this.car = car;
		this.sendTime = sendTime;
	}

	/** full constructor */
	public AbstractMassageBoard(User user, Car car, String content,
			Timestamp sendTime) {
		this.user = user;
		this.car = car;
		this.content = content;
		this.sendTime = sendTime;
	}

	// Property accessors

	public Integer getMassageBoardId() {
		return this.massageBoardId;
	}

	public void setMassageBoardId(Integer massageBoardId) {
		this.massageBoardId = massageBoardId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Car getCar() {
		return this.car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getSendTime() {
		return this.sendTime;
	}

	public void setSendTime(Timestamp sendTime) {
		this.sendTime = sendTime;
	}

}