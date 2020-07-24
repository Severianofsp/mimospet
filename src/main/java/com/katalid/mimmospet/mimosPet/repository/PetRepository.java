package com.katalid.mimmospet.mimosPet.repository;

import com.katalid.mimmospet.mimosPet.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {
}
