package com.luis.api_tareas.controller;

import com.luis.api_tareas.model.Tarea;
import com.luis.api_tareas.request.CrearTareaRequest;
import com.luis.api_tareas.request.ActualizarTareaRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class TareaController {

    private List<Tarea> tareas = new ArrayList<>();
    private Long siguienteId = 1L;

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
    public Tarea crearTarea(@Valid @RequestBody CrearTareaRequest request) {
        Long id = siguienteId;
        siguienteId++;

        Tarea tarea = new Tarea (id, request.getTitulo(), false);

        tareas.add(tarea);

        return tarea;
    }

    @DeleteMapping ("/tareas/{id}")
    @ResponseStatus (HttpStatus.NO_CONTENT)
    public void eliminarTarea(@PathVariable Long id) {
        for(int i = 0; i < tareas.size(); i++) {
            if (tareas.get(i).getId().equals(id)) {
                tareas.remove(i);
                return;
            }
        }
        throw new ResponseStatusException(
            HttpStatus.NOT_FOUND, 
            "No existe una tarea con id " + id);
    }

    @PutMapping ("/tareas/{id}")
    public Tarea actualizarTarea(
        @PathVariable Long id,
         @Valid @RequestBody ActualizarTareaRequest request) 
    {   
        for (Tarea tarea : tareas) {
            if (tarea.getId().equals(id)) {
                tarea.setTitulo(request.getTitulo());
                tarea.setCompletada(request.getCompletada());

                return tarea;
            }
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                 "No existe una tarea con id " + id);

    }
}
