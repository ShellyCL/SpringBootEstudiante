package com.universidad.service.impl;

import com.universidad.dto.EstudianteDTO;
import com.universidad.model.Estudiante;
import com.universidad.repository.EstudianteRepository;
import com.universidad.service.IEstudianteService;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public class EstudianteServiceImpl implements IEstudianteService{

    private final EstudianteRepository estudianteRepository;

    @Autowired
    public EstudianteServiceImpl(EstudianteRepository estudianteRepository){
        this.estudianteRepository = estudianteRepository;
    }

    @PostConstruct
    public void init(){
        estudianteRepository.init();
    }

    @Override
    public List<EstudianteDTO> obtenerTodosLosEstudiantes(){
            List<Estudiante> estudiantes = estudianteRepository.findAll();
            List<EstudianteDTO> estudiantesDTO = new ArrayList<>();

            for (Estudiante estudiante : estudiantes){
                estudiantesDTO.add(convertToDTO(estudiante));

            }
            return estudiantesDTO;

    }

    @Override
    public EstudianteDTO findById(Long id) {
        Estudiante estudiante = estudianteRepository.findById(id);
        return estudiante != null ? convertToDTO(estudiante) : null;
    }

    @Override
    public EstudianteDTO update(Long id, EstudianteDTO estudianteDTO) {
        if (!estudianteRepository.existsById(id)) {
            return null;
        }
        Estudiante estudiante = convertToEntity(estudianteDTO);
        estudiante.setId(id);
        estudiante = estudianteRepository.save(estudiante);
        return convertToDTO(estudiante);
    }
    @Override
    public void deleteById(Long id) {
        estudianteRepository.deleteById(id);
    }   
     

    @Override
    public EstudianteDTO save(EstudianteDTO estudianteDTO) {
        Estudiante estudiante = convertToEntity(estudianteDTO);
        Estudiante estudianteGuardado = estudianteRepository.save(estudiante);
        return convertToDTO(estudianteGuardado);
    }

    private EstudianteDTO convertToDTO(Estudiante estudiante){
        return EstudianteDTO.builder()
                .id(estudiante.getId())
                .nombre(estudiante.getNombre())
                .apellido(estudiante.getApellido())
                .email(estudiante.getEmail())
                .fnac(estudiante.getFnac())
                .numeroInscripcion(estudiante.getNumeroInscripcion())
                .build();
    }

    //metodo auxiliar para convertir DTO a entidad
    private Estudiante convertToEntity(EstudianteDTO estudianteDTO){
        return Estudiante.builder()
                .id(estudianteDTO.getId())
                .nombre(estudianteDTO.getNombre())
                .apellido(estudianteDTO.getApellido())
                .email(estudianteDTO.getEmail())
                .fnac(estudianteDTO.getFnac())
                .numeroInscripcion(estudianteDTO.getNumeroInscripcion())
                .build();
    }
    
}
