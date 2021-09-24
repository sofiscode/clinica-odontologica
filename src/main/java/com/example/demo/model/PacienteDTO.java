package com.example.demo.model;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter @Setter
public class PacienteDTO {
    Long id;
    String nombre;
    String apellido;
    String domicilio;
    Integer dni;
    LocalDate fechaDeAlta;
    List<Turno> turnos;
}
