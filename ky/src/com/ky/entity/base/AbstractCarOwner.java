package com.ky.entity.base;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.DynamicUpdate;

import com.ky.entity.User;

/**
 * AbstractCarOwner entity provides the base persistence definition of the
 * CarOwner entity. @author MyEclipse Persistence Tools
 */
@DynamicUpdate(true)
public abstract class AbstractCarOwner implements java.io.Serializable {

	// Fields

	private Integer ownerId;
	private User user;
	private String realName;
	private String idCard;
	private String phone;
	private String idCardFirImg;
	private String idCardSecImg;
	private Boolean isChecked;
	private Set cars = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractCarOwner() {
	}

	/** minimal constructor */
	public AbstractCarOwner(User user, String realName, String idCard,
			String phone) {
		this.user = user;
		this.realName = realName;
		this.idCard = idCard;
		this.phone = phone;
	}

	/** full constructor */
	public AbstractCarOwner(User user, String realName, String idCard,
			String phone, String idCardFirImg, String idCardSecImg,
			Boolean isChecked, Set cars) {
		this.user = user;
		this.realName = realName;
		this.idCard = idCard;
		this.phone = phone;
		this.idCardFirImg = idCardFirImg;
		this.idCardSecImg = idCardSecImg;
		this.isChecked = isChecked;
		this.cars = cars;
	}

	// Property accessors

	public Integer getOwnerId() {
		return this.ownerId;
	}

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getRealName() {
		return this.realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getIdCard() {
		return this.idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIdCardFirImg() {
		return this.idCardFirImg;
	}

	public void setIdCardFirImg(String idCardFirImg) {
		this.idCardFirImg = idCardFirImg;
	}

	public String getIdCardSecImg() {
		return this.idCardSecImg;
	}

	public void setIdCardSecImg(String idCardSecImg) {
		this.idCardSecImg = idCardSecImg;
	}

	public Boolean getIsChecked() {
		return this.isChecked;
	}

	public void setIsChecked(Boolean isChecked) {
		this.isChecked = isChecked;
	}

	public Set getCars() {
		return this.cars;
	}

	public void setCars(Set cars) {
		this.cars = cars;
	}

}