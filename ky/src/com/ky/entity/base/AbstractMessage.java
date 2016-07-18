package com.ky.entity.base;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.DynamicUpdate;

import com.ky.entity.MassageContent;
import com.ky.entity.User;

/**
 * AbstractMessage entity provides the base persistence definition of the
 * Message entity. @author MyEclipse Persistence Tools
 */
@DynamicUpdate(true)
public abstract class AbstractMessage implements java.io.Serializable {

	// Fields

	private Integer messageId;
	private User user;
	private Integer statue;
	private MassageContent massageContents;

	// Constructors

	/** default constructor */
	public AbstractMessage() {
	}

	/** minimal constructor */
	public AbstractMessage(User user, Integer statue) {
		this.user = user;
		this.statue = statue;
	}

	/** full constructor */
	public AbstractMessage(User user, Integer statue, MassageContent massageContents) {
		this.user = user;
		this.statue = statue;
		this.massageContents = massageContents;
	}

	// Property accessors

	public Integer getMessageId() {
		return this.messageId;
	}

	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getStatue() {
		return this.statue;
	}

	public void setStatue(Integer statue) {
		this.statue = statue;
	}

	public MassageContent getMassageContents() {
		return this.massageContents;
	}

	public void setMassageContents(MassageContent massageContents) {
		this.massageContents = massageContents;
	}

}