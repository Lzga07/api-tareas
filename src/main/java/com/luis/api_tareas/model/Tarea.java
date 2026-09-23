package com.luis.api_tareas.model;

public class Tarea {

    private Long id;
    private String titulo;
    private boolean completada;

    public Tarea(Long id, String titulo, boolean completada) {
        this.id = id;
        this.titulo = titulo;
        this.completada = completada;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setTitulo (String titulo) {
        this.titulo = titulo;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

}
