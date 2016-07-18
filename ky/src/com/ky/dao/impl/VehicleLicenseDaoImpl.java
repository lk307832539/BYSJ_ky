package com.ky.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.ky.dao.VehicleLicenseDao;
import com.ky.entity.VehicleLicense;

@Repository
public  class VehicleLicenseDaoImpl implements VehicleLicenseDao{
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public VehicleLicense getVehicleLicenseByCarId(Integer carid) {
		String hql = "from VehicleLicense vl where vl.car.carId=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, carid);
		return (VehicleLicense) query.uniqueResult();
	}

	@Override
	public void saveOrUpdate(VehicleLicense vehicleLicense) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(vehicleLicense);
		this.sessionFactory.getCurrentSession().flush();
	}

}
