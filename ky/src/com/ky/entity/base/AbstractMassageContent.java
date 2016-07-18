package com.ky.entity.base;

import java.sql.Timestamp;

import org.hibernate.annotations.DynamicUpdate;

import com.ky.entity.Message;
import com.ky.entity.User;

/**
 * AbstractMassageContent entity provides the base persistence definition of the
 * MassageContent entity. @author MyEclipse Persistence Tools
 */
@DynamicUpdate(true)
public abstract class AbstractMassageContent implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;
	private Message message;
	private String type;
	private String massageContent;
	private Timestamp postDate;

	// Constructors

	/** default constructor */
	public AbstractMassageContent() {
	}

	/** minimal constructor */
	public AbstractMassageContent(User user, Message message) {
		this.user = user;
		this.message = message;
	}

	/** full constructor */
	public AbstractMassageContent(User user, Message message, String type,
			String massageContent, Timestamp postDate) {
		this.user = user;
		this.message = message;
		this.type = type;
		this.massageContent = massageContent;
		this.postDate = postDate;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Message getMessage() {
		return this.message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMassageContent() {
		return this.massageContent;
	}

	public void setMassageContent(String massageContent) {
		this.massageContent = massageContent;
	}

	public Timestamp getPostDate() {
		return this.postDate;
	}

	public void setPostDate(Timestamp postDate) {
		this.postDate = postDate;
	}

}