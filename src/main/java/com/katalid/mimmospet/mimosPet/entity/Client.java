package com.katalid.mimmospet.mimosPet.entity;

import io.swagger.annotations.ApiModelProperty;
import org.aspectj.bridge.IMessage;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "guardian")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @ApiModelProperty(value = "Identifies the name of the guardian")
    private Long id;

    @Column(name = "name")
    @ApiModelProperty(value = "Guardian's name", example = "Roberto")
    private String nome;

    @OneToMany
    @ApiModelProperty(value ="The pet's guadian")
    @JoinColumn(name = "pet_fk")
    private List<Pet> pet;

    public Client(Long id, String nome, List<Pet> pet) {
        this.id = id;
        this.nome = nome;
        this.pet = pet;
    }

    Client(){}

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

    public List<Pet> getPet() {

        return pet;
    }

    public void setPet(List<Pet> pet) {
        this.pet = pet;
    }
}