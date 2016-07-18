package com.ky.entity.base;

import org.hibernate.annotations.DynamicUpdate;

import com.ky.entity.User;

/**
 * AbstractAdmin entity provides the base persistence definition of the Admin
 * entity. @author MyEclipse Persistence Tools
 */
@DynamicUpdate(true)
public abstract class AbstractAdmin implements java.io.Serializable {

	// Fields

	private Integer adminId;
	private User user;

	// Constructors

	/** default constructor */
	public AbstractAdmin() {
	}

	/** full constructor */
	public AbstractAdmin(User user) {
		this.user = user;
	}

	// Property accessors

	public Integer getAdminId() {
		return this.adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}