package com.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.crud.entity.Employee;
import com.crud.service.EmployeeService;

@SpringBootApplication
public class CrudApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}
	
	@Autowired
	EmployeeService empService;

	@Override
	public void run(String... args) throws Exception {
		Employee malay = new Employee("Malay", "Sarkar", "malay@gmail.com");
		Employee emp =empService.saveEmployee(malay);
		System.out.println(emp.getFirstName());
	}

}
