package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "Odontologos")
@Getter
@Setter
public class Odontologo extends Usuario {
    private String matricula;

   // @JsonIgnore
   // @OneToMany(mappedBy = "odontologo")
   // private Set<Turno> turnos;
}
