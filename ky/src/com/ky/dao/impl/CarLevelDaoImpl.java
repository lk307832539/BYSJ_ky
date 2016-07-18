package com.ky.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.ky.dao.CarLevelDao;
import com.ky.entity.CarLevel;

@Repository
public class CarLevelDaoImpl implements CarLevelDao{
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public List<CarLevel> getAllCarLevel() {
		String hql = "from CarLevel";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		List<CarLevel> list = query.list();
		return list;
	}

	@Override
	public CarLevel getCarLevelById(Integer levelid) {
		String hql = "from CarLevel cl where cl.levelId=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, levelid);
		return (CarLevel) query.uniqueResult();
	}

}
