package com.sistema.riskai_backend.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EstudianteRiesgoRequest {

    @NotNull @DecimalMin("0.0") @DecimalMax("20.0")
    private Double promedioActual;

    @NotNull @Min(0) @Max(100)
    private Integer asistenciaPct;

    @NotNull @Min(0) @Max(100)
    private Integer tareasEntregadasPct;

    @NotNull @Min(0) @Max(100)
    private Integer participacionPct;

    @NotNull @Min(0) @Max(40)
    private Integer horasEstudioSemana;

    @NotNull @DecimalMin("0.0") @DecimalMax("20.0")
    private Double notaPcAnterior;
}