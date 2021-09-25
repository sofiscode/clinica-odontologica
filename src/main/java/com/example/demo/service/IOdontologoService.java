package com.example.demo.service;
import com.example.demo.model.OdontologoDTO;

import java.util.Collection;

public interface IOdontologoService {
    void createOdontologo(OdontologoDTO odo);
    OdontologoDTO readOdontologo(Long id);
    void updateOdontologo(OdontologoDTO odo);
    void deleteOdontologo(Long id);
    Collection<OdontologoDTO> getAll();
}
