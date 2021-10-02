package com.example.demo.service;
import com.example.demo.model.TurnoDTO;
import java.util.Collection;

public interface ITurnoService {
    void createTurno(TurnoDTO turno);
    TurnoDTO readTurno(Long id);
    void updateTurno(TurnoDTO turno);
    void deleteTurno(Long id);
    Collection<TurnoDTO> getAll();
    Collection<TurnoDTO> getAllbyOdontologoId(Long id);
}
