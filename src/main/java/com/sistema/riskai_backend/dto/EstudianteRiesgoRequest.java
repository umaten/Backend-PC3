package com.sistema.riskai_backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EstudianteRiesgoRequest {

    @NotNull @DecimalMin("0.0") @DecimalMax("20.0")
    @JsonProperty("promedio_actual")
    private Double promedioActual;

    @NotNull @Min(0) @Max(100)
    @JsonProperty("asistencia_pct")
    private Integer asistenciaPct;

    @NotNull @Min(0) @Max(100)
    @JsonProperty("tareas_entregadas_pct")
    private Integer tareasEntregadasPct;

    @NotNull @Min(0) @Max(100)
    @JsonProperty("participacion_pct")
    private Integer participacionPct;

    @NotNull @Min(0) @Max(40)
    @JsonProperty("horas_estudio_semana")
    private Integer horasEstudioSemana;

    @NotNull @DecimalMin("0.0") @DecimalMax("20.0")
    @JsonProperty("nota_pc_anterior")
    private Double notaPcAnterior;
}