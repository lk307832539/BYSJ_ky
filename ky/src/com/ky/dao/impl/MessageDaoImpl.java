package com.ky.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.ky.dao.MessageDao;
import com.ky.entity.Message;

@Repository
public class MessageDaoImpl implements MessageDao {
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public void addMessage(Message message) {
		this.sessionFactory.getCurrentSession().save(message);
		this.sessionFactory.getCurrentSession().flush();
	}

	@Override
	public Message getMessageById(Integer messageId) {
		String hql = "from Message m where m.messageId=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, messageId);
		return (Message) query.uniqueResult();
	}

	@Override
	public List<Message> getUserMessage(Integer receiverId) {
		String hql = "from Message m where m.user.userId=? ORDER BY m.massageContents.postDate DESC";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, receiverId);
		List<Message> list = new ArrayList<Message>();
		list = query.list();
		return list;
	}

	@Override
	public void updateMessageStatue(Message message) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(message);
		this.sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void delMessage(Integer messageId) {
		String hql = "delete Message m where m.messageId=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, messageId);
	}

}
