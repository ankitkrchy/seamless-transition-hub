package com.transition.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.transition.api.entity.UserProfile;


public interface UserProfileRepository extends JpaRepository<UserProfile, Long>{

}
