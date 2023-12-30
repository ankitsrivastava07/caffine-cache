package com.springcache.cache.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springcache.cache.dao.repository.EmployeeRepository;
import com.springcache.cache.dto.EmployeeDto;

@Repository
public class EmployeeDao {
	List<EmployeeDto> emps = new ArrayList<>();

	@Autowired
	EmployeeRepository employeeRepository;

	public EmployeeEntity createEmployee(EmployeeEntity empl) {
		// emps.add(empl);
		empl = employeeRepository.save(empl);
		return empl;
	}

	public EmployeeEntity findEmployeeByEmpId(String empId) {
		return employeeRepository.findByEmpId(empId);
	}

	public EmployeeEntity updateEmp(Long empId, EmployeeEntity emp) {
		return employeeRepository.save(emp);
	}
	
	
	public EmployeeEntity findEmpById(Long empId) {
		return employeeRepository.findById(empId).get();
	}
}
