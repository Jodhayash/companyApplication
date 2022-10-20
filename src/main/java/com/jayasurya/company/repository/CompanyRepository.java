package com.jayasurya.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jayasurya.company.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
	
	@Query("Update company set name =?1, address=?2 where id=?3 ")
	Company updateCompany(String name, String address, int id);
	

}
