package com.example.demo.repository;

import com.example.demo.model.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDomicilioRepository extends JpaRepository<Domicilio,Long> {
}
