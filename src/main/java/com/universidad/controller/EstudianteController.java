package com.universidad.controller;

import com.universidad.dto.EstudianteDTO;
import com.universidad.service.IEstudianteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EstudianteController {
    private final IEstudianteService estudianteService;

    @Autowired
    public EstudianteController(IEstudianteService estudianteService){
        this.estudianteService = estudianteService;
    }

    @GetMapping("/estudiantes")
    public ResponseEntity<List<EstudianteDTO>> obtenerTodosLosEstudiantes(){
        List<EstudianteDTO> estudiantes = estudianteService.obtenerTodosLosEstudiantes();
        return ResponseEntity.ok(estudiantes);
    }

    @GetMapping("/estudiantes/{id}")
    public ResponseEntity<EstudianteDTO> findById(@PathVariable Long id) {
        EstudianteDTO estudiante = estudianteService.findById(id);
        return estudiante != null 
                ? ResponseEntity.ok(estudiante) 
                : ResponseEntity.notFound().build();
    }    

    @PutMapping("/estudiantes/{id}")
    public ResponseEntity<EstudianteDTO> update(@PathVariable Long id, @RequestBody EstudianteDTO estudianteDTO) {
        EstudianteDTO updatedEstudiante = estudianteService.update(id, estudianteDTO);
        return updatedEstudiante != null 
                ? ResponseEntity.ok(updatedEstudiante) 
                : ResponseEntity.notFound().build();
    }    

    @DeleteMapping("/estudiantes/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        estudianteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
    @PostMapping
    public ResponseEntity<EstudianteDTO> crearEstudiante(@RequestBody EstudianteDTO estudianteDTO) {
        EstudianteDTO nuevoEstudiante = estudianteService.save(estudianteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoEstudiante);
    }    

}
