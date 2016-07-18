package com.ky.service;

import java.util.List;

import com.ky.entity.Car;
import com.ky.entity.Order;

public abstract interface OrderMng {
	//新建订单
	public abstract Order addOrder(Order order);

	//根据carid查找订单状态为0的订单
	public abstract List<Order> getOrderByCarId(Integer carId,Integer status);
	
	public Order getOrderByOrderId(Integer orderid);

	public abstract List<Order> getOrderByTenant(Integer userId);

	public abstract void updateOrder(Order order);
}
