package com.ky.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ky.entity.Car;
import com.ky.entity.MassageBoard;
import com.ky.entity.User;
import com.ky.service.CarMng;
import com.ky.service.MassageBoardMng;

@Controller
public class PageRedirect {
	@Resource
	private CarMng carMng;
	@Resource
	private MassageBoardMng massageBoardMng;

	// 跳转到主页
	@RequestMapping("/indexRedirect.do")
	public String indexRedirect(HttpServletRequest request, HttpServletResponse response) {
		return "index";
	}

	// 跳转到租车页面
	@RequestMapping("/carPandectRedirect.do")
	public String carPandectRedirect(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		List<Car> carlist = this.carMng.getAllCarNoSelle();
		model.addAttribute("carlist", carlist);
		return "carPandect";
	}

	@RequestMapping("/single.do")
	public String single(Integer carid, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		Car car = this.carMng.getCar(carid);
		List<MassageBoard> massageBoardList = this.massageBoardMng.getCarMassageBoard(carid);
		model.addAttribute("car", car);
		model.addAttribute("massageBoardList", massageBoardList);
		return "single";
	}

	@RequestMapping("/beOwner.do")
	public String beOwner(HttpServletRequest request, HttpServletResponse response) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return "login";
		}
		if (user.getIsOwner() == true) {
			return "redirect:/member/dashBoard.do";
		}
		return "member/beOwner";
	}

	@RequestMapping("/beTenant.do")
	public String beTenant(HttpServletRequest request, HttpServletResponse response) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return "login";
		}
		if (user.getIsTenant() == true) {
			return "redirect:/member/dashBoard.do";
		}
		return "member/beTenant";
	}

}
