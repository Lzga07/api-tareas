package com.luis.api_tareas.controller;

import com.luis.api_tareas.model.Tarea;
import com.luis.api_tareas.request.CrearTareaRequest;
import com.luis.api_tareas.request.ActualizarTareaRequest;
import com.luis.api_tareas.service.TareaService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class TareaController {

    private final TareaService tareaService;

    public TareaController(TareaService tareaService) {
        this.tareaService = tareaService;
    }

    @GetMapping ("/tareas")
    public List<Tarea> listarTareas() {
        return tareaService.listarTarea();
    }

    @GetMapping ("/tareas/{id}")
    public Tarea buscarPorId(@PathVariable Long id) {
        Tarea tarea = tareaService.buscarPorId(id);

        if (tarea == null) {
            throw new ResponseStatusException(
            HttpStatus.NOT_FOUND, "No existe una tarea con id " + id);
        }

        return tarea;
    }

    @PostMapping ("/tareas")
    @ResponseStatus (HttpStatus.CREATED)
    public Tarea crearTarea(@Valid @RequestBody CrearTareaRequest request) {
        return tareaService.crearTarea(request.getTitulo());
    }

    @DeleteMapping ("/tareas/{id}")
    @ResponseStatus (HttpStatus.NO_CONTENT)
    public void eliminarTarea(@PathVariable Long id) {
        boolean eliminada = tareaService.eliminarTarea(id);

        if (!eliminada) {
            throw new ResponseStatusException(
            HttpStatus.NOT_FOUND, 
            "No existe una tarea con id " + id);
        }
    }

    @PutMapping ("/tareas/{id}")
    public Tarea actualizarTarea(
        @PathVariable Long id,
         @Valid @RequestBody ActualizarTareaRequest request) 
    {   
        Tarea tarea = tareaService.actualizarTarea(id, request.getTitulo(), request.getCompletada());

        if (tarea == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                 "No existe una tarea con id " + id);
        }
        
        return tarea;
    }
}
