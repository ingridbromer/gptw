package com.gptw.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.management.relation.RelationNotFoundException;

import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gptw.model.Employee;
import com.gptw.model.dto.EmployeeDTO;
import com.gptw.repository.EmployeeRepository;
import com.gptw.utils.Constants;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;

	// Employee list
	public List<Employee> findAll() {
		return repository.findAll();
	}

	// Employee Detail
	public Employee findById(UUID id) {
		Optional<Employee> employee = repository.findById(id);
		return employee.orElseThrow(() -> new ResourceNotFoundException(Constants.EMPLOYEE_NOT_FOUND + id));
	}

	// Employee Detail with throws ResourceNotFoundException
	public Employee findOne(UUID id) {
		return findById(id);
	}

	// Employee Create
	public Employee createEmployeeByTopicMessage(EmployeeDTO dto) {
		Employee employee = new Employee();
		employee.setName(dto.getName());
		employee.setEmail(dto.getEmail());
		employee.setDepartment(dto.getDepartment());
		employee.setSalary(Long.parseLong(dto.getSalary()));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dt = (LocalDate.parse(dto.getBirthDate(),formatter));
		employee.setBirthDate(dt);
		return repository.save(employee);

	}
	
	// Employee Create
	public Employee createEmployee(Employee newEmployee) {
		Employee employee = new Employee();
		employee.setName(newEmployee.getName());
		employee.setEmail(newEmployee.getEmail());
		employee.setDepartment(newEmployee.getDepartment());
		employee.setSalary(newEmployee.getSalary());
		employee.setBirthDate(newEmployee.getBirthDate());
		return repository.save(employee);

	}

	// Employee Update
	public Employee updateEmployee(Employee newEmployee, UUID id) throws RelationNotFoundException {
		try {
			Employee employee = this.findById(id);
			employee.setName(newEmployee.getName());
			employee.setSalary(newEmployee.getSalary());
			employee.setBirthDate(newEmployee.getBirthDate());
			employee.setEmail(newEmployee.getEmail());
			employee.setDepartment(newEmployee.getDepartment());
			return repository.save(employee);
		} catch (Exception e) {
			throw new RelationNotFoundException();
		}
	}

	// Employee Delete
	public void deleteEmployee(UUID id) throws ResourceNotFoundException {
		Optional<Employee> present = repository.findById(id);
		if (present.isEmpty()) {
			throw new ResourceNotFoundException(Constants.EMPLOYEE_NOT_FOUND);
		}
		Employee employee = findById(id);
		repository.delete(employee);
	}
}