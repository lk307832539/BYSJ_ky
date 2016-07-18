package com.ky.dao;

import java.util.List;

import com.ky.entity.Message;

public abstract interface MessageDao {
	public void addMessage(Message message);
	
	public Message getMessageById(Integer messageId);
	
	public List<Message> getUserMessage(Integer receiverId);
	
	public void updateMessageStatue(Message message);
	
	public void delMessage(Integer messageId);
	
}
