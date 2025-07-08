package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.models.entities.Permiso;
import com.example.services.PermisoService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/permiso")
public class PermisoController {

    @Autowired
    private PermisoService permisoService;

    @GetMapping
    @Operation(summary = "Listar todos los permisos", description = "Devuelve todos los permisos registrados")
    public List<Permiso> obtenerTodos() {
        return permisoService.listar();
    }

    @PostMapping
    @Operation(summary = "Guardar nuevo permiso", description = "Guarda un nuevo permiso y devuelve el recurso creado")
    public Permiso guardar(@Valid @RequestBody Permiso permiso) {
        return permisoService.guardar(permiso);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener permiso por ID", description = "Devuelve un permiso específico por su ID")
    public Permiso obtenerPorId(@PathVariable Long id) {
        return permisoService.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Permiso no encontrado"));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar permiso por ID", description = "Elimina un permiso específico por su ID")
    public void eliminar(@PathVariable Long id) {
        permisoService.eliminarPorId(id);
    }
}
