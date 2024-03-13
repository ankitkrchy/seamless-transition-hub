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

import com.transition.api.customException.UserNotFoundException;
import com.transition.api.entity.UserProfile;
import com.transition.api.repository.UserProfileRepository;



@Service
public class UserProfileService {

	@Autowired
	private UserProfileRepository userProfileRepo;
	
	@Value("${upload.dir}")
    private String uploadDir;
	
	
	//service to save profile
	public UserProfile saveUserProfile(UserProfile userProfile) {
		return userProfileRepo.save(userProfile);
	}

	
	//service to update the profile 
	public void updateUserProfile(long id, UserProfile userProfile) {
		
		UserProfile updateUser = userProfileRepo.findById(id).
				orElseThrow(()-> new UserNotFoundException("User not exist with id "+ id));
		
		updateUser.setFullName(userProfile.getFullName());
		updateUser.setEmail(userProfile.getEmail());
		updateUser.setContact(userProfile.getContact());
		updateUser.setGender(userProfile.getGender());
		updateUser.setDateOfBirth(userProfile.getDateOfBirth());
		updateUser.setcareerBreak(userProfile.getcareerBreak());
		updateUser.setaddress(userProfile.getaddress());
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
	        userProfile.setuserImageFilePath(filePath);
	        userProfileRepo.save(userProfile);
	    } 
	}
	
	//update user profile Image 
	public void updateUserProfileImage(long userId, MultipartFile file) throws IOException{
		Optional<UserProfile> userProfileOptional = userProfileRepo.findById(userId);
		if(userProfileOptional.isPresent()) {
			UserProfile userProfile = userProfileOptional.get();
			//get userProfile
			String existingFilePath = userProfile.getuserImageFilePath();
			
			//delete it 
			if(existingFilePath!=null) {
				File existingFile = new File(existingFilePath);
				if(existingFile.exists()) {
					existingFile.delete();
				}
			}
			
			uploadUserProfileImage(userId, file);
		
		}
	}

	
}

