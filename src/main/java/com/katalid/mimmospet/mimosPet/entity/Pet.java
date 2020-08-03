package com.katalid.mimmospet.mimosPet.entity;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.lang.NonNull;

import javax.validation.constraints.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "pet")
public class Pet {

    @Id
    @Column(name="id_pet")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(value = "Identifies a pet", example = "1")
    private Long id;

    @Column(name = "name")
    @NotNull(message = "The pet can not be create without a name")
    @ApiModelProperty(value = "Pet's name", example = "Lucky")
    private String nome;

    @Column(name = "type")
    @NotNull(message = "The pet can not be create without a type")
    @ApiModelProperty(value = "Pet's type", example = "Dog")
    private String type;

    @Column(name = "breed")
    @NotNull(message = "The pet can not be create without a breed")
    @ApiModelProperty(value = "Pet's breed",example = "Border collie")
    private String breed;


    public Pet(Long id, String nome, String type, String breed) {
        this.id = id;
        this.nome = nome;
        this.type = type;
        this.breed = breed;
    }
    public Pet(){}

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

}