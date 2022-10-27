package com.jayasurya.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jayasurya.company.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{

}
