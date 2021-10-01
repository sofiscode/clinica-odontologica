package com.example.demo.service;

import com.example.demo.model.Paciente;
import com.example.demo.model.PacienteDTO;
import com.example.demo.model.Turno;
import com.example.demo.model.TurnoDTO;

import com.example.demo.repository.ITurnoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class TurnoService implements ITurnoService {
    @Autowired
    ITurnoRepository turnoRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void createTurno(TurnoDTO turno) {
        saveTurno(turno);
    }

    private void saveTurno(TurnoDTO turno) {
        Turno newTurno = mapper.convertValue(turno, Turno.class);
        turnoRepository.save(newTurno);
    }


    @Override
    public TurnoDTO readTurno(Long id) {
        Optional<Turno> found = turnoRepository.findById(id);
        return mapper.convertValue(found, TurnoDTO.class);
    }

    @Override
    public void updateTurno(TurnoDTO turno) {
    Optional<Turno> turnoGuardado = turnoRepository.findById(turno.getId());
    }

    @Override
    public void deleteTurno(Long id) {
        turnoRepository.deleteById(id);
    }

    @Override
    public Collection<TurnoDTO> getAll() {
        List<Turno> allTurnos = turnoRepository.findAll();
        Set<TurnoDTO> allTurnoDTO = new HashSet<TurnoDTO>();
        for(Turno turno: allTurnos)
            allTurnoDTO.add(mapper.convertValue(turno,TurnoDTO.class));
        return allTurnoDTO;
    }
}
