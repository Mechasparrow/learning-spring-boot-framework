package com.mapexample.mapexample;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mapexample.mapexample.model.Pet;
import com.mapexample.repositories.PetRepository;

@SpringBootApplication
@EnableJpaRepositories("com.mapexample.repositories")
@RestController
public class MapexampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MapexampleApplication.class, args);
	}

	@Autowired
	PetRepository petRepository;
	
	@GetMapping("/pets")
	public ResponseEntity<List<Pet>> getAllTutorials(@RequestParam(required = false) String name) {
		try {
			List<Pet> pets = new ArrayList<Pet>();

			if (name == null)
				petRepository.findAll().forEach(pets::add);
			else
				petRepository.findByNameContaining(name).forEach(pets::add);

			if (pets.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(pets, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
