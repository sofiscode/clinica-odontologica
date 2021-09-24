package com.example.demo.model;

import lombok.*;
import javax.persistence.*;
import java.util.List;
import java.time.LocalDate;


@Entity
@Table(name = "Pacientes")
@Getter
@Setter
public class Paciente extends Usuario{

    Integer dni;
    LocalDate fechaDeAlta;
    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Turno> turnos;

    @JoinColumn(name = "Domicilios_id")
    @OneToOne(fetch = FetchType.LAZY)
    private Domicilio domicilio;
}

