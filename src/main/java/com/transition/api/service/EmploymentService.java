package com.transition.api.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.transition.api.entity.Employment;
import com.transition.api.repository.EmploymentRepository;


@Service
public class EmploymentService {

	
	@Autowired
	private EmploymentRepository userServiceRepo;

	
	public void saveUserService(Employment employment) {
		if(employment.isCurrentlyWorking() == true) {
			employment.setEndDate(null);
		}
		userServiceRepo.save(employment);
	}

	public  List<Employment> findAllServicesByUserId(long userId) {
		List<Employment> services = userServiceRepo.findAllByUserUserId(userId);
		return services;
	}

	public List<Employment> findAllUserServices() {
		return userServiceRepo.findAll();
	}
}
