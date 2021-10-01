package com.example.demo.model;

import com.example.demo.model.Odontologo;
import com.example.demo.model.Paciente;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;


@Getter
@Setter

public class TurnoDTO {
    @Id
    @GeneratedValue
    private Long id;
    private Odontologo odontologo;
    private Paciente paciente;
    private LocalDateTime fechaHora;
    private boolean disponible;

}