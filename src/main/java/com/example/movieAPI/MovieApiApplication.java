package com.example.movieAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={
		"com.example.movieAPI.Controllers",
		"com.example.movieAPI.Models",
		"com.example.movieAPI.Repository",
		"com.example.movieAPI.Service"
})
public class MovieApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(MovieApiApplication.class, args);
	}
}
