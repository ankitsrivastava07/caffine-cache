package com.springcache.cache.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcache.cache.dao.EmployeeEntity;
import com.springcache.cache.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping("/create")
	public ResponseEntity<EmployeeEntity> createEmployee(@RequestBody Map<String, Object> requestBody) {
		return new ResponseEntity<>(employeeService.createEmployee(requestBody), HttpStatus.CREATED);
	}

	@GetMapping("/{empId}")
	public ResponseEntity<EmployeeEntity> findEmployeeById(@PathVariable Long empId) {
		return new ResponseEntity<>(employeeService.getEmployee(empId), HttpStatus.OK);
	}

	@PutMapping("/{empId}/update")
	public ResponseEntity<EmployeeEntity> updateEmp(@PathVariable Long empId, @RequestBody EmployeeEntity emp) {
		return new ResponseEntity<>(employeeService.updateEmp(empId, emp), HttpStatus.OK);
	}
}
