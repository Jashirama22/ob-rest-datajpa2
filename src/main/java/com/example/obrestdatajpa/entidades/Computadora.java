package com.example.obrestdatajpa.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "tablaComputadora")
public class Computadora {

    //atributos

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String modelo;
    private Integer agno;
    //costructores

    public Computadora() {
    }

    public Computadora(Long id, String marca, String modelo, Integer agno) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.agno = agno;
    }

    //get y set

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAgno() {
        return agno;
    }

    public void setAgno(Integer agno) {
        this.agno = agno;
    }

    // toString


}
