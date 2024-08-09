package com.ntt.data.mcsv_personacliente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class McsvPersonaclienteApplication {

	public static void main(String[] args) {
		SpringApplication.run(McsvPersonaclienteApplication.class, args);
	}

}
