package com.ky.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.ky.dao.TenantDao;
import com.ky.entity.CarOwner;
import com.ky.entity.Tenant;
import com.ky.entity.User;
@Repository
public class TenantDaoImpl implements TenantDao{
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public void addTenant(Tenant tenant) {
		sessionFactory.getCurrentSession().save(tenant);
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public Tenant getTenantByUserId(Integer userId) {
		String hql = "from Tenant t where t.user.userId=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, userId);
		return (Tenant) query.uniqueResult();
	}
	
	@Override
	public List<Tenant> getAllTenant() {
		String hql = "from Tenant";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}
	
	@Override
	public void updateTenant(Tenant tenant) {
		sessionFactory.getCurrentSession().update(tenant);
		sessionFactory.getCurrentSession().flush();
	}

}
