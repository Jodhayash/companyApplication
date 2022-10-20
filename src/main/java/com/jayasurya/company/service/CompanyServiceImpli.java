package com.jayasurya.company.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.jayasurya.company.dto.CompanyDto;
import com.jayasurya.company.dto.UserDto;
import com.jayasurya.company.entity.Company;
import com.jayasurya.company.exception.CompanyException;
import com.jayasurya.company.repository.CompanyRepository;
import com.jayasurya.company.repository.UserRepository;

public class CompanyServiceImpli implements CompanyService {

	@Autowired
	CompanyRepository compRepo;

	@Override
	public List<CompanyDto> getAll() {

		List<Company> list = compRepo.findAll();
		List<CompanyDto> dto_list = new ArrayList<>();

		for (Company company : list) {
			CompanyDto data = new CompanyDto();
			BeanUtils.copyProperties(company, data);
			dto_list.add(data);
		}
		return dto_list;
	}

	@Override
	public boolean deleteCompany(int id) {
		if(id!=0) {
		Company company = compRepo.findById(id).orElse(null);
		if (company == null)
			return false;
		else {
			compRepo.delete(company);
			return true;
		}
		}
		else {
			throw new CompanyException("Company name can not be empty");
		}
	}

	@Override
	public CompanyDto upadteCompany(CompanyDto data) {
		if(data!=null) {
			Company company = new Company();
			BeanUtils.copyProperties(data, company);
			if(!compRepo.findById(company.getId()).isPresent()) {
				return null;
			}
			else {
				compRepo.updateCompany(company.getCName(), company.getAddress(), company.getId());
				return data;
			}
			
		}
		else {
			throw new CompanyException("Company details can not be empty");
		}
	}
}
