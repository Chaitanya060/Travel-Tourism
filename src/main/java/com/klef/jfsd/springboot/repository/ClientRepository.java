package com.klef.jfsd.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.klef.jfsd.springboot.model.Client;

public interface ClientRepository extends JpaRepository<Client, Integer>{
	
	@Query("select c from Client c where c.email=?1 and c.password=?2")
	public Client checkClientLogin(String email,String password);

}
