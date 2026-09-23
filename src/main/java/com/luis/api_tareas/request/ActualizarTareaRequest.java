package com.luis.api_tareas.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ActualizarTareaRequest {

    @NotBlank (message = "El título es obligatorio")
    private String titulo;

    @NotNull (message = "El estado completada es obligatorio")
    private Boolean completada;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Boolean getCompletada() {
        return completada;
    }

    public void setCompletada(Boolean completada) {
        this.completada = completada;
    }
}
