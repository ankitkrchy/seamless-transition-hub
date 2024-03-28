package com.transition.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transition.api.customException.CustomNotFoundException;
import com.transition.api.entity.Employment;
import com.transition.api.entity.UserProfile;
import com.transition.api.repository.EmploymentRepository;
import com.transition.api.repository.UserProfileRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmploymentService {

	
	@Autowired
	private EmploymentRepository userServiceRepo;
	
	@Autowired
	private UserProfileRepository userRepo;

	//save service for user
	public void saveUserService(Employment employment) {
		if(employment.isCurrentlyWorking() == true) {
			employment.setEndDate(null);
		}
		log.info("Saving user Service");
		userServiceRepo.save(employment);
	}
	
	//find all services for user with userID
	public  List<Employment> findAllServicesByUserId(long userId) {
		Optional<UserProfile> user = userRepo.findById(userId);
		if(user.isPresent()) {
			log.info("Getting all userServices for userId : { }" + userId);
			 return userServiceRepo.findAllByUserUserId(userId);
		}else {
			throw new IllegalArgumentException("No Service found for userId : "+ userId);
		}
		
	}

	//get All services
	public List<Employment> findAllUserServices() {
		log.info("Geting list of userServices");
		return userServiceRepo.findAll();
	}

	//deleting userservice
	public void deleteUserServiceForUserId(long serviceId) {
		Optional<Employment> employment = userServiceRepo.findById(serviceId);
		if(employment.isPresent()) {
			log.info("Deleting employment with employmentId : {}" +serviceId);
			userServiceRepo.deleteById(serviceId);
		}else {
			log.error("Error in getting Employment details with employmentId : "+serviceId);
			throw new CustomNotFoundException("Employment not exits with employmentId :" +serviceId);
		}
		
	}
}
