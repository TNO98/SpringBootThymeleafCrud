package com.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crud.entity.Employee;
import com.crud.service.EmployeeService;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
@RequestMapping("employee")
public class EmployeeController {
	private final EmployeeService employeeService;
	
	@GetMapping
	public String getAllEmployees(Model model) {
		model.addAttribute("employees",employeeService.getAllEmployees());
		return "employees";
	}
	
	@GetMapping("/new")
	public String createEmployeeForm(Model model) {
		
		// create employee object to hold employee form data
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "create_employee";	
	}
	
	@PostMapping
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.saveEmployee(employee);
		return "redirect:/employee";
	}
	
	@GetMapping("/update/{id}")
	public String editEmployeeForm(@PathVariable Integer id, Model model) {
		model.addAttribute("employee", employeeService.getEmployeeById(id));
		return "update_employee";
	}

	@PostMapping("/{id}")
	public String updateEmployee(@PathVariable Integer id,
			@ModelAttribute("employee") Employee employee,
			Model model) {
		
		// get employee from database by id
		Employee existingEmployee = employeeService.getEmployeeById(id);
		existingEmployee.setId(id);
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		
		// save updated employee object
		employeeService.updateEmployee(existingEmployee);
		return "redirect:/employee";		
	}
	
	// handler method to handle delete employee request
	
	@GetMapping("/{id}")
	public String deleteEmployee(@PathVariable Integer id) {
		employeeService.deleteEmployeeById(id);
		return "redirect:/employee";
	}

}
