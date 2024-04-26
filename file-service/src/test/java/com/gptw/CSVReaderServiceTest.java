package com.gptw;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.gptw.config.AppConfigProperties;
import com.gptw.model.dto.EmployeeDTO;
import com.gptw.service.CSVReaderService;
import com.gptw.service.KafkaPublisherService;

public class CSVReaderServiceTest {

	@Mock
	private AppConfigProperties appConfig;

	@Mock
	private KafkaPublisherService mockKafkaPublisherService;

	@InjectMocks
	private CSVReaderService csvReaderService;

	@BeforeEach
	public void setUp() {
	}

	@Test
	public void testReadCSV() {
		List<EmployeeDTO> employees = csvReaderService.readCSV("arquivoTeste.csv");
		// Verifica se o metodo publisher sera chamado para cada funcionario do arquivo csv
		when(appConfig.getSecretKey()).thenReturn("secret-key");
		for (EmployeeDTO employee : employees) {
			verify(mockKafkaPublisherService).publish(employee);
		}
	}

}