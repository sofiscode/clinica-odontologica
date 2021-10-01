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
        savePaciente(pac);
    }

    @Override
    public PacienteDTO readPaciente(Long id) {
       //optional indica que el objeto es de tipo <X> pero que tambien puede ser nulo
        /*La diferencia es lo que retorna, getById devuelve la clase y findById devuelve un Optional de la clase.
Cuando traés un Optional tenés que poner un .get() luego para tener el objeto, así que el getById() te ahorra un paso.
*/
        Optional<Paciente> found = pacienteRepository.findById(id);
        return mapper.convertValue(found, PacienteDTO.class); //al objeto X convertilo a un objeto de clase paciente dto. si fuera .string, convertiria en tipo string (por ejemplo para saber elt itulo de la clase)
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
