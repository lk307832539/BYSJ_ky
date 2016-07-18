package com.ky.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.ky.dao.MessageContentDao;
import com.ky.entity.MassageContent;

@Repository
public class MessageContentDaoImpl implements MessageContentDao {
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public void addMessageContent(MassageContent messageContent) {
		this.sessionFactory.getCurrentSession().save(messageContent);
	}

	@Override
	public MassageContent getMessageContentById(Integer messageId) {
		String hql = "from MassageContent mc where mc.message.messageId=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, messageId);
		return (MassageContent) query.uniqueResult();
	}

	@Override
	public void delMessageContent(Integer messageId) {
		String hql = "delete MassageContent mc where mc.message.messageId=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, messageId);
	}
}
