package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter @Setter
public class Paciente {

    @Id
    @GeneratedValue
    Long id;
    String nombre;
    String apellido;
    String domicilio;
    Integer dni;
    LocalDate fechaDeAlta;


}