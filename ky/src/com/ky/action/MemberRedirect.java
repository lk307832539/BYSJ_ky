package com.ky.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ky.entity.Car;
import com.ky.entity.CarOwner;
import com.ky.entity.Message;
import com.ky.entity.Order;
import com.ky.entity.Tenant;
import com.ky.entity.User;
import com.ky.service.CarMng;
import com.ky.service.CarOwnerMng;
import com.ky.service.MessageMng;
import com.ky.service.OrderMng;
import com.ky.service.TenantMng;
import com.ky.service.UserMng;
import com.ky.until.UploadFile;

@Controller
@RequestMapping("/member")
public class MemberRedirect {
	@Resource
	private MessageMng messageMng;
	@Resource
	private CarMng carMng;
	@Resource
	private OrderMng orderMng;
	@Resource
	private CarOwnerMng carOwnerMng;
	@Resource
	private UserMng userMng;
	@Resource
	private TenantMng tenantMng;

	// 个人中心入口,跳转到个人中心
	@RequestMapping("/dashBoard.do")
	public String dashBoard(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return "login";
		}
		model.addAttribute(user);
		return "/member/dashBoard";
	}

	// 消息（message）查看页面
	@RequestMapping("/messageList.do")
	public String messageList(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return "login";
		}
		List<Message> meslist = this.messageMng.getUserMessage(user);
		model.addAttribute("meslist", meslist);
		model.addAttribute(user);

		return "/member/message";
	}

	// 消息详情页面
	@RequestMapping("/messageDetail.do")
	public String messageList(Integer messageid, HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return "login";
		}
		Message message = this.messageMng.getMessageById(messageid);
		message.setStatue(1);
		this.messageMng.updateMessageStatus(message);
		model.addAttribute("message", message);
		model.addAttribute(user);
		return "/member/messageDetail";
	}

	// 用户管理 车主管理
	@RequestMapping("/carOwnerList.do")
	public String carOwnerList(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null || user.getIsAdmin() == false) {
			return "login";
		}
		List<CarOwner> carOwnerList = this.carOwnerMng.getAllCarOwner();
		model.addAttribute("carOwnerList", carOwnerList);
		return "/member/carOwnerManage";
	}

	// 用户管理 车主详细查看
	@RequestMapping("/carOwnerDetail.do")
	public String carOwnerDetail(Integer ownerid, HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null || user.getIsAdmin() == false) {
			return "login";
		}
		CarOwner carOwne = this.carOwnerMng.getCarOwnerById(ownerid);
		model.addAttribute("carOwne", carOwne);
		return "/member/carOwnerDetail";
	}

	// 用户管理租客管理
	@RequestMapping("/carTenantList.do")
	public String carTenantList(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null || user.getIsAdmin() == false) {
			return "login";
		}
		List<Tenant> carTenantList = this.tenantMng.getAllTenant();
		model.addAttribute("carTenantList", carTenantList);
		return "/member/tenantManage";
	}

	// 用户管理租客详细查看
	@RequestMapping("/carTenantDetail.do")
	public String carTenantDetail(Integer tenantid, HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null || user.getIsAdmin() == false) {
			return "login";
		}
		Tenant tenant = this.tenantMng.getTenantByUserId(tenantid);
		model.addAttribute("tenant", tenant);
		return "/member/tenantDetail";
	}

	// 车主信息查看页面
	@RequestMapping("/ownerCarManage.do")
	public String ownerCarManage(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return "login";
		}
		List<Car> list;
		// 如果是管理员获取所有的汽车信息
		if (user.getIsAdmin() == true) {
			list = this.carMng.getAllCar();
		} else {
			list = this.carMng.getAllCar(user.getUserId());
		}
		model.addAttribute("list", list);
		model.addAttribute(user);
		return "/member/ownerCarManage";
	}

	// 租客查看订单页面
	@RequestMapping("/tenantCarManage.do")
	public String tenantCarManage(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return "login";
		}
		List<Order> list = this.orderMng.getOrderByTenant(user.getUserId());
		model.addAttribute("list", list);
		model.addAttribute(user);
		return "/member/tenantCarManage";
	}

	// 成为车主
	@RequestMapping(value = "/beCarOwnerAct.do")
	public String beCarOwnerAct(String realname, String idcard, String phone,
			@RequestParam(value = "file1", required = false) MultipartFile file1,
			@RequestParam(value = "file2", required = false) MultipartFile file2, HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		User user = (User) request.getSession().getAttribute("user");
		// 判断有没有登录
		if (user == null) {
			return "login";
		}
		String path = request.getSession().getServletContext().getRealPath("/upload/member");
		UploadFile uf = new UploadFile();
		String path2 = "";
		String path3 = "";
		String type = "carowner_idcarfir";
		if (file1 != null) {
			path2 = uf.uploadFile(file1, user, path, type);
			path2 = "upload/member/" + path2;
		}
		String type1 = "carowner_idcardsec";
		if (file2 != null) {
			path3 = uf.uploadFile(file2, user, path, type1);
			path3 = "upload/member/" + path3;
		}
		// 判断是否已经注册为车主
		if (user.getIsOwner() != true) {
			CarOwner owner = new CarOwner();
			owner.setUser(user);
			owner.setRealName(realname);
			owner.setIdCard(idcard);
			owner.setPhone(phone);
			owner.setIdCardFirImg(path2);
			owner.setIdCardSecImg(path3);
			owner.setIsChecked(false);
			this.carOwnerMng.addOwner(owner);
			user.setIsOwner(true);
			this.userMng.updateUser(user);
		}
		String massage = "注册租客成功，请重新登录";
		model.addAttribute("massage", massage);
		return "redirect:/logingoto.do";
	}

	// 成为租客
	@RequestMapping(value = "/beTenantAct.do")
	public String beTenantAct(String realname, String idcard, String drivinglicence, String drivingtype, String phone,
			@RequestParam(value = "file1", required = false) MultipartFile file1,
			@RequestParam(value = "file2", required = false) MultipartFile file2, HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		User user = (User) request.getSession().getAttribute("user");
		// 判断有没有登录
		if (user == null) {
			return "login";
		}
		String path = request.getSession().getServletContext().getRealPath("/upload/member");
		UploadFile uf = new UploadFile();
		String path2 = "";
		String path3 = "";
		String type = "carowner_idcarfir";
		if (file1 != null) {
			path2 = uf.uploadFile(file1, user, path, type);
			path2 = "upload/member/" + path2;
		}
		String type1 = "carowner_idcardsec";
		if (file2 != null) {
			path3 = uf.uploadFile(file2, user, path, type1);
			path3 = "upload/member/" + path3;
		}
		// 判断是否已经注册为租客
		if (user.getIsTenant() != true) {
			Tenant tenant = new Tenant();
			tenant.setUser(user);
			tenant.setRealName(realname);
			tenant.setIdCard(idcard);
			tenant.setDrivingLicence(drivinglicence);
			tenant.setDrivingType(drivingtype);
			tenant.setPhone(phone);
			tenant.setIdCardFirImg(path2);
			tenant.setIdCardSecImg(path3);
			tenant.setIsChecked(false);
			this.tenantMng.addTenant(tenant);
			user.setIsTenant(true);
			this.userMng.updateUser(user);
		}
		String massage = "注册租客成功，请重新登录";
		model.addAttribute("massage", massage);
		return "redirect:/logingoto.do";
	}
}
