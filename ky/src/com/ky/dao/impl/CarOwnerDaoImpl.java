package com.ky.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.ky.dao.CarOwnerDao;
import com.ky.entity.CarOwner;

@Repository
public class CarOwnerDaoImpl implements CarOwnerDao {
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public void addOwner(CarOwner carowner) {
		sessionFactory.getCurrentSession().save(carowner);
		this.sessionFactory.getCurrentSession().flush();
	}
	@Override
	public List<CarOwner> getAllCarOwner() {
		String hql = "from CarOwner";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		return query.list();
	}
	@Override
	public CarOwner getCarOwnerById(Integer ownerid) {
		String hql = "from CarOwner co where co.ownerId=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, ownerid);
		return (CarOwner) query.uniqueResult();
	}
	@Override
	public void updateOwner(CarOwner carOwner) {
		this.sessionFactory.getCurrentSession().update(carOwner);
		this.sessionFactory.getCurrentSession().flush();
	}

}
