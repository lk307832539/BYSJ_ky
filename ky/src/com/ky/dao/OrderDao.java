package com.ky.dao;

import java.util.List;

import com.ky.entity.Order;

public abstract interface OrderDao {
	public void addNewOrder(Order order);

	public List<Order> getOrderByCarId(Integer carId,Integer status);
	
	public Order getOrderByOrderId(Integer orderid);

	public List<Order> getOrderByTenant(Integer userId);

	public void updateOrder(Order order);

}
