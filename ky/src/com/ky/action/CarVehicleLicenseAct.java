package com.ky.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ky.entity.Car;
import com.ky.entity.User;
import com.ky.entity.VehicleLicense;
import com.ky.service.CarMng;
import com.ky.service.VehicleLicenseMng;
import com.ky.until.TimestampFormat;

@Controller
@RequestMapping(value = "/member")
public class CarVehicleLicenseAct {
	@Resource
	private CarMng carMng;
	@Resource
	private VehicleLicenseMng vehicleLicenseMng;

	@RequestMapping(value = "/CarVehicleLicensePage.do")
	public String AddCarVehicleLicensePage(Integer carid, HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return "login";
		}
		Car car = this.carMng.getCar(carid);
		VehicleLicense vehicleLicense;
		if (car.getVehicleLicenses() == null) {
			vehicleLicense = new VehicleLicense();
		} else {
			vehicleLicense = car.getVehicleLicenses();
		}
		model.addAttribute(car);
		model.addAttribute(vehicleLicense);
		return "/member/addCarVehicleLicense";

	}

	// 新建或者修改车辆的行驶证信息
	@RequestMapping(value = "/AddCarVehicleLicense.do")
	public String AddCarVehicleLicense(Integer carid, 
			String plateNo, String vehicleType, String owener,
			String address, String useCharacter, String carModel, String vin, String engineNo, String registerDate,
			String lssueDate, String vehicleLicenseFirImg, String vehicleLicenseSecImg, HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws Exception {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return "login";
		}
		Car car = this.carMng.getCar(carid);
		VehicleLicense vehicleLicense = new VehicleLicense();
		vehicleLicense.setPlateNo(plateNo);
		vehicleLicense.setVehicleType(vehicleType);
		vehicleLicense.setOwener(owener);
		vehicleLicense.setAddress(address);
		vehicleLicense.setUseCharacter(useCharacter);
		vehicleLicense.setModel(carModel);
		vehicleLicense.setVin(vin);
		vehicleLicense.setEngineNo(engineNo);
		vehicleLicense.setRegisterDate(TimestampFormat.TimestampToString(registerDate));
		vehicleLicense.setLssueDate(TimestampFormat.TimestampToString(lssueDate));
		vehicleLicense.setVehicleLicenseFirImg(vehicleLicenseFirImg);
		vehicleLicense.setVehicleLicenseSecImg(vehicleLicenseSecImg);
		vehicleLicense.setCar(car);
		vehicleLicense.setIsChecked(false);
		this.vehicleLicenseMng.addNewVehicleLicense(vehicleLicense);
		
		model.addAttribute(car);

		return "/member/addCarVehicleLicenSuccess";

	}

}
