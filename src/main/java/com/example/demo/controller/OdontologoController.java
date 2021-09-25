package com.example.demo.controller;

import com.example.demo.model.OdontologoDTO;
import com.example.demo.model.PacienteDTO;
import com.example.demo.service.IOdontologoService;
import com.example.demo.service.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Set;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    @Autowired
    IOdontologoService odontologoService;



    @PostMapping
    public ResponseEntity<?> addOdontologo(@RequestBody OdontologoDTO odo) {
        odontologoService.createOdontologo(odo);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<?> modifyOdontologo(@RequestBody OdontologoDTO odo) {
        odontologoService.updateOdontologo(odo);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeOdontologo(@PathVariable Long id) {
        ResponseEntity<String> response = null;
        if (odontologoService.readOdontologo(id) != null) {
            odontologoService.deleteOdontologo(id);
            response = ResponseEntity.status(HttpStatus.OK).body("Eliminado");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }
    @GetMapping("/list")
    public Collection<OdontologoDTO> listOdontolgo() {
        return odontologoService.getAll();
    }

    @GetMapping("/{id}")
    public OdontologoDTO listPaciente(@PathVariable Long id){
        OdontologoDTO odontologo =  odontologoService.readOdontologo(id);
        return odontologo;

    }
}
