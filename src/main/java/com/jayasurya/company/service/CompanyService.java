package com.jayasurya.company.service;

import java.util.List;

import com.jayasurya.company.dto.CompanyDto;
import com.jayasurya.company.entity.Company;

public interface CompanyService {
	
	public List<CompanyDto> getAll();
	public boolean deleteCompany(int id);
	public CompanyDto upadteCompany(CompanyDto data);
	public void newCompany(CompanyDto data);
	public List<CompanyDto> getAllUserComapny(String username);
	public int approveComp(String name);

}
