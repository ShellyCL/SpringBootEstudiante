package com.universidad.repository;

import com.universidad.model.Estudiante;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class EstudianteRepository {
    private final Map<Long, Estudiante> estudiantes = new ConcurrentHashMap<>();
    private final AtomicLong idContador = new AtomicLong(1); 
    
    public Estudiante save(Estudiante estudiante){
        if(estudiante.getId() == null){
            estudiante.setId(idContador.getAndIncrement());
        }
        estudiantes.put(estudiante.getId(), estudiante);
        return estudiante;
    }

    public List<Estudiante>findAll(){
        return new ArrayList<>(estudiantes.values());
    }

    public void deleteById(Long id){
        estudiantes.remove(id);
    }

    public boolean existsById(Long id){
        return estudiantes.containsKey(id);
    }

    public Estudiante findById(Long id) {
        return estudiantes.get(id);
    }
    
    //Metodo para inicializar algunos datos de ejemplo con la ayuda de lombok

    public void init(){
        Estudiante estudiante1 = Estudiante.builder()
                .nombre("Juan")
                .apellido("Perez")
                .email("juan.perez@google.com")
                .fnac(LocalDate.of(2000,5,15))
                .numeroInscripcion(5001)
                .build();
        Estudiante estudiante2 = Estudiante.builder()
                .nombre("Maria")
                .apellido("Gonzales")
                .email("maria.gonzales@google.com")
                .fnac(LocalDate.of(2001,8,22))
                .numeroInscripcion(5002)
                .build();    

        save(estudiante1); 
        save(estudiante2);              
    }   
}
