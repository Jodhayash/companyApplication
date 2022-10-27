package com.jayasurya.company.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jayasurya.company.dto.CompanyDto;
import com.jayasurya.company.dto.ResponseDto;
import com.jayasurya.company.exception.CompanyException;
import com.jayasurya.company.service.CompanyService;
import com.jayasurya.company.service.UserService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private CompanyService compService;

	@GetMapping("")
	public ResponseEntity<ResponseDto> showAllCompany() {
		List<CompanyDto> companyList = compService.getAll();
		ResponseDto responseDTO = new ResponseDto();
		responseDTO.setError(false);
		responseDTO.setData(companyList);
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);

	}

	@Transactional
	@PutMapping("/edit")
	public ResponseEntity<ResponseDto> updateCompany(@RequestBody CompanyDto companyDto) {

		CompanyDto dto = compService.upadteCompany(companyDto);
		ResponseDto responseDTO = new ResponseDto();
		if (dto == null) {
			responseDTO.setError(true);
			responseDTO.setData("Company does not exist");
			return new ResponseEntity<>(responseDTO, HttpStatus.NOT_FOUND);
		} else {
			responseDTO.setError(false);
			responseDTO.setData("Company details updated");
			return new ResponseEntity<>(responseDTO, HttpStatus.OK);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseDto> deleteCompany(@PathVariable("id") int id) {
		boolean result = compService.deleteCompany(id);
		ResponseDto responseDTO = new ResponseDto();
		if (!result) {
			responseDTO.setError(true);
			responseDTO.setData("Company does not exist");
			return new ResponseEntity<>(responseDTO, HttpStatus.NOT_FOUND);
		} else {
			responseDTO.setError(false);
			responseDTO.setData("Company deleted");
			return new ResponseEntity<>(responseDTO, HttpStatus.OK);
		}
	}

	@PostMapping("/create")
	public ResponseEntity<ResponseDto> createCompany(@RequestBody CompanyDto companyDto) {

		compService.newCompany(companyDto);
		ResponseDto responseDTO = new ResponseDto();
		responseDTO.setError(false);
		responseDTO.setData("Company created");
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);

	}

	@GetMapping("/approve/{name}")
	public ResponseEntity<ResponseDto> approveCompany(@PathVariable("name") String Cname) {
		int flag = compService.approveComp(Cname);
		ResponseDto responseDTO = new ResponseDto();
		if (flag == 0) {
			responseDTO.setError(true);
			responseDTO.setData("Company does not exist");
			return new ResponseEntity<>(responseDTO, HttpStatus.NOT_FOUND);
		} else {
			responseDTO.setError(false);
			responseDTO.setData("Company Approved");
			return new ResponseEntity<>(responseDTO, HttpStatus.OK);
		}
	}
}
