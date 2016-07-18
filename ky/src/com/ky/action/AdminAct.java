package com.ky.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ky.entity.Car;
import com.ky.entity.CarBrand;
import com.ky.entity.CarLevel;
import com.ky.entity.CarOwner;
import com.ky.entity.Tenant;
import com.ky.entity.User;
import com.ky.entity.VehicleLicense;
import com.ky.service.CarBrandMng;
import com.ky.service.CarLevelMng;
import com.ky.service.CarMng;
import com.ky.service.CarOwnerMng;
import com.ky.service.CarSeriesMng;
import com.ky.service.MessageMng;
import com.ky.service.TenantMng;
import com.ky.service.VehicleLicenseMng;

@Controller
public class AdminAct {
	@Resource
	private CarMng carMng;
	@Resource
	private VehicleLicenseMng vehicleLicenseMng;
	@Resource
	private MessageMng messageMng;
	@Resource
	private CarOwnerMng carOwnerMng;
	@Resource
	private TenantMng tenantMng;

	// 车辆审核通过
	@RequestMapping("/carVerifyPass.do")
	public String carVerifyPass(Integer carid, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return "login";
		}
		Car car = this.carMng.getCar(carid);
		car.setIsChecked(true);
		this.carMng.updateCar(car);
		this.messageMng.sendCarVerifyPass(car, user.getAdmin());
		return "/member/verifyPass";
	}

	// 车辆审核不通过
	@RequestMapping("/carVerifyDisPass.do")
	public String carVerifyDisPass(Integer carid, HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return "login";
		}
		Car car = this.carMng.getCar(carid);
		this.messageMng.sendCarVerifyDisPass(car, user.getAdmin());
		return "/member/verifyPass";
	}

	// 行驶证审核通过
	@RequestMapping("/vehicleLicenseVerifyPass.do")
	public String vehicleLicenseVerifyPass(Integer carid, HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return "login";
		}
		Car car = this.carMng.getCar(carid);
		VehicleLicense vehicleLicense = car.getVehicleLicenses();
		vehicleLicense.setIsChecked(true);
		this.vehicleLicenseMng.addNewVehicleLicense(vehicleLicense);
		return "/member/verifyPass";
	}

	// 行驶证审核不通过
	@RequestMapping("/vehicleLicenseVerifyDisPass.do")
	public String vehicleLicenseVerifyDisPass(Integer carid, HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return "login";
		}
		Car car = this.carMng.getCar(carid);
		this.messageMng.sendvehicleLicenseVerifyDisPass(car, user.getAdmin());
		return "/member/verifyPass";
	}

	// 车主审核通过
	@RequestMapping("/carOwnerVerifyPass.do")
	public String carOwnerVerifyPass(Integer ownerid, HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return "login";
		}
		CarOwner carOwner = this.carOwnerMng.getCarOwnerById(ownerid);
		carOwner.setIsChecked(true);
		this.carOwnerMng.addOwner(carOwner);
		this.messageMng.sendcarOwnerVerifyPass(carOwner, user.getAdmin());
		return "/member/verifyPass";
	}

	// 车主审核不通过
	@RequestMapping("/carOwnerVerifyDisPass.do")
	public String carOwnerVerifyDisPass(Integer ownerid, HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return "login";
		}
		CarOwner carOwner = this.carOwnerMng.getCarOwnerById(ownerid);
		this.messageMng.sendcarOwnerDisVerifyPass(carOwner, user.getAdmin());
		return "/member/verifyPass";
	}

	// 租客审核通过
	@RequestMapping("/tenantVerifyPass.do")
	public String tenantVerifyPass(Integer tenantid, HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return "login";
		}
		Tenant tenant = this.tenantMng.getTenantByUserId(tenantid);
		tenant.setIsChecked(true);
		this.tenantMng.updateTenant(tenant);
		this.messageMng.sendTenantVerifyPass(tenant, user.getAdmin());
		return "/member/verifyPass";
	}
	// 租客审核不通过
	@RequestMapping("/tenantVerifyDisPass.do")
	public String tenantVerifyDisPass(Integer tenantid, HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return "login";
		}
		Tenant tenant = this.tenantMng.getTenantByUserId(tenantid);
		this.messageMng.sendTenantVerifyDisPass(tenant, user.getAdmin());
		return "/member/verifyPass";
	}
}
