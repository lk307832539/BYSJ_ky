package com.ky.dao;

import java.util.List;

import com.ky.entity.CarOwner;
import com.ky.entity.Tenant;

public abstract interface TenantDao {
	public void addTenant(Tenant tenant);

	public Tenant getTenantByUserId(Integer userId);

	public List<Tenant> getAllTenant();

	void updateTenant(Tenant tenant);
}
