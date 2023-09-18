package com.crud.service;

import java.util.List;

import com.crud.entity.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();
	
	Employee saveEmployee(Employee employee);
	
	Employee getEmployeeById(Integer id);
	
	Employee updateEmployee(Employee employee);
	
	void deleteEmployeeById(Integer id);
}
