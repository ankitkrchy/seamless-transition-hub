package com.transition.api.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transition.api.entity.UserService;

public interface UserServiceRepository extends JpaRepository<UserService, Long> {
    List<UserService> findAllByUserUserId(long userId);
}
