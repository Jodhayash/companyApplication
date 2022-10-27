package com.jayasurya.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jayasurya.company.dto.*;
import com.jayasurya.company.service.CompanyService;
import com.jayasurya.company.service.UserService;


@RestController
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private CompanyService compService;
	
	@PostMapping("/register")
	public ResponseEntity<ResponseDto> newUser(@RequestBody UserDto newUser){
		
		userService.saveUser(newUser);
		ResponseDto responseDto = new ResponseDto();
		responseDto.setError(false);
		responseDto.setData("Registration Successful");
		return new ResponseEntity<>(responseDto,HttpStatus.CREATED);
	}
	
	@GetMapping("/all/{username}")
	public ResponseEntity<ResponseDto> getAllUserCompany(@PathVariable("username") String username){
		List<CompanyDto> companyList = compService.getAllUserComapny(username);
		ResponseDto responseDTO = new ResponseDto();
		responseDTO.setError(false);
		if(companyList==null)
			responseDTO.setData("No Company created by user");
		else
			responseDTO.setData(companyList);
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<ResponseDto> newCompany(@RequestBody CompanyDto companyDto){
		
		compService.newCompany(companyDto);
		ResponseDto responseDTO = new ResponseDto();
		responseDTO.setError(false);
		responseDTO.setData("Company created");
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}
	
}
