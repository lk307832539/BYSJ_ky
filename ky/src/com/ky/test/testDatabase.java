package com.ky.test;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ky.entity.User;
import com.ky.service.UserMng;

@Controller
public class testDatabase {

	@Resource
	UserMng userMng;

	@RequestMapping(value = "/testDatabase.do")
	public ModelAndView login(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		List<User> user = this.userMng.getAllUser();
		for (User user2 : user) {
			System.out.println(user.get(0).toString());
		}
		System.out.println("进来了");
		return new ModelAndView("success");
	}
}
