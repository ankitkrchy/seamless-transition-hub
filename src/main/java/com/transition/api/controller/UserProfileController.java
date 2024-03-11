package com.transition.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.transition.api.entity.UserProfile;
import com.transition.api.service.UserProfileService;

@RestController
@RequestMapping("/userProfile")
public class UserProfileController {
	
	@Autowired
	private UserProfileService userProfileService;

	@PostMapping("/save-userProfile")
	public ResponseEntity<HttpStatus> saveUserProfile(@RequestBody UserProfile userProfile){
		userProfileService.saveUserProfile(userProfile);
		return ResponseEntity.ok(HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/update-userProfile/{id}")
	public ResponseEntity<HttpStatus> updateUserProfile(@PathVariable long id , @RequestBody UserProfile userProfile ){
		 userProfileService.updateUserProfile(id,userProfile);
		 return ResponseEntity.ok(HttpStatus.ACCEPTED);
	}
}
