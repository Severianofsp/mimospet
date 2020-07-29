package com.katalid.mimmospet.mimosPet.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tutor")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @OneToMany
    @JoinColumn(name = "pet")
    private Set<Pet> pet;

    public Usuario(Long id, String nome, Set<Pet> pet) {
        this.id = id;
        this.nome = nome;
        this.pet = pet;
    }

    Usuario(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Pet> getPet() {

        return pet;
    }

    public void setPet(Set<Pet> pet) {
        this.pet = pet;
    }
}