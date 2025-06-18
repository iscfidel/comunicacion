package com.stcm.test2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// import java.util.HashMap;
// import java.util.Map;

import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api")
public class SaludoProcesarController {

    @PostMapping(
        value = "/procesar-saludo",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public String procesarSaludo(@RequestBody String mensaje) {  // Recibe el String crudo
        System.out.println("Procesando solicitud: " + mensaje);
        // Devuelve un JSON válido (como String, pero con formato JSON)
        return mensaje;
    }
}