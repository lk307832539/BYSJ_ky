package com.ky.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.ky.dao.MassageBoardDao;
import com.ky.entity.MassageBoard;

@Repository
public class MassageBoardDaoImpl implements MassageBoardDao {

	@Resource
	private SessionFactory sessionFactory;

	@Override
	public void addMassageBoard(MassageBoard massageBoard) {
		this.sessionFactory.getCurrentSession().save(massageBoard);
		this.sessionFactory.getCurrentSession().flush();
	}

	@Override
	public List<MassageBoard> getCarMassageBoard(Integer carid) {
		String hql = "from MassageBoard mb where mb.car.carId=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, carid);
		List<MassageBoard> list = new ArrayList<MassageBoard>();
		list = query.list();
		return list;
	}

}
