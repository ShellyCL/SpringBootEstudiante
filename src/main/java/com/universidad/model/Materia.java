package com.universidad.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Materia {
    private long id;
    private String nombreMat;
    private String codigoUnico;
    private int creditos;

    
}
