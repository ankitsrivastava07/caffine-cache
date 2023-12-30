package com.springcache.cache.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springcache.cache.dao.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long>{

	EmployeeEntity findByEmpId(String empId);

}
