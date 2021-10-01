package com.example.demo.service;

import com.example.demo.model.Domicilio;
import com.example.demo.model.DomicilioDTO;
import com.example.demo.model.Odontologo;
import com.example.demo.model.OdontologoDTO;
import com.example.demo.repository.IDomicilioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.ObjectError;

@Service
public class DomicilioService implements IDomicilioService{

    @Autowired
    IDomicilioRepository domicilioRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public DomicilioDTO readDomicilio(Long id) {
        return null;
    }

    @Override
    public Long createDomicilio(DomicilioDTO dom) {
         return saveDomicilio(dom);
    }

    private Long saveDomicilio(DomicilioDTO dom) {
        Domicilio newDomicilio = mapper.convertValue(dom, Domicilio.class);
        domicilioRepository.save(newDomicilio);
        return newDomicilio.getId();
    }

    @Override
    public void updateDomicilio(DomicilioDTO dom) {
    }

    @Override
    public void deleteDomicilio(Long id) {
        domicilioRepository.deleteById(id);
    }
}
