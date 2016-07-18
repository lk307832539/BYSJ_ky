package com.ky.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.ky.dao.CarBrandDao;
import com.ky.entity.CarBrand;

@Repository
public class CarBrandDaoImpl implements CarBrandDao{
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public List<CarBrand> getAllBrand() {
		String hql = "from CarBrand";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		List<CarBrand> list = query.list();
		return list;
	}

	@Override
	public CarBrand getCarBrandById(Integer brandid) {
		String hql = "from CarBrand cb where cb.brandId=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, brandid);
		return (CarBrand) query.uniqueResult();
	}

}
