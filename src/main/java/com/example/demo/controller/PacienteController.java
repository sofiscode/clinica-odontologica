package com.example.demo.controller;


import com.example.demo.model.PacienteDTO;
import com.example.demo.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    IPacienteService pacienteService;

    @PostMapping
    public ResponseEntity<?> addPaciente(@RequestBody PacienteDTO pac) {
        pacienteService.createPaciente(pac);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<?> modifyPaciente(@RequestBody PacienteDTO pac) {
        pacienteService.updatePaciente(pac);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removePaciente(@PathVariable Long id) {
        ResponseEntity<String> response = null;
        if (pacienteService.readPaciente(id) != null) {
            pacienteService.deletePaciente(id);
            response = ResponseEntity.status(HttpStatus.OK).body("Eliminado");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }
    @GetMapping("/list")
    public Collection<PacienteDTO> listPacientes() {
        return pacienteService.getAll();
    }

    @GetMapping("/{id}")
    public PacienteDTO listPaciente(@PathVariable Long id){
        PacienteDTO paciente =  pacienteService.readPaciente(id);
        return paciente;

    }
}
