package com.ky.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ky.entity.Car;
import com.ky.entity.Order;
import com.ky.entity.User;
import com.ky.service.CarMng;
import com.ky.service.MessageMng;
import com.ky.service.OrderMng;

@Controller
public class OrderHandleAct {
	@Resource
	private OrderMng orderMng;
	@Resource
	private MessageMng messageMng;
	@Resource
	private CarMng carMng;

	@RequestMapping("/OrderAgree.do")
	public String OrderAgree(Integer orderid, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		User user = (User) request.getSession().getAttribute("user");
		// 判断有没有登录
		if (user == null) {
			return "login";
		}
		if (orderid == null) {
			return "member/errorOrder";
		}
		Order order = this.orderMng.getOrderByOrderId(orderid);
		if (order == null) {
			return "member/errorOrder";
		}
		if (order.getStatus() == 0) {
			order.setStatus(1);
			this.orderMng.updateOrder(order);
			this.messageMng.sendOrderAgree(order, user);
			Car car = order.getCar();
			car.setIsSelled(true);
			this.carMng.updateCar(car);
			return "redirect:/member/messageList.do";
		}
		return "member/errorOrder";

	}

	@RequestMapping("/OrderDisAgree.do")
	public String OrderDisAgree(Integer orderid, HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		User user = (User) request.getSession().getAttribute("user");
		// 判断有没有登录
		if (user == null) {
			return "login";
		}
		if (orderid == null) {
			return "member/errorOrder";
		}
		Order order = this.orderMng.getOrderByOrderId(orderid);
		if (order == null) {
			return "member/errorOrder";
		}
		if (order.getStatus() == 0) {
			order.setStatus(2);
			this.orderMng.updateOrder(order);
			this.messageMng.sendOrderDisAgree(order, user);
			return "redirect:/member/messageList.do";
		}
		return "member/errorOrder";
	}

	@RequestMapping(value = "/OrderFinish.do")
	public String OrderFinish(Integer carid, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		User user = (User) request.getSession().getAttribute("user");
		// 判断有没有登录
		if (user == null) {
			return "login";
		}
		Car car = this.carMng.getCar(carid);
		//list取出的order为唯一的值
		List<Order> list = this.orderMng.getOrderByCarId(carid, 1);
		Order order = list.get(0);
		order.setStatus(3);
		this.orderMng.updateOrder(order);
		this.messageMng.sendOrderFinish(order,user);
		car.setIsSelled(false);
		this.carMng.updateCar(car);
		return "member/orderFinish";
	}
}
