package com.example.demo.model;

import lombok.*;


import javax.persistence.*;

@Entity
@Table(name = "Roles")
@Getter
@Setter
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;


}
