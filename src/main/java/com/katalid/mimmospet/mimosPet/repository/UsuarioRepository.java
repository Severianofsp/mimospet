package com.katalid.mimmospet.mimosPet.repository;

import com.katalid.mimmospet.mimosPet.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}
