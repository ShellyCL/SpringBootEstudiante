package com.universidad.service;
import java.util.List;
import com.universidad.dto.EstudianteDTO;
//import com.universidad.model.Estudiante;

public interface IEstudianteService {
    public List<EstudianteDTO> obtenerTodosLosEstudiantes();
    EstudianteDTO findById(Long id);
    EstudianteDTO update(Long id, EstudianteDTO estudianteDTO);
    void deleteById(Long id);
    EstudianteDTO save(EstudianteDTO estudianteDTO);
}
