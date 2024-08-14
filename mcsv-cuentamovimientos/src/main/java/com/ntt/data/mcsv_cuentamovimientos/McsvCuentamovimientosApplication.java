package com.ntt.data.mcsv_cuentamovimientos;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@Slf4j
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class McsvCuentamovimientosApplication {

	public static void main(String[] args) {
		log.info("Procesando microservicio persona-cliente...");

		SpringApplication.run(McsvCuentamovimientosApplication.class, args);
	}

}
