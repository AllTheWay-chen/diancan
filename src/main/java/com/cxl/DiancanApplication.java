package com.cxl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cxl.mapper")
public class DiancanApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiancanApplication.class, args);
	}

}
