package com.katalid.mimmospet.mimosPet.controller;

import com.katalid.mimmospet.mimosPet.entity.Pet;
import com.katalid.mimmospet.mimosPet.entity.Usuario;
import com.katalid.mimmospet.mimosPet.repository.PetRepository;
import com.katalid.mimmospet.mimosPet.repository.UsuarioRepository;
import com.katalid.mimmospet.mimosPet.service.BuscarUsuarioService;
import com.katalid.mimmospet.mimosPet.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private BuscarUsuarioService servicoBuscar;

    @Autowired
    private PetRepository petRepository;

    @GetMapping(path = "/usuario/{id}")
    public Optional <Usuario> buscarUsuarioPorID(
            @PathVariable(name = "id", required = true) Long id){
        return  usuarioRepository.findById(id);
    }

    @GetMapping(path = "/usuario")
    public List <Usuario> buscarTodosUsuarios(){
        return usuarioRepository.findAll();
    }

    @PostMapping(path = "usuario/save")
    public void cadastrarUsuario(Usuario usuario){

            usuarioRepository.saveAndFlush(usuario);

    }

    @DeleteMapping(path ="usuario/deletar/{id}")
    public void deletarUsuarioPelaId(@PathVariable(name = "id", required = true)Long id){
        usuarioRepository.deleteById(id);
    }

}
