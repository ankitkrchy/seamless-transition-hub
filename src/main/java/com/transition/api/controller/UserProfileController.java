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
	
	@PostMapping("/profile-image/{userId}")
	    public ResponseEntity<HttpStatus> uploadImage(@PathVariable long userId, @RequestParam("file") MultipartFile file) throws IOException {
	            userProfileService.uploadUserProfileImage(userId, file);
	            return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }
	
	@PutMapping("/update-profile-image/{userId}")
		public ResponseEntity<HttpStatus> updateImage(@PathVariable long userId, @RequestParam("file") MultipartFile file) throws IOException{
				userProfileService.updateUserProfileImage(userId, file);
				return ResponseEntity.ok(HttpStatus.ACCEPTED);
	}
}
