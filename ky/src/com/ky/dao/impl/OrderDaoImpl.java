package com.ky.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.ky.dao.OrderDao;
import com.ky.entity.Car;
import com.ky.entity.Order;

@Repository
public class OrderDaoImpl implements OrderDao {

	@Resource
	private SessionFactory sessionfactory;

	@Override
	public void addNewOrder(Order order) {
		this.sessionfactory.getCurrentSession().save(order);
		this.sessionfactory.getCurrentSession().flush();
	}

	@Override
	public List<Order> getOrderByCarId(Integer carId,Integer status) {
		String hql = "from Order o where o.car.carId=? and o.status=?";
		Query query =this.sessionfactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, carId);
		query.setInteger(1, status);
		List<Order> list = new ArrayList<Order>();
		list = query.list();
		return list;
	}

	@Override
	public Order getOrderByOrderId(Integer orderid) {
		String hql ="from Order o where o.orderId=?";
		Query query =this.sessionfactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, orderid);
		return (Order) query.uniqueResult();
	}

	@Override
	public List<Order> getOrderByTenant(Integer userId) {
		String hql = "from Order o where o.tenant.user.userId=? order by o.orderId desc";
		Query query = this.sessionfactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, userId);
		List<Order> list = new ArrayList<Order>();
		list = query.list();
		return list;
	}

	@Override
	public void updateOrder(Order order) {
		this.sessionfactory.getCurrentSession().update(order);
		this.sessionfactory.getCurrentSession().flush();
	}

}
