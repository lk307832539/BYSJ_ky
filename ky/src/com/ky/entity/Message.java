package com.ky.entity;

import java.util.Set;

import com.ky.entity.base.AbstractMessage;

/**
 * Message entity. @author MyEclipse Persistence Tools
 */
public class Message extends AbstractMessage implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Message() {
	}

	/** minimal constructor */
	public Message(User user, Integer statue) {
		super(user, statue);
	}

	/** full constructor */
	public Message(User user, Integer statue, MassageContent massageContents) {
		super(user, statue, massageContents);
	}

}
