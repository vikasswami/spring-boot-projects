package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.services.GCPService;

@RestController
public class AdminController {
	
	@Autowired
	GCPService gcpService;
	
	@GetMapping(value="/admin/check-connection")
	public void checkConnection(){
		gcpService.checkConnection();	 
	}
	
	@GetMapping(value="/admin/create-bucket")
	public void createBucket(){
		gcpService.createBucket();
	}

}
