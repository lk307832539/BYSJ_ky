package com.ky.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.ky.dao.CarSeriesDao;
import com.ky.entity.CarSeries;

@Repository
public class CarSeriesDaoImpl implements CarSeriesDao{
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public List<CarSeries> getCarSeriesByBrandId(Integer brandid) {
		String hql = "from CarSeries cs where cs.carBrand.brandId=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, brandid);
		List<CarSeries> list = query.list();
		return list;
	}

	@Override
	public CarSeries getCarSeriesById(Integer seriesid) {
		String hql = "from CarSeries cs where cs.seriesId=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, seriesid);
		return (CarSeries) query.uniqueResult();
	}

}
