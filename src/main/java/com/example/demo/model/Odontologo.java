package com.example.demo.model;

import lombok.*;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "Odontologos")
@Getter
@Setter
public class Odontologo extends Usuario {

    private String matricula;

    @OneToMany(mappedBy = "odontologo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Turno> turnos;

}
