package com.klef.jfsd.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.klef.jfsd.springboot.model.Admin;
import com.klef.jfsd.springboot.model.Client;

public interface AdminRepository extends JpaRepository<Admin, Integer>{
	@Query("select a from Client a where a.email=?1 and a.password=?2")
	public Admin checkAdminLogin(String email,String password);

}
