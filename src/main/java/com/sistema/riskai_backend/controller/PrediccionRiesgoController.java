package com.sistema.riskai_backend.controller;

import com.sistema.riskai_backend.dto.EstudianteRiesgoRequest;
import com.sistema.riskai_backend.dto.PrediccionRiesgoResponse;
import com.sistema.riskai_backend.service.PrediccionRiesgoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/prediccion")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class PrediccionRiesgoController {

    private final PrediccionRiesgoService prediccionRiesgoService;

    @PostMapping("/utp-risk")
    public ResponseEntity<?> predecirRiesgo(@Valid @RequestBody EstudianteRiesgoRequest datos) {
        try {
            PrediccionRiesgoResponse resultado = prediccionRiesgoService.predecirRiesgo(datos);
            return ResponseEntity.ok(resultado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                    .body(Map.of("error", e.getMessage()));
        }
    }
}