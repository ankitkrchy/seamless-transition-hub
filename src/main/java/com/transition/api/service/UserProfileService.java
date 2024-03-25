package com.transition.api.service;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.transition.api.customException.CustomNotFoundException;
import com.transition.api.entity.UserProfile;
import com.transition.api.repository.UserProfileRepository;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class UserProfileService {

	@Autowired
	private UserProfileRepository userProfileRepo;
	
	@Value("${upload.dir}")
    private String uploadDir;
	
	
	//service to save profile
	public UserProfile saveUserProfile(UserProfile userProfile) {
		log.info("User profile saved successfully: {}", userProfile);
		return userProfileRepo.save(userProfile);
	}

	
	//service to update the profile 
	public void updateUserProfile(long id, UserProfile userProfile) {
		
		UserProfile updateUser = userProfileRepo.findById(id).
				orElseThrow(()-> new CustomNotFoundException("User not exist with id "+ id));
		
		updateUser.setFullName(userProfile.getFullName());
		updateUser.setEmail(userProfile.getEmail());
		updateUser.setContact(userProfile.getContact());
		updateUser.setGender(userProfile.getGender());
		updateUser.setDateOfBirth(userProfile.getDateOfBirth());
		updateUser.setCareerBreak(userProfile.getCareerBreak());
		updateUser.setAddress(userProfile.getAddress());
		updateUser.setCriminalBackground(userProfile.isCriminalBackground());
		updateUser.setTenthPercentage(userProfile.getTenthPercentage());
		updateUser.setTwelthPercentage(userProfile.getTwelthPercentage());
		updateUser.setUniversityName(userProfile.getUniversityName());
		updateUser.setOrganisationName(userProfile.getOrganisationName());
		updateUser.setPosition(userProfile.getPosition());
		updateUser.setKeySkills(userProfile.getKeySkills());
		updateUser.setDescription(userProfile.getDescription());
		updateUser.setLinkedinLink(userProfile.getLinkedinLink());
		updateUser.setGitLink(userProfile.getGitLink());
		
		log.debug("Updating user profile with ID: {}" + userProfile.getUserId());
		userProfileRepo.save(updateUser);
	}
	
	
	//service to save the profile image
	public void uploadUserProfileImage(long userId, MultipartFile file) throws IOException {
	    File directory = new File(uploadDir);
	    if (!directory.exists()) {
	        boolean created = directory.mkdirs();
	        if (!created) {
	            throw new IOException("Failed to create directory: " + uploadDir);
	        }
	    }
	    
	    byte[] bytes = file.getBytes();
	    Path path = Paths.get(uploadDir + File.separator + "user_" + userId + "_" + file.getOriginalFilename());
	    Files.write(path, bytes);	    

	    String filePath = path.toString();
	    Optional<UserProfile> userProfileOptional = userProfileRepo.findById(userId);
	    if (userProfileOptional.isPresent()) {
	        UserProfile userProfile = userProfileOptional.get();
	        userProfile.setUserImageFilePath(filePath);
	        userProfileRepo.save(userProfile);
	        log.info("User profile image uploaded successfully for user ID: {}" + userProfile.getUserId());
	    }else {
            log.error("User profile not found while uploading image for user ID: {}" + userId);
	    	throw new CustomNotFoundException("User not found with ID: " + userId);
	    }
	}
	
	//update user profile Image 
	public void updateUserProfileImage(long userId, MultipartFile file) throws IOException{
		Optional<UserProfile> userProfileOptional = userProfileRepo.findById(userId);
		if(userProfileOptional.isPresent()) {
			UserProfile userProfile = userProfileOptional.get();
			//get userProfile
			String existingFilePath = userProfile.getUserImageFilePath();
			
			//delete it 
			if(existingFilePath!=null) {
				File existingFile = new File(existingFilePath);
				if(existingFile.exists()) {
					existingFile.delete();
                    log.debug("Deleted existing user profile image file: {}", existingFilePath);
				}
			}
			
			uploadUserProfileImage(userId, file);
            log.info("Updated user profile image for user ID: {}" + userId);
		}
	}

	
}

