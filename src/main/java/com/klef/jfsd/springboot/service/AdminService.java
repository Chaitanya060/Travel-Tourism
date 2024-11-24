package com.klef.jfsd.springboot.service;

import com.klef.jfsd.springboot.model.Admin;

public interface AdminService {
	public Admin checkAdminLogin(String email,String password);

}
