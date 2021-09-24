package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class OdontologoDTO {
    private Long id;
    private String name;
    private String lastname;
    private String matricula;
    private List<Turno> turnos;
}
