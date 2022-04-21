package com.example.scucovid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ScucovidApplication {
	@GetMapping("/message")
	public String message() {
		return "Finish!";
	}
	public static void main(String[] args) {
		SpringApplication.run(ScucovidApplication.class, args);
	}

}
