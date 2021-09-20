package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "Pacientes")
@Getter
@Setter
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
