package com.ky.entity.base;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.DynamicUpdate;

import com.ky.entity.CarBrand;
import com.ky.entity.CarLevel;
import com.ky.entity.CarOwner;
import com.ky.entity.CarSeries;
import com.ky.entity.VehicleLicense;

/**
 * AbstractCar entity provides the base persistence definition of the Car
 * entity. @author MyEclipse Persistence Tools
 */
@DynamicUpdate(true)
public abstract class AbstractCar implements java.io.Serializable {

	// Fields

	private Integer carId;
	private CarLevel carLevel;
	private CarBrand carBrand;
	private CarSeries carSeries;
	private CarOwner carOwner;
	private Integer carAge;
	private Integer seatNum;
	private Integer displacement;
	private Integer gearbox;
	private Boolean gps;
	private Boolean dvd;
	private Boolean reverseRadar;
	private Integer airBag;
	private Double price;
	private Boolean isSelled;
	private Boolean isChecked;
	private Boolean isVehicleLicense;
	private VehicleLicense vehicleLicenses ;
	private Set massageBoards = new HashSet(0);
	private Set carImgs = new HashSet(0);
	private Set orders = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractCar() {
	}

	/** minimal constructor */
	public AbstractCar(CarLevel carLevel, CarBrand carBrand,
			CarSeries carSeries, CarOwner carOwner, Integer displacement,
			Integer gearbox, Double price, Boolean isSelled, Boolean isChecked,
			Boolean isVehicleLicense) {
		this.carLevel = carLevel;
		this.carBrand = carBrand;
		this.carSeries = carSeries;
		this.carOwner = carOwner;
		this.displacement = displacement;
		this.gearbox = gearbox;
		this.price = price;
		this.isSelled = isSelled;
		this.isChecked = isChecked;
		this.isVehicleLicense = isVehicleLicense;
	}

	/** full constructor */
	public AbstractCar(CarLevel carLevel, CarBrand carBrand,
			CarSeries carSeries, CarOwner carOwner, Integer carAge,
			Integer seatNum, Integer displacement, Integer gearbox,
			Boolean gps, Boolean dvd, Boolean reverseRadar, Integer airBag,
			Double price, Boolean isSelled, Boolean isChecked,
			Boolean isVehicleLicense, VehicleLicense vehicleLicenses, Set massageBoards,
			Set carImgs, Set orders) {
		this.carLevel = carLevel;
		this.carBrand = carBrand;
		this.carSeries = carSeries;
		this.carOwner = carOwner;
		this.carAge = carAge;
		this.seatNum = seatNum;
		this.displacement = displacement;
		this.gearbox = gearbox;
		this.gps = gps;
		this.dvd = dvd;
		this.reverseRadar = reverseRadar;
		this.airBag = airBag;
		this.price = price;
		this.isSelled = isSelled;
		this.isChecked = isChecked;
		this.isVehicleLicense = isVehicleLicense;
		this.vehicleLicenses = vehicleLicenses;
		this.massageBoards = massageBoards;
		this.carImgs = carImgs;
		this.orders = orders;
	}

	// Property accessors

	public Integer getCarId() {
		return this.carId;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
	}

	public CarLevel getCarLevel() {
		return this.carLevel;
	}

	public void setCarLevel(CarLevel carLevel) {
		this.carLevel = carLevel;
	}

	public CarBrand getCarBrand() {
		return this.carBrand;
	}

	public void setCarBrand(CarBrand carBrand) {
		this.carBrand = carBrand;
	}

	public CarSeries getCarSeries() {
		return this.carSeries;
	}

	public void setCarSeries(CarSeries carSeries) {
		this.carSeries = carSeries;
	}

	public CarOwner getCarOwner() {
		return this.carOwner;
	}

	public void setCarOwner(CarOwner carOwner) {
		this.carOwner = carOwner;
	}

	public Integer getCarAge() {
		return this.carAge;
	}

	public void setCarAge(Integer carAge) {
		this.carAge = carAge;
	}

	public Integer getSeatNum() {
		return this.seatNum;
	}

	public void setSeatNum(Integer seatNum) {
		this.seatNum = seatNum;
	}

	public Integer getDisplacement() {
		return this.displacement;
	}

	public void setDisplacement(Integer displacement) {
		this.displacement = displacement;
	}

	public Integer getGearbox() {
		return this.gearbox;
	}

	public void setGearbox(Integer gearbox) {
		this.gearbox = gearbox;
	}

	public Boolean getGps() {
		return this.gps;
	}

	public void setGps(Boolean gps) {
		this.gps = gps;
	}

	public Boolean getDvd() {
		return this.dvd;
	}

	public void setDvd(Boolean dvd) {
		this.dvd = dvd;
	}

	public Boolean getReverseRadar() {
		return this.reverseRadar;
	}

	public void setReverseRadar(Boolean reverseRadar) {
		this.reverseRadar = reverseRadar;
	}

	public Integer getAirBag() {
		return this.airBag;
	}

	public void setAirBag(Integer airBag) {
		this.airBag = airBag;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Boolean getIsSelled() {
		return this.isSelled;
	}

	public void setIsSelled(Boolean isSelled) {
		this.isSelled = isSelled;
	}

	public Boolean getIsChecked() {
		return this.isChecked;
	}

	public void setIsChecked(Boolean isChecked) {
		this.isChecked = isChecked;
	}

	public Boolean getIsVehicleLicense() {
		return this.isVehicleLicense;
	}

	public void setIsVehicleLicense(Boolean isVehicleLicense) {
		this.isVehicleLicense = isVehicleLicense;
	}

	public VehicleLicense getVehicleLicenses() {
		return this.vehicleLicenses;
	}

	public void setVehicleLicenses(VehicleLicense vehicleLicenses) {
		this.vehicleLicenses = vehicleLicenses;
	}

	public Set getMassageBoards() {
		return this.massageBoards;
	}

	public void setMassageBoards(Set massageBoards) {
		this.massageBoards = massageBoards;
	}

	public Set getCarImgs() {
		return this.carImgs;
	}

	public void setCarImgs(Set carImgs) {
		this.carImgs = carImgs;
	}

	public Set getOrders() {
		return this.orders;
	}

	public void setOrders(Set orders) {
		this.orders = orders;
	}

}