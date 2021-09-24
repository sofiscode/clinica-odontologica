package com.example.demo.model;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
public class DomicilioDTO {
        private Long id;
        private String calle;
        private int numero;
        private int piso;
        private String localidad;
        private String provincia;
}
