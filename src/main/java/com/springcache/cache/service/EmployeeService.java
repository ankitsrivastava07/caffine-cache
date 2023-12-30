package com.springcache.cache.service;

import java.util.Map;

import com.springcache.cache.dao.EmployeeDao;
import com.springcache.cache.dao.EmployeeEntity;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class EmployeeService {

	ObjectMapper mapper = new ObjectMapper();

	@Autowired
	EmployeeDao employeeDao;

	Logger logger = LoggerFactory.getLogger("");

	@Autowired
	CacheManager cacheManager;

	public EmployeeEntity createEmployee(Map<String, Object> requestBody) {
		EmployeeEntity employee = mapper.convertValue(requestBody, EmployeeEntity.class);
		employee = employeeDao.createEmployee(employee);
		return employee;
	}

	@Cacheable(value = "employees", key = "#empId")
	public EmployeeEntity getEmployee(Long empId) {
		
		logger.info("getEmployee Method called " + cacheManager);
		
		logger.info("getEmployee Method called " + empId);
		return employeeDao.findEmpById(empId);
	}

	@CachePut(key = "#empId", value = "employees")
	public EmployeeEntity updateEmp(Long empId, EmployeeEntity emp) {
		return employeeDao.updateEmp(empId, emp);
	}

	@Scheduled(cron = "0 0 */1 * * *")
	@CacheEvict(value = "employees", allEntries = true)
	public void clearCache() {
		logger.info("Cache Evict Method called ");
	}

}
