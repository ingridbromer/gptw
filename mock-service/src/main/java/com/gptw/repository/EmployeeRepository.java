package com.gptw.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gptw.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
	
	Optional<Employee> findById(UUID id);
}
