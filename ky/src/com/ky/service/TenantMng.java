package com.ky.service;

import java.util.List;

import com.ky.entity.CarOwner;
import com.ky.entity.Tenant;

public abstract interface TenantMng {
	public abstract Tenant addTenant(Tenant tenant);
	
	public abstract Tenant getTenantByUserId(Integer userId);

	public abstract List<Tenant> getAllTenant();

	public abstract Tenant updateTenant(Tenant tenant);
}
