package com.katalid.mimmospet.mimosPet.service;

import com.katalid.mimmospet.mimosPet.entity.Pet;
import com.katalid.mimmospet.mimosPet.entity.Usuario;
import com.katalid.mimmospet.mimosPet.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void cadastroUsuario(Usuario usuario){

    }
}
