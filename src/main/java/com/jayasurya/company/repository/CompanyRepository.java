package com.jayasurya.company.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jayasurya.company.entity.Company;
import com.jayasurya.company.entity.User;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
	
	
	@Modifying
	@Query("Update Company u set u.cName= :name , u.address= :address where u.id= :id ")
	void updateCompany(@Param(value = "name") String name, @Param(value = "address") String address, @Param(value = "id") int id);
	
	@Query("Select u from Company u where username=?1")
	List<Company> findCompanyByUsername(User un);
	
	@Query("Select u from Company u where name=?1")
	Company findByCName(String name);
	
	@Transactional
	@Modifying
	@Query("Update Company u set u.status ='Approved' where cName =?1")
	void updateCompantStatus(String name);
	

}
