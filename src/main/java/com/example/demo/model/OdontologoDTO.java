package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class OdontologoDTO extends UsuarioDTO{

    private String matricula;
    //private Set<Turno> turnos;
}
