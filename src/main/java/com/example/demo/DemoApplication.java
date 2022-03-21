package com.example.demo;


import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController()
@CrossOrigin
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping(path ="/users", produces = MediaType.APPLICATION_JSON_VALUE)
	public Object  hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		Resource resource = new ClassPathResource("/static/json/beer.json");
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(resource.getInputStream(), Object.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
	}

}
