package com.example.demo.service;

import com.example.demo.model.Odontologo;
import com.example.demo.model.OdontologoDTO;
import java.util.Set;

import java.util.Collection;

public interface IOdontologoService {
    void createOdontologo(OdontologoDTO odo);
    OdontologoDTO readOdontologo(Long id);
    void updateOdontologo(OdontologoDTO odo);
    void deleteOdontologo(Long id);

    Collection<OdontologoDTO> getAll();
}
