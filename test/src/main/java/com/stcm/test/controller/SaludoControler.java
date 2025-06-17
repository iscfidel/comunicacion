package com.stcm.test.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/api/test")
@CrossOrigin(origins = "*") // Para desarrollo
public class SaludoControler {

    @PostMapping(value = "/saludo", consumes = MediaType.APPLICATION_JSON_VALUE, // Asegura que solo acepte JSON
    produces = MediaType.APPLICATION_JSON_VALUE)
    public String saludar(@RequestBody String solicitud) {
        System.out.println("Solicitud recibida: " + solicitud);
        // TODO: process POST request
        // Send the message to API 2...
        RestTemplate restTemplate = new RestTemplate();
        String url2 = "http://localhost:8082/api/procesar-saludo";
        // Configura headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON); // ¡Clave!

        // Crea la entidad HTTP con headers y cuerpo
        HttpEntity<String> request = new HttpEntity<>(solicitud, headers);

        String response = restTemplate.postForObject(url2, request, String.class);
        return response;
    }

}
