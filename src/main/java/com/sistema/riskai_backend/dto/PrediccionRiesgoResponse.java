package com.sistema.riskai_backend.dto;

import lombok.Data;

import java.util.List;

@Data
public class PrediccionRiesgoResponse {
    private String prediccion;
    private Double confianza;
    private List<String> recomendaciones;
}