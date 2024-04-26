package com.gptw.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties("app")
public class AppConfigProperties {
	
	private String outputKafkaTopic;
	
	private int kafkaTopicNumPartitions;

	private short kafkaTopicReplicationFactor;
	
	private String secretKey;
	
}