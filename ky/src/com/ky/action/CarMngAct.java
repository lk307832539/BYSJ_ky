package com.ky.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ky.entity.Car;
import com.ky.entity.CarBrand;
import com.ky.entity.CarLevel;
import com.ky.entity.CarSeries;
import com.ky.entity.User;
import com.ky.service.CarBrandMng;
import com.ky.service.CarLevelMng;
import com.ky.service.CarMng;
import com.ky.service.CarSeriesMng;

@Controller
@RequestMapping(value = "/member")
public class CarMngAct {
	@Resource
	private CarMng carMng;
	@Resource
	private CarBrandMng carBrandMng;
	@Resource
	private CarLevelMng carLevelMng;
	@Resource
	private CarSeriesMng carSeriesMng;

	@RequestMapping("/addNewCarPage.do")
	public String addNewCarPage(Integer messageid, HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return "login";
		}
		List<CarBrand> brandlist = this.carBrandMng.getAllCarBrand();
		List<CarLevel> levellise = this.carLevelMng.getAllCarLevel();

		model.addAttribute("brandlist", brandlist);
		model.addAttribute("levellise", levellise);

		return "/member/addNewCar";
	}

	//车辆详情页面
	@RequestMapping(value = "/CarDetail.do")
	public String CarDetail(Integer carid, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return "login";
		}
		Car car = this.carMng.getCar(carid);
		model.addAttribute(car);
		return "/member/carDetail";

	}

	//新建车辆
	@RequestMapping(value = "/addNewCarAct.do")
	public String AddNewCarAct(Integer brandid, Integer seriesid, Integer levelid, Integer carage, Integer seatnum,
			Integer displacement, Integer gearbox, boolean GPS, boolean DVD, boolean reverseradar, Integer airbag,
			Double price, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return "login";
		}
		CarBrand carBrand = this.carBrandMng.getCarBrandById(brandid);
		CarSeries carSeries = this.carSeriesMng.getCarSeriesById(seriesid);
		CarLevel carLevel = this.carLevelMng.getCarLevelById(levelid);
		
		Car car = new Car();
		car.setCarBrand(carBrand);
		car.setCarSeries(carSeries);
		car.setCarLevel(carLevel);
		car.setCarAge(carage);
		car.setSeatNum(seatnum);
		car.setDisplacement(displacement);
		car.setGearbox(gearbox);
		car.setGps(GPS);
		car.setDvd(DVD);
		car.setReverseRadar(reverseradar);
		car.setAirBag(airbag);
		car.setPrice(price);
		car.setIsChecked(false);
		car.setIsSelled(false);
		car.setIsVehicleLicense(false);
		car.setCarOwner(user.getCarOwner());
		this.carMng.addCar(car);
		
		return "member/addNewCarsuccess";

	}

	// 获取汽车的系列
	@RequestMapping(value = "/getCarSerieses.do")
	@ResponseBody
	public Object GetCarSerieses(Integer brandid, HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		List<CarSeries> list = this.carSeriesMng.GetCarSeriesByBrand(brandid);
		JSONArray json = new JSONArray();
		for (CarSeries carSeries : list) {
			JSONObject jo = new JSONObject();
			jo.put("seriesId", carSeries.getSeriesId());
			jo.put("seriesName", carSeries.getSeriesName());
			json.add(jo);
		}
		return json;
	}
}
