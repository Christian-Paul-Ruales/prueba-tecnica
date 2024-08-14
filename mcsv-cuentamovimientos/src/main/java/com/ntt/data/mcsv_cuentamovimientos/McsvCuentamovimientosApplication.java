package com.ntt.data.mcsv_cuentamovimientos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class McsvCuentamovimientosApplication {
	private static final Logger logger = LoggerFactory.getLogger(McsvCuentamovimientosApplication.class);

	public static void main(String[] args) {
		logger.info("Procesando microservicio persona-cliente...");

		SpringApplication.run(McsvCuentamovimientosApplication.class, args);
	}

}
