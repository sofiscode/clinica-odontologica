package com.example.demo.model;


import lombok.*;

@Getter
@Setter
public class UsuarioDTO {
    private Long id;
    private String usuario;
    private String password;
    private String nombre;
    private String apellido;
    private RolDTO rol;
}
