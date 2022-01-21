package com.mapexample.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mapexample.mapexample.model.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {

	  List<Pet> findByNameContaining(String name);
}