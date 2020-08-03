package com.katalid.mimmospet.mimosPet.repository;

import com.katalid.mimmospet.mimosPet.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Client,Long> {
}
