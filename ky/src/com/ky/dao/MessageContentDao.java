package com.ky.dao;


import com.ky.entity.MassageContent;


public abstract interface MessageContentDao {
	
	public void addMessageContent(MassageContent messageContent);

	public MassageContent getMessageContentById(Integer messageId);

	public void delMessageContent(Integer messageId);
}
