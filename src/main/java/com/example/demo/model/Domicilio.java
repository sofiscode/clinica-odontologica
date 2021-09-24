package com.example.demo.model;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name="Domicilios")
@Getter
@Setter

public class Domicilio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String calle;
    private int numero;
    private int piso;
    private String localidad;
    private String provincia;

}
