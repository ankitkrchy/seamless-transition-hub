package com.transition.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.transition.api.entity.Employment;
import com.transition.api.service.EmploymentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/userService")
public class EmploymentController {

	@Autowired
	private EmploymentService employmentService;
	
	//post service data
	@PostMapping("/save-userService")
	public ResponseEntity<HttpStatus> saveUserService(@RequestBody Employment employment){
		log.info("Saving Employment Details");
		employmentService.saveUserService(employment);
		return ResponseEntity.ok(HttpStatus.ACCEPTED);
	}
	
	//get services data by id
	@GetMapping("/get-userService/{userId}")
	public List<Employment> getUserServiceByUserId(@PathVariable(value = "userId") long userId){
		log.info("Retriving Documents for userId : "+userId);
		return employmentService.findAllServicesByUserId(userId);
	}
	
	//get all services
	@GetMapping("/get-userService")
	public List<Employment> getAllUserService(){
		log.info("Retriving all details of Employment");
		return employmentService.findAllUserServices();
	}
	
	//delete user service for userID
	@DeleteMapping("/delete-userService/{serviceId}")
	public ResponseEntity<HttpStatus> deleteServiceForUserId(@PathVariable long serviceId){
		log.info("Deleting user Employment with employmentId : "+serviceId);
		employmentService.deleteUserServiceForUserId(serviceId);
		return ResponseEntity.ok(HttpStatus.ACCEPTED);
	}
	
}
