package com.transition.api.controller;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.transition.api.entity.UserProfile;
import com.transition.api.service.UserProfileService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/userProfile")
public class UserProfileController {
	
	@Autowired
	private UserProfileService userProfileService;

	//create user profile
	@PostMapping("/save-userProfile")
	public ResponseEntity<HttpStatus> saveUserProfile(@RequestBody UserProfile userProfile){
		log.info("Saving userProfile");
		userProfileService.saveUserProfile(userProfile);
		return ResponseEntity.ok(HttpStatus.CREATED);
	}
	
	//update user profile
	@PutMapping("/update-userProfile/{id}")
	public ResponseEntity<HttpStatus> updateUserProfile(@PathVariable long id , @RequestBody UserProfile userProfile ){
		 log.info("Updating User Profile for userId : "+id);
		 userProfileService.updateUserProfile(id,userProfile);
		 return ResponseEntity.ok(HttpStatus.CREATED);
	}
	
	//post user image
	@PostMapping("/profile-image/{userId}")
	    public ResponseEntity<HttpStatus> uploadImage(@PathVariable long userId, @RequestParam("file") MultipartFile file) throws IOException {
				log.info("Uploading user Image for userId : "+userId);
	            userProfileService.uploadUserProfileImage(userId, file);
	            return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }
	
	//update user image
	@PutMapping("/update-profile-image/{userId}")
		public ResponseEntity<HttpStatus> updateImage(@PathVariable long userId, @RequestParam("file") MultipartFile file) throws IOException{
			    log.info("Updating user Image for userId : "+userId);
				userProfileService.updateUserProfileImage(userId, file);
				return ResponseEntity.ok(HttpStatus.ACCEPTED);
	}
}
