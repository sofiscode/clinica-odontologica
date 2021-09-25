package com.example.demo.service;

import com.example.demo.model.Odontologo;
import com.example.demo.model.OdontologoDTO;
import com.example.demo.model.RolDTO;
import com.example.demo.repository.IOdontologoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OdontologoService implements IOdontologoService{

    @Autowired  //pasamanos, para comunicar las capas (?
    IOdontologoRepository odontologoRepository;

    @Autowired
    IRolService rolService;

    @Autowired
    ObjectMapper mapper; //

    @Override
    public void createOdontologo(OdontologoDTO odo) {
        RolDTO rol = rolService.readRol(2L); //L long
        odo.setRol(rol);
        saveOdontologo(odo);
    }
    private void saveOdontologo(OdontologoDTO odo) {
        Odontologo newOdontologo = mapper.convertValue(odo, Odontologo.class);
        odontologoRepository.save(newOdontologo);
    }

    @Override
    public OdontologoDTO readOdontologo(Long id) {
        Optional<Odontologo> found = odontologoRepository.findById(id);
        return mapper.convertValue(found, OdontologoDTO.class);
    }

    @Override
    public void updateOdontologo(OdontologoDTO odo) {
        saveOdontologo(odo);
    }



    @Override
    public void deleteOdontologo(Long id) {
        odontologoRepository.deleteById(id);
    }

    @Override
    public Collection<OdontologoDTO> getAll() {
        List<Odontologo> allOdontologos = odontologoRepository.findAll();
        Set<OdontologoDTO> allOdontologosDTO = new HashSet<OdontologoDTO>();
        for(Odontologo odontologo: allOdontologos)
            allOdontologosDTO.add(mapper.convertValue(odontologo,OdontologoDTO.class));

        return allOdontologosDTO;
    }

}
