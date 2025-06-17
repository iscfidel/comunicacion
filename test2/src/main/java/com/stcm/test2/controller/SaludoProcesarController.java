package com.stcm.test2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api")
public class SaludoProcesarController {

    @PostMapping(value = "/procesar-saludo", consumes = MediaType.APPLICATION_JSON_VALUE, // Asegura que solo acepte JSON
    produces = MediaType.APPLICATION_JSON_VALUE)
    public String procesarSaludo(@RequestBody SaludoProcesarController solicitud) {
        return "¡Hola, " + solicitud + "! Este saludo viene de API 2.";
    }

    Map<String, Object> saludoProcesar(@RequestBody Map<String, Object> solicitud) {
        solicitud.put("titulo", "yoese");
        return solicitud;
    }

}
