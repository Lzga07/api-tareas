package com.luis.api_tareas.controller;

import com.luis.api_tareas.model.Tarea;
import com.luis.api_tareas.request.CrearTareaRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.PathVariable;

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

    @GetMapping ("/tareas/{id}")
    public Tarea buscarPorId(@PathVariable Long id) {
        for (Tarea tarea : tareas) {
            if (tarea.getId().equals(id)) {
                return tarea;
            }
        }

        throw new ResponseStatusException(
            HttpStatus.NOT_FOUND, "No existe una tarea con id " + id);
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
