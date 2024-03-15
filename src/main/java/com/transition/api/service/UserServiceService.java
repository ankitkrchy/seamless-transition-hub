package com.transition.api.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.transition.api.entity.UserService;
import com.transition.api.repository.UserServiceRepository;


@Service
public class UserServiceService {

	
	@Autowired
	private UserServiceRepository userServiceRepo;

	
	public void saveUserService(UserService userService) {
		if(userService.isCurrentlyWorking() == true) {
			userService.setEndDate(null);
		}
		userServiceRepo.save(userService);
	}

	public  List<UserService> findAllServicesByUserId(long userId) {
		List<UserService> services = userServiceRepo.findAllByUserUserId(userId);
		return services;
	}

	public List<UserService> findAllUserServices() {
		return userServiceRepo.findAll();
	}
}
