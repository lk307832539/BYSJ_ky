package com.ky.action;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.ky.entity.User;
import com.ky.service.UserMng;
import com.ky.until.TimestampFormat;

@Controller
@SessionAttributes("user")
// 将user的值存到session中
public class LoginAct {

	@Resource
	private UserMng userMng;

	@RequestMapping(value = "/logingoto.do")
	public String login(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		return "login";
	}

	@RequestMapping(value = "/login.do")
	public String login(String username, String password, HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		User user = this.userMng.getUser(username, password);
		String massage = null;
		if (user != null) {
			model.addAttribute(user);
			return "index";
		}
		massage = "友情提示：用户名密码错误";
		model.addAttribute("massage", massage);
		return "login";
	}

	@RequestMapping(value = "/simpleRegist.do")
	public String simpleRegist(String username, String email, String password, String repassword,
			HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		String massage = null;
		User user;
		if (username != null) {
			user = this.userMng.getUserByName(username);
			if (user != null) {
				massage = "友情提示：用户名已经被注册，请重新输入";
			}
		}
		if (password.toString() != repassword.toString() && (!password.equals(repassword))) {
			massage = "友情提示：两次输入的密码不同，请重新输入";
		} else {
			Date time = new Date();
			user = new User();
			user.setUserName(username);
			user.setEmail(email);
			user.setPassword(password);
			user.setLoginCount(0);
			user.setIsAdmin(false);
			user.setIsOwner(false);
			user.setIsTenant(false);
			user.setRegisterTime(TimestampFormat.TimestampToDate(time));
			this.userMng.addUser(user);
			massage = "友情提示：注册成功，请登录";
		}
		model.addAttribute("massage", massage);
		return "login";
	}

	@RequestMapping(value = "/loginout.do")
	public String loginOut(SessionStatus sessionStatus, HttpSession session) {
		sessionStatus.setComplete();// 将所有的会话注销
		session.removeAttribute("user");
		return "index";
	}
}
