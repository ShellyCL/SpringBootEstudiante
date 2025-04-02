package com.universidad.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MateriaDTO {
    private long id;
    private String nombreMat;
    private String codigoUnico;
    private int creditos;    
}
