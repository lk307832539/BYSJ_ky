package com.ky.entity.base;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.DynamicUpdate;

/**
 * AbstractCarLevel entity provides the base persistence definition of the
 * CarLevel entity. @author MyEclipse Persistence Tools
 */
@DynamicUpdate(true)
public abstract class AbstractCarLevel implements java.io.Serializable {

	// Fields

	private Integer levelId;
	private String levelName;
	private Set cars = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractCarLevel() {
	}

	/** minimal constructor */
	public AbstractCarLevel(String levelName) {
		this.levelName = levelName;
	}

	/** full constructor */
	public AbstractCarLevel(String levelName, Set cars) {
		this.levelName = levelName;
		this.cars = cars;
	}

	// Property accessors

	public Integer getLevelId() {
		return this.levelId;
	}

	public void setLevelId(Integer levelId) {
		this.levelId = levelId;
	}

	public String getLevelName() {
		return this.levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public Set getCars() {
		return this.cars;
	}

	public void setCars(Set cars) {
		this.cars = cars;
	}

}