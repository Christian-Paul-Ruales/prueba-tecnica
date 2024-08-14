package com.ntt.data.mcsv_personacliente;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@Slf4j
@EnableDiscoveryClient
@SpringBootApplication
public class McsvPersonaclienteApplication {

	public static void main(String[] args) {
		log.info("Procesando microservicio persona-cliente...");
		SpringApplication.run(McsvPersonaclienteApplication.class, args);
	}

}
