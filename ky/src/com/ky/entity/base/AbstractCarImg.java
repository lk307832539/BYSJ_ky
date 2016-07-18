package com.ky.entity.base;

import org.hibernate.annotations.DynamicUpdate;

import com.ky.entity.Car;

/**
 * AbstractCarImg entity provides the base persistence definition of the CarImg
 * entity. @author MyEclipse Persistence Tools
 */
@DynamicUpdate(true)
public abstract class AbstractCarImg implements java.io.Serializable {

	// Fields

	private Integer carImgId;
	private Car car;
	private String img1;
	private String img2;
	private String img3;
	private String img4;
	private String other;

	// Constructors

	/** default constructor */
	public AbstractCarImg() {
	}

	/** minimal constructor */
	public AbstractCarImg(Car car) {
		this.car = car;
	}

	/** full constructor */
	public AbstractCarImg(Car car, String img1, String img2, String img3,
			String img4, String other) {
		this.car = car;
		this.img1 = img1;
		this.img2 = img2;
		this.img3 = img3;
		this.img4 = img4;
		this.other = other;
	}

	// Property accessors

	public Integer getCarImgId() {
		return this.carImgId;
	}

	public void setCarImgId(Integer carImgId) {
		this.carImgId = carImgId;
	}

	public Car getCar() {
		return this.car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public String getImg1() {
		return this.img1;
	}

	public void setImg1(String img1) {
		this.img1 = img1;
	}

	public String getImg2() {
		return this.img2;
	}

	public void setImg2(String img2) {
		this.img2 = img2;
	}

	public String getImg3() {
		return this.img3;
	}

	public void setImg3(String img3) {
		this.img3 = img3;
	}

	public String getImg4() {
		return this.img4;
	}

	public void setImg4(String img4) {
		this.img4 = img4;
	}

	public String getOther() {
		return this.other;
	}

	public void setOther(String other) {
		this.other = other;
	}

}