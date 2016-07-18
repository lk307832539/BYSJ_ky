package com.ky.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.springframework.stereotype.Service;

import com.ky.dao.TenantDao;
import com.ky.entity.CarOwner;
import com.ky.entity.Tenant;
import com.ky.service.TenantMng;

@Service
public class TenantMngImpl implements TenantMng {
	@Resource
	private TenantDao tenantDao;

	@Override
	public Tenant addTenant(Tenant tenant) {
		this.tenantDao.addTenant(tenant);
		return null;

	}
	@Override
	public Tenant updateTenant(Tenant tenant) {
		this.tenantDao.updateTenant(tenant);
		return null;
		
	}

	@Override
	public Tenant getTenantByUserId(Integer userId) {
		Tenant tenant = this.tenantDao.getTenantByUserId(userId);
		return tenant;
	}

	@Override
	public List<Tenant> getAllTenant() {
		List<Tenant> list = this.tenantDao.getAllTenant();
		return list;
	}

	
}
