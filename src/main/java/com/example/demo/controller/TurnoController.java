package com.example.demo.controller;

import com.example.demo.model.TurnoDTO;
import com.example.demo.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    ITurnoService turnoService;

    @GetMapping("/list")
    public Collection<TurnoDTO> listTurnos() {
        return turnoService.getAll();
    }
    @GetMapping("/list/{id}")
    public Collection<TurnoDTO> listTurnos(@PathVariable Long id) {
        return turnoService.getAllbyOdontologoId(id);
    }

    @PostMapping
    public ResponseEntity<?> addTurno(@RequestBody TurnoDTO turno) {
        turnoService.createTurno(turno);
        return ResponseEntity.ok(HttpStatus.OK);
    }


    @PutMapping()
    public ResponseEntity<?> modifyTurno(@RequestBody TurnoDTO turno) {
        turnoService.updateTurno(turno);
        return ResponseEntity.ok(HttpStatus.OK);
    }



    @GetMapping("/{id}")
    public TurnoDTO listTurno(@PathVariable Long id) {
        TurnoDTO turno = turnoService.readTurno(id);
        return turno;

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeTurno(@PathVariable Long id){
        ResponseEntity<String> response = null;
        if (turnoService.readTurno(id) != null) {
            turnoService.deleteTurno(id);
            response = ResponseEntity.status(HttpStatus.OK).body("Turno eliminado");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }
}
