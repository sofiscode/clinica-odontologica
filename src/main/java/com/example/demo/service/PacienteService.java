package com.example.demo.service;



import com.example.demo.model.*;
import com.example.demo.repository.IPacienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class PacienteService implements IPacienteService{

    @Autowired  //pasamanos, para comunicar las capas (?
    IPacienteRepository pacienteRepository;

    @Autowired
    IRolService rolService;

    @Autowired
    IDomicilioService domicilioService;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void createPaciente(PacienteDTO pac) {
        RolDTO rol = rolService.readRol(3L);
        pac.setRol(rol);

        DomicilioDTO dom = pac.getDomicilio();
        Long idDomicilio = domicilioService.createDomicilio(dom);
        dom.setId(idDomicilio);
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
        LocalDate fecha = LocalDate.now();
        newPaciente.setFechaDeAlta(fecha);
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
            allPacientesDTO.add(
                    mapper.convertValue(paciente,PacienteDTO.class));

        return allPacientesDTO;
    }

}
