package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	EmployeeRepository employeeRepository;

	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super(); 
		this.employeeRepository = employeeRepository;
	}


	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}


	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}


	@Override
	public Employee getEmployeeById(long Id) {
//		Optional<Employee> employee= employeeRepository.findById(Id);
//		if (employee.isPresent()) {
//			return employee.get();
//		}else {
//			throw new ResourceNotFoundException("Employee", "Id", Id);
//		}
		
		return employeeRepository.findById(Id).orElseThrow(()-> new ResourceNotFoundException("Employee", "Id", Id));
	}


	@Override
	public Employee updatEmployee(Employee employee, long Id) {
		Employee exitingEmployee= employeeRepository.findById(Id).orElseThrow(()-> new ResourceNotFoundException("Employee", "Id", Id));
		
		exitingEmployee.setFirstName(employee.getFirstName());
		exitingEmployee.setLastName(employee.getLastName());
		exitingEmployee.setEmail(employee.getEmail());
		
		employeeRepository.save(exitingEmployee);
		
		return exitingEmployee;
	}


	@Override
	public void deleteEmployee(long Id) {
		
		employeeRepository.findById(Id).orElseThrow(()-> new ResourceNotFoundException("Employee", "Id", Id));
		employeeRepository.deleteById(Id);
		
	}

}
