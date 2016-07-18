package com.ky.entity;

import com.ky.entity.base.AbstractAdmin;

/**
 * Admin entity. @author MyEclipse Persistence Tools
 */
public class Admin extends AbstractAdmin implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Admin() {
	}

	/** full constructor */
	public Admin(User user) {
		super(user);
	}

}
