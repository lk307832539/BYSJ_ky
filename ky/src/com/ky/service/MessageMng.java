package com.ky.service;

import java.util.List;

import com.ky.entity.Admin;
import com.ky.entity.Car;
import com.ky.entity.CarOwner;
import com.ky.entity.Message;
import com.ky.entity.Order;
import com.ky.entity.Tenant;
import com.ky.entity.User;

public abstract interface MessageMng {
	//发送订单申请信息给车主
	public void sendOrderMessage(Car car,User user,Order order);

	public List<Message> getUserMessage(User user);

	public Message getMessageById(Integer messageid);

	public void sendOrderAgree(Order order,User user);

	public void sendOrderDisAgree(Order order,User user);

	public void updateMessageStatus(Message message);

	public void sendOrderFinish(Order order, User tenantuser);

	public void sendCarVerifyPass(Car car,Admin admin);

	public void sendCarVerifyDisPass(Car car, Admin admin);

	public void sendvehicleLicenseVerifyDisPass(Car car, Admin admin);

	public void sendcarOwnerVerifyPass(CarOwner carOwner, Admin admin);

	public void sendcarOwnerDisVerifyPass(CarOwner carOwner, Admin admin);

	public void sendTenantVerifyPass(Tenant tenant, Admin admin);

	public void sendTenantVerifyDisPass(Tenant tenant, Admin admin);

}
