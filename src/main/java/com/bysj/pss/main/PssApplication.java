package com.bysj.pss.main;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bysj.pss")
public class PssApplication {

	public static void main(String[] args) {
		SpringApplication.run(PssApplication.class, args);
	}
}
