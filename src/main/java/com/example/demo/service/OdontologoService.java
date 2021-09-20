package com.example.demo.service;

import com.example.demo.model.Odontologo;
import com.example.demo.model.OdontologoDTO;
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
    ObjectMapper mapper; //

    @Override
    public void createOdontologo(OdontologoDTO stu) {
        saveOdontologo(stu);
    }

    @Override
    public OdontologoDTO readOdontologo(Long id) {
        Optional<Odontologo> found = odontologoRepository.findById(id);
        return mapper.convertValue(found, OdontologoDTO.class);
    }

    @Override
    public void updateOdontologo(OdontologoDTO stu) {
        saveOdontologo(stu);
    }
    private void saveOdontologo(OdontologoDTO stu) {
        Odontologo newStudent = mapper.convertValue(stu, Odontologo.class);
        odontologoRepository.save(newStudent);
    }

    @Override
    public void deleteOdontologo(Long id) {
        odontologoRepository.deleteById(id);
    }

    @Override
    public Collection<OdontologoDTO> getAll() {
        List<Odontologo> allStudents = odontologoRepository.findAll();
        Set<OdontologoDTO> allStudentsDTO = new HashSet<OdontologoDTO>();
        for(Odontologo student: allStudents)
            allStudentsDTO.add(mapper.convertValue(student,OdontologoDTO.class));

        return allStudentsDTO;
    }

}
