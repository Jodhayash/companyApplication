package com.jayasurya.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jayasurya.company.dto.*;
import com.jayasurya.company.service.UserService;


@RestController
@RequestMapping("")
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<ResponseDto> newUser(@RequestBody UserDto newUser ){
		
		UserDto userDto = userService.saveUser(newUser);
		ResponseDto responseDto = new ResponseDto();
		responseDto.setError(false);
		responseDto.setData(userDto);
		responseDto.setMsg("Registration Successful");
		return new ResponseEntity<>(responseDto,HttpStatus.OK);
	}
	
}
