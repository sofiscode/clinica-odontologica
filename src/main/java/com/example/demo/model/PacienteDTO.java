package com.example.demo.model;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter @Setter
public class PacienteDTO extends UsuarioDTO{
    private DomicilioDTO domicilio;
    private Integer dni;
    private LocalDate fechaDeAlta;
   // private Set<Turno> turnos;
}
