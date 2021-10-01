package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.util.List;
import java.time.LocalDate;
import java.util.Set;


@Entity
@Table(name = "Pacientes")
@Getter
@Setter
public class Paciente extends Usuario{

    Integer dni;
    LocalDate fechaDeAlta;
   /* @JsonIgnore
    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Turno> turnos;
*/
    //@JsonIgnore
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "Domicilios_id")
    private Domicilio domicilio;
}
