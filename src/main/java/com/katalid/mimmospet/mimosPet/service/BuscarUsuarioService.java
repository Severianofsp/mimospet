package com.katalid.mimmospet.mimosPet.service;

import com.katalid.mimmospet.mimosPet.entity.Usuario;
import com.katalid.mimmospet.mimosPet.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuscarUsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;


    public Optional<Usuario> buscarUsuarioPorID(){
        Optional<Usuario> listUsuario = usuarioRepository.findById(1L);
        return listUsuario;
    }

    public List <Usuario> buscarTodosUsuarios(){
        List<Usuario> listUsuario = usuarioRepository.findAll();
        return  listUsuario;
    }

}
