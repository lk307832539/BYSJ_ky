package com.ky.dao.impl;

import java.util.List;



import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.ky.dao.UserDao;
import com.ky.entity.CarOwner;
import com.ky.entity.User;
@Repository
public class UserDaoImpl implements UserDao{
	@Resource
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void addUser(User user) {
		sessionFactory.getCurrentSession().save(user);
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public List<User> getAllUser() {
		String hql = "from User";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		return query.list();
	}

	@Override
	public boolean delUser(Integer id) {
		String hql = "delete User u where u.userId=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		return (query.executeUpdate() > 0);
	}

	@Override
	public User getUser(Integer id) {
		String hql = "from User u where u.userId=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		return (User) query.uniqueResult();
	}

	@Override
	public void updateUser(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public User getUserByUserName(String userName) {
		String hql = "from User u where u.userName=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, userName);
		return (User) query.uniqueResult();
	}

	@Override
	public User getUser(String userName, String password) {
		String hql = " from User u where u.userName=? and u.password=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, userName);
		query.setString(1, password);
		return (User) query.uniqueResult();
	}

}
