package com.ky.entity.base;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.DynamicUpdate;

import com.ky.entity.Admin;
import com.ky.entity.CarOwner;
import com.ky.entity.Tenant;

/**
 * AbstractUser entity provides the base persistence definition of the User
 * entity. @author MyEclipse Persistence Tools
 */
@DynamicUpdate(true)
public abstract class AbstractUser implements java.io.Serializable {

	// Fields

	private Integer userId;
	private String userName;
	private String email;
	private String password;
	private String headImg;
	private Timestamp registerTime;
	private String registerIp;
	private Timestamp lastLoginTime;
	private String lastLoginIp;
	private Integer loginCount;
	private Boolean isAdmin;
	private Boolean isTenant;
	private Boolean isOwner;
	private CarOwner carOwner;
	private Admin admin;
	private Tenant tenant;
	private Set massageContents = new HashSet(0);
	private Set massageBoards = new HashSet(0);
	private Set messages = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractUser() {
	}

	/** minimal constructor */
	public AbstractUser(String userName, String email, String password) {
		this.userName = userName;
		this.email = email;
		this.password = password;
	}

	/** full constructor */
	public AbstractUser(String userName, String email, String password,
			String headImg, Timestamp registerTime, String registerIp,
			Timestamp lastLoginTime, String lastLoginIp, Integer loginCount,
			Boolean isAdmin, Boolean isTenant, Boolean isOwner,
			CarOwner carOwner, Set massageContents, Set massageBoards,
			Admin admin, Tenant tenant, Set messages) {
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.headImg = headImg;
		this.registerTime = registerTime;
		this.registerIp = registerIp;
		this.lastLoginTime = lastLoginTime;
		this.lastLoginIp = lastLoginIp;
		this.loginCount = loginCount;
		this.isAdmin = isAdmin;
		this.isTenant = isTenant;
		this.isOwner = isOwner;
		this.carOwner = carOwner;
		this.massageContents = massageContents;
		this.massageBoards = massageBoards;
		this.admin = admin;
		this.tenant = tenant;
		this.messages = messages;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHeadImg() {
		return this.headImg;
	}

	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}

	public Timestamp getRegisterTime() {
		return this.registerTime;
	}

	public void setRegisterTime(Timestamp registerTime) {
		this.registerTime = registerTime;
	}

	public String getRegisterIp() {
		return this.registerIp;
	}

	public void setRegisterIp(String registerIp) {
		this.registerIp = registerIp;
	}

	public Timestamp getLastLoginTime() {
		return this.lastLoginTime;
	}

	public void setLastLoginTime(Timestamp lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getLastLoginIp() {
		return this.lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	public Integer getLoginCount() {
		return this.loginCount;
	}

	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
	}

	public Boolean getIsAdmin() {
		return this.isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public Boolean getIsTenant() {
		return this.isTenant;
	}

	public void setIsTenant(Boolean isTenant) {
		this.isTenant = isTenant;
	}

	public Boolean getIsOwner() {
		return this.isOwner;
	}

	public void setIsOwner(Boolean isOwner) {
		this.isOwner = isOwner;
	}

	public CarOwner getCarOwner() {
		return this.carOwner;
	}

	public void setCarOwner(CarOwner carOwner) {
		this.carOwner = carOwner;
	}

	public Set getMassageContents() {
		return this.massageContents;
	}

	public void setMassageContents(Set massageContents) {
		this.massageContents = massageContents;
	}

	public Set getMassageBoards() {
		return this.massageBoards;
	}

	public void setMassageBoards(Set massageBoards) {
		this.massageBoards = massageBoards;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Tenant getTenant() {
		return tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}

	public Set getMessages() {
		return this.messages;
	}

	public void setMessages(Set messages) {
		this.messages = messages;
	}

}