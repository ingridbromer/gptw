package com.gptw.model.dto;

import lombok.Data;

@Data
public class EmployeeDTO {

	private String id;

	private String name;

	private String email;

	private String department;

	private String salary;

	private String birthDate;
	
	/* public EmployeeDTO() {
	        // Construtor padrão sem argumentos
	    }

	    public EmployeeDTO(String id, String name, String email, String department, String salary, String birthDate) {
	        this.id = id;
	        this.name = name;
	        this.email = email;
	        this.department = department;
	        this.salary = salary;
	        this.birthDate = birthDate;
	    }*/


}
