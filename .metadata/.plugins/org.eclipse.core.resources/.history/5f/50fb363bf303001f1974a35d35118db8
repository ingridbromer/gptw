package com.gptw.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import com.gptw.config.AppConfigProperties;
import com.gptw.model.dto.EmployeeDTO;

@Service
public class KafkaPublisherService {

	@Autowired
	private KafkaTemplate<String, EmployeeDTO> kafkaTemplate;

	private static final Logger LOG = LoggerFactory.getLogger(KafkaPublisherService.class);

	@Autowired
	private AppConfigProperties appConfig;

	public void publish(EmployeeDTO dto) {
		// Verifica se appConfig.getSecretKey() nao eh null.
		// Se nao for, usamos o valor retornado. 
		// Caso contrario, null eh passado como valor
		String secretKey = appConfig.getSecretKey() != null ? appConfig.getSecretKey() : null;
		// token JWT no cabecalho da mensagem Kafka
		//String topic, Integer partition, K key, @Nullable data
        kafkaTemplate.send(appConfig.getOutputKafkaTopic(), null, secretKey, dto);
	}

}
