package com.example.demo.service;

import com.example.demo.model.Odontologo;
import com.example.demo.model.OdontologoDTO;
import com.example.demo.model.Rol;
import com.example.demo.model.RolDTO;
import com.example.demo.repository.IRolRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RolService implements IRolService{

    @Autowired
    IRolRepository rolRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public RolDTO readRol(Long id) {
        Optional<Rol> found = rolRepository.findById(id);
        return mapper.convertValue(found, RolDTO.class);
    }

}
