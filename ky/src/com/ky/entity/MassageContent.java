package com.ky.entity;

import java.sql.Timestamp;

import com.ky.entity.base.AbstractMassageContent;

/**
 * MassageContent entity. @author MyEclipse Persistence Tools
 */
public class MassageContent extends AbstractMassageContent implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public MassageContent() {
	}

	/** minimal constructor */
	public MassageContent(User user, Message message) {
		super(user, message);
	}

	/** full constructor */
	public MassageContent(User user, Message message, String type,
			String massageContent, Timestamp postDate) {
		super(user, message, type, massageContent, postDate);
	}

}
