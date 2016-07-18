package com.ky.entity;

import java.sql.Timestamp;
import java.util.Set;

import com.ky.entity.base.AbstractUser;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
public class User extends AbstractUser implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String userName, String email, String password) {
		super(userName, email, password);
	}

	/** full constructor */
	public User(String userName, String email, String password, String headImg,
			Timestamp registerTime, String registerIp, Timestamp lastLoginTime,
			String lastLoginIp, Integer loginCount, Boolean isAdmin,
			Boolean isTenant, Boolean isOwner, CarOwner carOwner,
			Set massageContents, Set massageBoards, Admin admin, Tenant tenant,
			Set messages) {
		super(userName, email, password, headImg, registerTime, registerIp,
				lastLoginTime, lastLoginIp, loginCount, isAdmin, isTenant,
				isOwner, carOwner, massageContents, massageBoards, admin,
				tenant, messages);
	}

}
