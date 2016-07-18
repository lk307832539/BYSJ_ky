package com.ky.entity.base;

import java.sql.Timestamp;

import org.hibernate.annotations.DynamicUpdate;

import com.ky.entity.Car;

/**
 * AbstractVehicleLicense entity provides the base persistence definition of the
 * VehicleLicense entity. @author MyEclipse Persistence Tools
 */
@DynamicUpdate(true)
public abstract class AbstractVehicleLicense implements java.io.Serializable {

	// Fields

	private Integer id;
	private Car car;
	private String plateNo;
	private String vehicleType;
	private String owener;
	private String address;
	private String useCharacter;
	private String model;
	private String vin;
	private String engineNo;
	private Timestamp registerDate;
	private Timestamp lssueDate;
	private String vehicleLicenseFirImg;
	private String vehicleLicenseSecImg;
	private Boolean isChecked;

	// Constructors

	/** default constructor */
	public AbstractVehicleLicense() {
	}

	/** minimal constructor */
	public AbstractVehicleLicense(Car car, Boolean isChecked) {
		this.car = car;
		this.isChecked = isChecked;
	}

	/** full constructor */
	public AbstractVehicleLicense(Car car, String plateNo, String vehicleType,
			String owener, String address, String useCharacter, String model,
			String vin, String engineNo, Timestamp registerDate,
			Timestamp lssueDate, String vehicleLicenseFirImg,
			String vehicleLicenseSecImg, Boolean isChecked) {
		this.car = car;
		this.plateNo = plateNo;
		this.vehicleType = vehicleType;
		this.owener = owener;
		this.address = address;
		this.useCharacter = useCharacter;
		this.model = model;
		this.vin = vin;
		this.engineNo = engineNo;
		this.registerDate = registerDate;
		this.lssueDate = lssueDate;
		this.vehicleLicenseFirImg = vehicleLicenseFirImg;
		this.vehicleLicenseSecImg = vehicleLicenseSecImg;
		this.isChecked = isChecked;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Car getCar() {
		return this.car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public String getPlateNo() {
		return this.plateNo;
	}

	public void setPlateNo(String plateNo) {
		this.plateNo = plateNo;
	}

	public String getVehicleType() {
		return this.vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getOwener() {
		return this.owener;
	}

	public void setOwener(String owener) {
		this.owener = owener;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUseCharacter() {
		return this.useCharacter;
	}

	public void setUseCharacter(String useCharacter) {
		this.useCharacter = useCharacter;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getVin() {
		return this.vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getEngineNo() {
		return this.engineNo;
	}

	public void setEngineNo(String engineNo) {
		this.engineNo = engineNo;
	}

	public Timestamp getRegisterDate() {
		return this.registerDate;
	}

	public void setRegisterDate(Timestamp registerDate) {
		this.registerDate = registerDate;
	}

	public Timestamp getLssueDate() {
		return this.lssueDate;
	}

	public void setLssueDate(Timestamp lssueDate) {
		this.lssueDate = lssueDate;
	}

	public String getVehicleLicenseFirImg() {
		return this.vehicleLicenseFirImg;
	}

	public void setVehicleLicenseFirImg(String vehicleLicenseFirImg) {
		this.vehicleLicenseFirImg = vehicleLicenseFirImg;
	}

	public String getVehicleLicenseSecImg() {
		return this.vehicleLicenseSecImg;
	}

	public void setVehicleLicenseSecImg(String vehicleLicenseSecImg) {
		this.vehicleLicenseSecImg = vehicleLicenseSecImg;
	}

	public Boolean getIsChecked() {
		return this.isChecked;
	}

	public void setIsChecked(Boolean isChecked) {
		this.isChecked = isChecked;
	}

}