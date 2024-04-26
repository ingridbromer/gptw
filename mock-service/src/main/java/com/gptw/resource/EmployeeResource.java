package com.gptw.resource;

import java.util.List;
import java.util.UUID;

import javax.management.relation.RelationNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gptw.model.Employee;
import com.gptw.model.dto.MessageDTO;
import com.gptw.service.EmployeeService;
import com.gptw.utils.Constants;

@RestController
public class EmployeeResource {
	
	@Autowired
	EmployeeService service;

	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> findAll(){
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping("/employees/{ID}")
	public ResponseEntity<Employee> findOne(@PathVariable UUID ID) {
		return ResponseEntity.ok().body(service.findOne(ID));
	}

	@PostMapping("/employees")
	public ResponseEntity<MessageDTO> registerEmployee(@RequestBody Employee employee) {
		service.createEmployee(employee);
		return ResponseEntity.ok().body(new MessageDTO(Constants.EMPLOYEE_CREATED));
	}
	
	@PutMapping("/employees/{ID}")
	public ResponseEntity<MessageDTO> updateEmployee(@RequestBody Employee employee, @PathVariable UUID ID) throws RelationNotFoundException{
		service.updateEmployee(employee,ID);
		return ResponseEntity.ok().body(new MessageDTO(Constants.EMPLOYEE_UPDATED));
	}
	
	@DeleteMapping("/employees/{ID}") 
	public ResponseEntity<MessageDTO> deleteEmployee(@PathVariable UUID ID) {
		service.deleteEmployee(ID);
		return ResponseEntity.ok().body(new MessageDTO(Constants.EMPLOYEE_DEACTIVATED));
	}
	
}
