package com.katalid.mimmospet.mimosPet.controller;

import com.katalid.mimmospet.mimosPet.entity.Pet;
import com.katalid.mimmospet.mimosPet.repository.PetRepository;
import com.katalid.mimmospet.mimosPet.repository.ClientRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/pet")
public class PetController {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private ClientRepository clientRepository;

    @ApiOperation(value = "Register a Pet")
    @PostMapping(path = "/register")
    public ResponseEntity regiterAPet(@RequestBody Pet pet){

        petRepository.save(pet);

        return ResponseEntity
                .ok()
                .body("");
    }

    @ApiOperation(value = "Updates a Pet")
    @PutMapping(path = "/update/{id}")
    public ResponseEntity update(@PathVariable(name ="id")Long id) throws Exception{

        Pet petdb = petRepository.findById(id)
                .orElseThrow(() -> new Exception("Pet not found"));
        petdb.setNome(petdb.getNome());
        petdb.setBreed(petdb.getBreed());
        petdb.setType(petdb.getType());

        petRepository.save(petdb);

        return ResponseEntity
                .ok()
                .body("");
    }
    @ApiOperation(value = "Finds a Pet by Id")
    @GetMapping(path = "/{id}")
    public ResponseEntity findAPet(@PathVariable(name = "id")Long id) throws Exception{
        Pet petdb = petRepository
                .findById(id)
                .orElseThrow(()-> new Exception("Pet not found"));

        return ResponseEntity
                .ok()
                .body(petdb);
    }
    @ApiOperation(value = "List all Pets")
    @GetMapping(path = "/")
    public ResponseEntity listOfPets(){

        return ResponseEntity
                .ok()
                .body(petRepository.findAll());
    }

    @ApiOperation(value = "Delete a pet by Id")
    @DeleteMapping(path = "/deletar/{id}")
    public ResponseEntity deleteAPet(@PathVariable(name = "id")Long id) throws Exception {

        Pet pet = petRepository.findById(id)
                .orElseThrow(() -> new Exception("Pet not found"));
        petRepository.delete(pet);

        return ResponseEntity
                .ok()
                .body("");
    }

    @ApiOperation(value = "Delete all Pets")
    @DeleteMapping(path = "/deletartodos")
    public ResponseEntity deleteAllPets(@PathVariable(name = "id") Long id){
        petRepository.deleteAll();

        return ResponseEntity
                .ok()
                .body("");
    }





}
