package com.example.demo.service;



import com.example.demo.model.Paciente;
import com.example.demo.model.PacienteDTO;
import com.example.demo.repository.IPacienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PacienteService implements IPacienteService{

    @Autowired  //pasamanos, para comunicar las capas (?
    IPacienteRepository pacienteRepository;

    @Autowired
    ObjectMapper mapper; //

    @Override
    public void createPaciente(PacienteDTO pac) {
        savePaciente(pac);
    }

    @Override
    public PacienteDTO readPaciente(Long id) {
        Optional<Paciente> found = pacienteRepository.findById(id);
        return mapper.convertValue(found, PacienteDTO.class);
    }

    @Override
    public void updatePaciente(PacienteDTO pac) {
        savePaciente(pac);
    }
    private void savePaciente(PacienteDTO pac) {
        Paciente newPaciente = mapper.convertValue(pac, Paciente.class);
        pacienteRepository.save(newPaciente);
    }

    @Override
    public void deletePaciente(Long id) {
        pacienteRepository.deleteById(id);
    }

    @Override
    public Collection<PacienteDTO> getAll() {
        List<Paciente> allPacientes = pacienteRepository.findAll();
        Set<PacienteDTO> allPacientesDTO = new HashSet<PacienteDTO>();
        for(Paciente paciente: allPacientes)
            allPacientesDTO.add(mapper.convertValue(paciente,PacienteDTO.class));

        return allPacientesDTO;
    }

}
