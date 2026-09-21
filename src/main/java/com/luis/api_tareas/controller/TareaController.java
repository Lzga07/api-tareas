package com.luis.api_tareas.controller;

import com.luis.api_tareas.model.Tarea;
import com.luis.api_tareas.request.CrearTareaRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class TareaController {

    private List<Tarea> tareas = new ArrayList<>();

    @GetMapping ("/tareas")
    public List<Tarea> listarTareas() {
        return tareas;
    }

    @PostMapping ("/tareas")
    @ResponseStatus (HttpStatus.CREATED)
    public Tarea crearTarea(@RequestBody CrearTareaRequest request) {
        Long id = (long) tareas.size() + 1;

        Tarea tarea = new Tarea (id, request.getTitulo(), false);

        tareas.add(tarea);

        return tarea;
    }
}
