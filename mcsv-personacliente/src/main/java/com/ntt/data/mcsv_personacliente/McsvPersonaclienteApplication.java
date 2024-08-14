package com.ntt.data.mcsv_personacliente;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class McsvPersonaclienteApplication {
	private static final Logger logger = LoggerFactory.getLogger(McsvPersonaclienteApplication.class);

	public static void main(String[] args) {
		logger.info("Procesando microservicio persona-cliente...");
		SpringApplication.run(McsvPersonaclienteApplication.class, args);
	}

}
