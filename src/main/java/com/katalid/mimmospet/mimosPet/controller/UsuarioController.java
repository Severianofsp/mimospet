package com.katalid.mimmospet.mimosPet.controller;

import ch.qos.logback.core.net.server.Client;
import com.katalid.mimmospet.mimosPet.entity.Pet;
import com.katalid.mimmospet.mimosPet.entity.Usuario;
import com.katalid.mimmospet.mimosPet.repository.PetRepository;
import com.katalid.mimmospet.mimosPet.repository.UsuarioRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Api(value = "API Rest Usuario")
@RestController
@RequestMapping("/v1/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PetRepository petRepository;


    @ApiOperation(value = "Salva um Usuário")
    @PostMapping(path = "/cadastrar")
    public ResponseEntity cadastrar(@RequestBody Usuario usuario){

        petRepository.saveAll(usuario.getPet());
        usuarioRepository.save(usuario);

        return ResponseEntity
                .ok()
                .body("");
    }
    @PutMapping(path = "/atualizar/{id}")
    public ResponseEntity atualizarUsuario(@PathVariable(name = "id")Long id) throws Exception{

        Usuario usuariodb = usuarioRepository
                .findById(id)
                .orElseThrow(()-> new Exception("User didn't found"));
        usuariodb.setNome(usuariodb.getNome());
        usuariodb.setPet(usuariodb.getPet());
        usuarioRepository.save(usuariodb);

        return ResponseEntity
                .ok()
                .body("");
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity buscarPorId(@PathVariable(name = "id") Long id){

        return ResponseEntity
                .ok()
                .body(usuarioRepository.findById(id));

    }
    @GetMapping(path = "/")
    public ResponseEntity buscarTodos(){

        return ResponseEntity
                .ok()
                .body(usuarioRepository.findAll());
    }

    @DeleteMapping(path = "/Deletar/{id}")
    public ResponseEntity DeletarPorId(@PathVariable(name = "id")Long id) throws Exception{

        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new Exception("O pet não foi encontrado na base"));
        usuarioRepository.delete(usuario);

        return ResponseEntity
                .ok()
                .body("");
    }

    @DeleteMapping(path = "Deletartodos")
    public ResponseEntity deletarTodos(){
        usuarioRepository.deleteAll();

        return ResponseEntity
                .ok()
                .body("");
    }

}
