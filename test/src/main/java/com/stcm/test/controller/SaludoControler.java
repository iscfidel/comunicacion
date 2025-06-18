package com.stcm.test.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/api/test")
@CrossOrigin(origins = "*") // Para desarrollo
public class SaludoControler {

    @PostMapping("/saludo")
    public ResponseEntity<String> saludar(@RequestBody Map<String, String> request) {
        String mensaje = request.get("mensaje"); // Extrae el campo "mensaje"
        System.out.println("Solicitud recibida: " + mensaje);

        RestTemplate restTemplate = new RestTemplate();
        String url2 = "http://localhost:8082/api/procesar-saludo";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Envía el mensaje como JSON (no como String crudo)
        HttpEntity<Map<String, String>> requestApi2 = new HttpEntity<>(
                Collections.singletonMap("mensaje", mensaje), // Equivalente a Map.of() en Java 8
                headers);
        String response = restTemplate.postForObject(url2, requestApi2, String.class);
        System.out.println("Respuesta de la API 2: " + response);

        return ResponseEntity.ok().body(response);
    }

}
