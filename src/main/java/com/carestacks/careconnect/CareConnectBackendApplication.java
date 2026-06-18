package com.carestacks.careconnect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class CareConnectBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(CareConnectBackendApplication.class, args);
    }
}
