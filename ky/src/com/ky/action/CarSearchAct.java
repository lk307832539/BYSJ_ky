package com.ky.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ky.entity.Car;
import com.ky.service.CarMng;

@Controller
public class CarSearchAct {
	@Resource
	private CarMng carMng;

	@RequestMapping(value = "/carSearch.do")
	public String carSearch(Double minprice, Double maxprice, Integer gearbox, Integer displacement, boolean gps,
			boolean dvd, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		List<Car> list = this.carMng.getCarBySearch(minprice, maxprice, gearbox, displacement, gps, dvd);
		List<Car> carlist = new ArrayList<Car>();
		for (Car car : list) {
			car = this.carMng.getCar(car.getCarId());
			carlist.add(car);
		}
		model.addAttribute("carlist", carlist);
		return "carPandect";
	}
}
