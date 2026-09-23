package com.luis.api_tareas.request;

import jakarta.validation.constraints.NotBlank;

public class CrearTareaRequest {

    @NotBlank (message = "El título es obligatorio")
    private String titulo;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
