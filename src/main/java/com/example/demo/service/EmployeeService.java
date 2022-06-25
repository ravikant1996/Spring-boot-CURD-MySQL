package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);
	List<Employee> getAllEmployees();
	Employee getEmployeeById(long Id);
	Employee updatEmployee(Employee employee, long Id);
	void deleteEmployee(long Id);
}
