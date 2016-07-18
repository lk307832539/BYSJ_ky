package com.ky.action;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ky.entity.Car;
import com.ky.entity.MassageBoard;
import com.ky.entity.Order;
import com.ky.entity.User;
import com.ky.service.CarMng;
import com.ky.service.MassageBoardMng;
import com.ky.service.OrderMng;
import com.ky.until.TimestampFormat;

@Controller
public class MassageBoardAct {
	@Resource
	private CarMng carMng;
	@Resource
	private OrderMng orderMng;
	@Resource
	private MassageBoardMng massageBoardMng;

	@RequestMapping("/apprisePage.do")
	public String apprisePage(Integer orderid, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return "login";
		}
		Order order = this.orderMng.getOrderByOrderId(orderid);
		if (order.getStatus() == 3) {
			model.addAttribute(order);
			return "member/apprisePage";
		}
		return "member/errorOrder";
	}

	@RequestMapping("/appriseCar.do")
	public String appriseCar(Integer orderid, String apprise, HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return "login";
		}
		Order order = this.orderMng.getOrderByOrderId(orderid);
		if (order.getStatus() == 3) {
			Car car = order.getCar();
			MassageBoard massageBoard = new MassageBoard();
			massageBoard.setCar(car);
			massageBoard.setContent(apprise);
			massageBoard.setUser(user);
			massageBoard.setSendTime(TimestampFormat.TimestampToDate(new Date()));
			this.massageBoardMng.addMassageBoard(massageBoard);
			order.setStatus(4);
			this.orderMng.updateOrder(order);
			return "member/appriseSuccess";
		}
		return "errorOrder";
	}

}
