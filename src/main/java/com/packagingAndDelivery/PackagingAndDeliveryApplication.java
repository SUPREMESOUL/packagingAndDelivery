package com.packagingAndDelivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;



@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class PackagingAndDeliveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(PackagingAndDeliveryApplication.class, args);
	}

}
