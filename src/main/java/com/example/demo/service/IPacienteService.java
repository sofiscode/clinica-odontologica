package com.example.demo.service;

import com.example.demo.model.PacienteDTO;

import java.util.Collection;

public interface IPacienteService {
    void createPaciente(PacienteDTO pac);
    PacienteDTO readPaciente(Long id);
    void updatePaciente(PacienteDTO pac);
    void deletePaciente(Long id);

    Collection<PacienteDTO> getAll();
}

