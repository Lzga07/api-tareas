package com.luis.api_tareas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class SaludoController {

    @GetMapping ("/saludo")
    public SaludoResponse saludar() {
        return new SaludoResponse("Hola desde mi API");
    }
}
