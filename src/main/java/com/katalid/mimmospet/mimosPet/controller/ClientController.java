package com.katalid.mimmospet.mimosPet.controller;

import com.katalid.mimmospet.mimosPet.entity.Client;
import com.katalid.mimmospet.mimosPet.repository.PetRepository;
import com.katalid.mimmospet.mimosPet.repository.ClientRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "API Rest User")
@RestController
@RequestMapping("/v1/user")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PetRepository petRepository;


    @ApiOperation(value = "Register a User")
    @PostMapping(path = "/register")
    public ResponseEntity register(@RequestBody Client client){

        petRepository.saveAll(client.getPet());
        clientRepository.save(client);

        return ResponseEntity
                .ok()
                .body("");
    }
    @ApiOperation(value = "Updates a User")
    @PutMapping(path = "/update/{id}")
    public ResponseEntity UpdateUser(@PathVariable(name = "id")Long id) throws Exception{

        Client usuariodb = clientRepository
                .findById(id)
                .orElseThrow(()-> new Exception("User not found"));
        usuariodb.setNome(usuariodb.getNome());
        usuariodb.setPet(usuariodb.getPet());
        clientRepository.save(usuariodb);

        return ResponseEntity
                .ok()
                .body("");
    }
    @ApiOperation(value = "Finds a User by Id ")
    @GetMapping(path = "/{id}")
    public ResponseEntity FindsUserById(@PathVariable(name = "id") Long id) throws Exception{

        Client client = clientRepository.findById(id).orElseThrow(
                () -> new Exception("User not found"));

        return ResponseEntity
                .ok()
                .body(client);

    }
    @ApiOperation(value = "Find All Users")
    @GetMapping(path = "/")
    public ResponseEntity findAll(){

        return ResponseEntity
                .ok()
                .body(clientRepository.findAll());
    }

    @ApiOperation(value = "Deletes User by Id")
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity DeleteById(@PathVariable(name = "id")Long id) throws Exception{

        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new Exception("User not found"));
        clientRepository.delete(client);

        return ResponseEntity
                .ok()
                .body("");
    }

    @ApiOperation(value = "Delete all Users")
    @DeleteMapping(path = "deleteAll")
    public ResponseEntity deleteAll(){
        clientRepository.deleteAll();

        return ResponseEntity
                .ok()
                .body("");
    }

}
