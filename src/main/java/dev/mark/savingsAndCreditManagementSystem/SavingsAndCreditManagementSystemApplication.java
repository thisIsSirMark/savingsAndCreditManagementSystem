package dev.mark.savingsAndCreditManagementSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class SavingsAndCreditManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SavingsAndCreditManagementSystemApplication.class, args);
	}

	@Bean(name = "currentDate")
	public Date currentDate(){
		return new Date();
	}
}
