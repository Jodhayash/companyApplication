package com.jayasurya.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jayasurya.company.entity.User;

public interface UserRepository extends JpaRepository<User, String>{

}
