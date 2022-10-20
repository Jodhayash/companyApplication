package com.jayasurya.company.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jayasurya.company.dto.UserDto;
import com.jayasurya.company.entity.Company;
import com.jayasurya.company.entity.User;
import com.jayasurya.company.exception.UserException;
import com.jayasurya.company.repository.UserRepository;

@Service
public class UserServiceImpli implements UserService{
	
	@Autowired
	UserRepository userRepo;
	
	@Transactional
	@Override
	public UserDto saveUser(UserDto data) {
		if(data!=null) {
			User userEntity = new User();
			BeanUtils.copyProperties(data, userEntity);
			userRepo.save(userEntity);
			return data;
			
		}
		else {
			throw new UserException("Failed to Update User: User Information Should Not be Empty!");
		}
	}
}
