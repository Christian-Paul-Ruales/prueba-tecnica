package com.ntt.data.mcsv_cuentamovimientos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class McsvCuentamovimientosApplication {

	public static void main(String[] args) {
		SpringApplication.run(McsvCuentamovimientosApplication.class, args);
	}

}
