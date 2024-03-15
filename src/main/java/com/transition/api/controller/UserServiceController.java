package com.transition.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.transition.api.entity.UserService;
import com.transition.api.service.UserServiceService;

@RestController
@RequestMapping("/userService")
public class UserServiceController {

	@Autowired
	private UserServiceService userServiceService;
	
	//post service data
	@PostMapping("/save-userService")
	public ResponseEntity<HttpStatus> saveUserService(@RequestBody UserService userService){
		userServiceService.saveUserService(userService);
		return ResponseEntity.ok(HttpStatus.ACCEPTED);
	}
	
	//get services data by id
	@GetMapping("/get-userService/{userId}")
	public List<UserService> getUserServiceByUserId(@PathVariable(value = "userId") long userId){
		return userServiceService.findAllServicesByUserId(userId);
	}
	
	//get all services
	@GetMapping("/get-userService")
	public List<UserService> getAllUserService(){
		return userServiceService.findAllUserServices();
	}
	
}
