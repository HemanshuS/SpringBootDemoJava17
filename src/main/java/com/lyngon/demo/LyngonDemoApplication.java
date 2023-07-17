package com.lyngon.demo;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.lyngon.demo.entity.Employee;
import com.lyngon.demo.repo.EmployeeRepository;

import jakarta.annotation.PostConstruct;


@SpringBootApplication

public class LyngonDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LyngonDemoApplication.class, args);
	}


	@Autowired
	private EmployeeRepository employeeRepository;

	@Bean
     ModelMapper modelMapper() {
		return new ModelMapper();
	}
	//**

	@PostConstruct
	public void init() {

		employeeRepository.saveAll(Stream.of(
				new Employee("Ajay", "aj@gmail.com",24, "23456"),

				new Employee("Vijay", "vj@gmail.com",34,"232424"),
				new Employee("Sanjay", "sj@gmail.com", 32, "2224242")

				).collect(Collectors.toList())

				);


	}//**/
}
