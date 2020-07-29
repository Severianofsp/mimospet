package com.katalid.mimmospet.mimosPet.controller;

import com.katalid.mimmospet.mimosPet.entity.Pet;
import com.katalid.mimmospet.mimosPet.entity.Usuario;
import com.katalid.mimmospet.mimosPet.repository.PetRepository;
import com.katalid.mimmospet.mimosPet.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/pet")
public class PetController {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping(path = "/cadastrar")
    public ResponseEntity criarPet(@RequestBody Pet pet){

        petRepository.save(pet);

        return ResponseEntity
                .ok()
                .body("");
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity update(@PathVariable(name ="id")Long id) throws Exception{

        Pet petdb = petRepository.findById(id)
                .orElseThrow(() -> new Exception("Pet didn't found"));
        petdb.setNome(petdb.getNome());
        petdb.setRaca(petdb.getRaca());
        petdb.setTipo(petdb.getTipo());

        petRepository.save(petdb);

        return ResponseEntity
                .ok()
                .body("");
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity buscarPet(@PathVariable(name = "id")Long id) throws Exception{
        Pet petdb = petRepository
                .findById(id)
                .orElseThrow(()-> new Exception("pet não encontrado"));

        return ResponseEntity
                .ok()
                .body(petdb);
    }
    @GetMapping(path = "/")
    public ResponseEntity listarPets(){

        return ResponseEntity
                .ok()
                .body(petRepository.findAll());
    }

    @DeleteMapping(path = "/deletar/{id}")
    public ResponseEntity deletar(@PathVariable(name = "id")Long id) throws Exception {

        Pet pet = petRepository.findById(id)
                .orElseThrow(() -> new Exception("Pet não encontrado"));
        petRepository.delete(pet);

        return ResponseEntity
                .ok()
                .body("");
    }

    @DeleteMapping(path = "/deletartodos")
    public ResponseEntity deletarTodos(@PathVariable(name = "id") Long id){
        petRepository.deleteAll();

        return ResponseEntity
                .ok()
                .body("");
    }





}
