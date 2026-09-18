package com.luis.api_tareas.controller;

public class SaludoResponse {

    private String mensaje;

    public SaludoResponse(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }
}
