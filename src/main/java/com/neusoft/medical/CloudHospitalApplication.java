package com.neusoft.medical;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.neusoft.medical.dao")
public class CloudHospitalApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudHospitalApplication.class, args);
    }
}
