package com.ky.entity.base;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.DynamicUpdate;

import com.ky.entity.User;

/**
 * AbstractTenant entity provides the base persistence definition of the Tenant
 * entity. @author MyEclipse Persistence Tools
 */
@DynamicUpdate(true)
public abstract class AbstractTenant implements java.io.Serializable {

	// Fields

	private Integer tenantId;
	private User user;
	private String realName;
	private String idCard;
	private String drivingLicence;
	private String drivingType;
	private String phone;
	private String idCardFirImg;
	private String idCardSecImg;
	private Boolean isChecked;
	private Set orders = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractTenant() {
	}

	/** minimal constructor */
	public AbstractTenant(User user, String realName, String idCard,
			String drivingLicence, String drivingType, String phone,
			Boolean isChecked) {
		this.user = user;
		this.realName = realName;
		this.idCard = idCard;
		this.drivingLicence = drivingLicence;
		this.drivingType = drivingType;
		this.phone = phone;
		this.isChecked = isChecked;
	}

	/** full constructor */
	public AbstractTenant(User user, String realName, String idCard,
			String drivingLicence, String drivingType, String phone,
			String idCardFirImg, String idCardSecImg, Boolean isChecked,
			Set orders) {
		this.user = user;
		this.realName = realName;
		this.idCard = idCard;
		this.drivingLicence = drivingLicence;
		this.drivingType = drivingType;
		this.phone = phone;
		this.idCardFirImg = idCardFirImg;
		this.idCardSecImg = idCardSecImg;
		this.isChecked = isChecked;
		this.orders = orders;
	}

	// Property accessors

	public Integer getTenantId() {
		return this.tenantId;
	}

	public void setTenantId(Integer tenantId) {
		this.tenantId = tenantId;
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

	public String getDrivingLicence() {
		return this.drivingLicence;
	}

	public void setDrivingLicence(String drivingLicence) {
		this.drivingLicence = drivingLicence;
	}

	public String getDrivingType() {
		return this.drivingType;
	}

	public void setDrivingType(String drivingType) {
		this.drivingType = drivingType;
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

	public Set getOrders() {
		return this.orders;
	}

	public void setOrders(Set orders) {
		this.orders = orders;
	}

}