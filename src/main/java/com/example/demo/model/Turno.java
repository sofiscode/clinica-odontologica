package com.example.demo.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Turnos")
@Getter
@Setter

public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date fechaHora;
    @ManyToOne()
    @JoinColumn(name = "Odontologos_id")
    private Odontologo odontologo;

    @ManyToOne()
    @JoinColumn(name = "Pacientes_id")
    private Paciente paciente;



}
