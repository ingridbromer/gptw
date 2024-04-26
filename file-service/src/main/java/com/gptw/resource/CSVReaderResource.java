package com.gptw.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gptw.model.dto.EmployeeDTO;
import com.gptw.service.CSVReaderService;

@RestController
public class CSVReaderResource {

	@Autowired
	CSVReaderService csvReaderService;

	@GetMapping("/readCSV")
	public ResponseEntity<List<EmployeeDTO>> getEmployees() {
		List<EmployeeDTO> employees = csvReaderService.readCSV("arquivo.csv");

		// Verificar se a lista de funcionarios nao esta vazia
		if (employees.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Retornar 204 No Content se nao houver dados
		}

		return new ResponseEntity<>(employees, HttpStatus.OK); // Retornar os funcionarios lidos como resposta HTTP 200 OK
	}
}