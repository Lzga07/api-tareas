package com.luis.api_tareas.service;

import com.luis.api_tareas.model.Tarea;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service 
public class TareaService {

    private List<Tarea> tareas = new ArrayList<>();
    private Long siguienteId = 1L;

    public List<Tarea> listarTarea() {
        return tareas;
    }

    public Tarea crearTarea(String titulo) {
        Long id = siguienteId;
        siguienteId++;

        Tarea tarea = new Tarea(id, titulo, false);

        tareas.add(tarea);

        return tarea;
    }

    public Tarea buscarPorId(Long id) {
        for (Tarea tarea : tareas) {
            if (tarea.getId().equals(id)) {
                return tarea;
            }
        }

        return null;
    }

    public Tarea actualizarTarea(Long id, String titulo, boolean completada)  {   
        Tarea tarea = buscarPorId(id);

        if (tarea == null) {
            return null;
        }

        tarea.setTitulo(titulo);
        tarea.setCompletada(completada);

        return tarea;
    }

    public boolean eliminarTarea(Long id) {
        for(int i = 0; i < tareas.size(); i++) {
            if (tareas.get(i).getId().equals(id)) {
                tareas.remove(i);
                return true;
            }
        }

        return false;
    }
}
