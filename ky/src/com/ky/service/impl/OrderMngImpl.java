package com.ky.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ky.dao.OrderDao;
import com.ky.entity.Order;
import com.ky.service.OrderMng;

@Service
public class OrderMngImpl implements OrderMng{

	@Resource
	private OrderDao orderDao;
	
	@Override
	public Order addOrder(Order order) {
		this.orderDao.addNewOrder(order);
		return null;
	}

	@Override
	public List<Order> getOrderByCarId(Integer carId,Integer status) {
		List<Order> list = this.orderDao.getOrderByCarId(carId,status);
		return list;
	}

	@Override
	public Order getOrderByOrderId(Integer orderid) {
		Order order = this.orderDao.getOrderByOrderId(orderid);
		return order;
	}

	@Override
	public List<Order> getOrderByTenant(Integer userId) {
		List<Order> list = this.orderDao.getOrderByTenant(userId);
		return list;
	}

	@Override
	public void updateOrder(Order order) {
		this.orderDao.updateOrder(order);
	}

}
