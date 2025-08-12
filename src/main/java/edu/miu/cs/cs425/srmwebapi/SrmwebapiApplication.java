package edu.miu.cs.cs425.srmwebapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SrmwebapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SrmwebapiApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            System.out.println("Hello World\nWelcome to the SRM WebAPI");
            System.out.println("Server started...\n For List of Suppliers, go to http://localhost:8080/srm/api/v1/supplier");
        };
    }

}
