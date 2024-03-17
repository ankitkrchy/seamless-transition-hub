package com.transition.api.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transition.api.entity.Employment;

public interface EmploymentRepository extends JpaRepository<Employment, Long> {
    List<Employment> findAllByUserUserId(long userId);
}
