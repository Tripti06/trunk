package com.example.myapplication;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan(basePackages={"com.example"})
@EntityScan("com.example.model")
@EnableJpaRepositories(basePackages = {"com.example.*"})
public class MyapplicationApplication {


	public static void main(String[] args) {
		SpringApplication.run(MyapplicationApplication.class, args);
	}

}
