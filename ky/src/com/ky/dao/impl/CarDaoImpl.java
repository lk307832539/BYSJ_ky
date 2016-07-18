package com.ky.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.ky.dao.CarDao;
import com.ky.entity.Car;
import com.ky.entity.User;

@Repository
public class CarDaoImpl implements CarDao {

	@Resource
	private SessionFactory sessionFactory;

	@Override
	public void addCar(Car car) {
		this.sessionFactory.getCurrentSession().save(car);
		this.sessionFactory.getCurrentSession().flush();
	}

	@Override
	public List<Car> getAllCar() {
		String hql = "from Car ";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		List<Car> list = new ArrayList<Car>();
		list = query.list();
		return list;
	}

	@Override
	public List<Car> getAllCar(Integer userid) {
		String hql = "from Car c where c.carOwner.user.userId=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, userid);
		List<Car> list = new ArrayList<Car>();
		list = query.list();
		return list;
	}

	@Override
	public List<Car> getAllCar(Integer brandId, Integer seriesId, Integer levelId, Integer minPrice, Integer maxPrice,
			boolean GPS, boolean DVD) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delCar(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Car getCar(Integer carid) {
		String hql = "from Car c where c.carId=? ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, carid);
		return (Car) query.uniqueResult();
	}

	@Override
	public boolean updateCar(Car car) {
		this.sessionFactory.getCurrentSession().update(car);
		this.sessionFactory.getCurrentSession().flush();
		return true;
	}

	@Override
	public List<Car> getAllCarNoSelle() {
		String hql = "from Car c where c.isSelled=false";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		List<Car> list = new ArrayList<Car>();
		list = query.list();
		return list;
	}

	@Override
	public List<Car> getCarBySearch(Double minprice, Double maxprice, Integer gearbox, Integer displacement,
			boolean gps, boolean dvd) {
		String sql = "SELECT * FROM car c where c.is_selled = FALSE ";
		if (minprice != null) {
			sql = sql + "and c.price>= :minprice ";
		}
		if (maxprice != null) {
			sql = sql + "and c.price < :maxprice ";
		}
		if (gearbox != null && gearbox != 0) {
			sql = sql + "and c.gearbox = :gearbox ";
		}
		if (displacement != null) {
			if (displacement == 1) {
				sql = sql + "and c.displacement < 1600 ";
			} else if (displacement == 2) {
				sql = sql + "and c.displacement >= 1600 and c.displacement <2100 ";
			} else if (displacement == 3) {
				sql = sql + "and c.displacement >= 2100 and c.displacement <2400 ";
			} else if (displacement == 4) {
				sql = sql + "and c.displacement > 2400 ";
			}
		}
		if (gps != false) {
			sql = sql + "and c.GPS = TRUE ";
		}
		if (dvd != false) {
			sql = sql + "and c.DVD = TRUE ";
		}
		Query query = this.sessionFactory.getCurrentSession().createSQLQuery(sql);
		if (minprice != null) {
			query.setParameter("minprice", minprice);
		}
		if (maxprice != null) {
			query.setParameter("maxprice", maxprice);
		}
		if (gearbox != null && gearbox != 0) {
			query.setParameter("gearbox", gearbox);
		}
		List<Object[]> entity = query.list();
		List<Car> list = new ArrayList<Car>();
		for (Object[] o : entity) {
			Car car = new Car();
			car.setCarId((Integer) o[0]);
			list.add(car);
		}
		return list;
	}

}
