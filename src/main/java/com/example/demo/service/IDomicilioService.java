package com.example.demo.service;
import com.example.demo.model.DomicilioDTO;

public interface IDomicilioService {
    DomicilioDTO readDomicilio(Long id);
    Long createDomicilio(DomicilioDTO dom);
    void updateDomicilio(DomicilioDTO dom);
    void deleteDomicilio(Long id);

}


