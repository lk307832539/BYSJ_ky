package com.ky.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ky.entity.Car;
import com.ky.entity.Order;
import com.ky.entity.Tenant;
import com.ky.entity.User;
import com.ky.service.CarMng;
import com.ky.service.MessageMng;
import com.ky.service.OrderMng;
import com.ky.service.TenantMng;
import com.ky.until.MakeCode;

@Controller
@SessionAttributes("user")
public class ReserveCarAct {

	@Resource
	private CarMng carMng;

	@Resource
	private OrderMng orderMng;

	@Resource
	private TenantMng tenantMng;

	@Resource
	private MessageMng messageMng;

	@RequestMapping(value = "/reserveCarAct.do")
	public String reserveCarAct(Integer carId, HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		User user = (User) request.getSession().getAttribute("user");
		// 判断有没有登录
		if (user == null) {
			return "login";
		}
		// 判断是否已经注册为租客
		if (user.getIsTenant() != true) {
			return "member/beTenant";
		}
		// 生成通知订单
		Car car = this.carMng.getCar(carId);
		if(car.getIsSelled()==true){
			return "orderFail";
		}
		Tenant tenant = this.tenantMng.getTenantByUserId(user.getUserId());
		// 查找该车订单状态为0的订单
		List<Order> list = this.orderMng.getOrderByCarId(carId, 0);
		// 判断订单是否已经重复请求,防止重复生成订单

		for (Order order : list) {
			if (order.getTenant().getTenantId().equals(tenant.getTenantId())
					&& order.getTenant().getTenantId() == tenant.getTenantId()) {
				return "orderSuccess";
			}
		}

		// 新建订单
		Order order = new Order();
		order.setCar(car);
		order.setRentalPrice(car.getPrice());
		order.setCode(MakeCode.makeCode(user));
		order.setStatus(0);
		order.setTenant(tenant);
		this.orderMng.addOrder(order);
		this.messageMng.sendOrderMessage(car, user, order);
		return "orderSuccess";

	}

}
