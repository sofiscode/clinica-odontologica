package com.example.demo.model;

import lombok.*;
import javax.persistence.*;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Odontologos")
@Getter
@Setter
public class Odontologo {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String lastname;
    private String matricula;


//   @ManyToOne
   //@JoinColumn(name = "paciente_id")
   //private Paciente paciente;

   //private Set<Paciente> pacientes;
}
