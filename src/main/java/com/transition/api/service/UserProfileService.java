package com.transition.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transition.api.customException.UserNotFoundException;
import com.transition.api.entity.UserProfile;
import com.transition.api.repository.UserProfileRepository;

@Service
public class UserProfileService {

	@Autowired
	private UserProfileRepository userProfileRepo;
	
	
	public UserProfile saveUserProfile(UserProfile userProfile) {
		return userProfileRepo.save(userProfile);
	}

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

}
