package com.transition.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transition.api.entity.UserProfile;
import com.transition.api.repository.UserProfileRepository;

@Service
public class UserProfileService {

	@Autowired
	private UserProfileRepository userProfileRepo;
	
	public UserProfile saveUserProfile(UserProfile userProfile) {
		return userProfileRepo.save(userProfile);
	}

}
