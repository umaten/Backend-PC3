package com.sistema.riskai_backend.service;

import com.sistema.riskai_backend.dto.EstudianteRiesgoRequest;
import com.sistema.riskai_backend.dto.PrediccionRiesgoResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@RequiredArgsConstructor
public class PrediccionRiesgoService {

    private final RestTemplate restTemplate;

    @Value("${python.api.url}")
    private String pythonApiUrl;

    public PrediccionRiesgoResponse predecirRiesgo(EstudianteRiesgoRequest datos) {
        String url = pythonApiUrl + "/predict/utp-risk";
        try {
            return restTemplate.postForObject(url, datos, PrediccionRiesgoResponse.class);
        } catch (RestClientException e) {
            log.error("Error al llamar al servicio Python: {}", e.getMessage());
            throw new RuntimeException("No se pudo conectar con el servicio de predicción Python: " + e.getMessage());
        }
    }
}