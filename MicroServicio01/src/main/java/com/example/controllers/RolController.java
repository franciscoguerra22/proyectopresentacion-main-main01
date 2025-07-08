package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.models.entities.Rol;
import com.example.services.RolService;

import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/rol")
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping
    @Operation(summary = "Listar todos los roles", description = "Devuelve todos los roles registrados")
    public List<Rol> obtenerTodos() {
        return rolService.listar();
    }

    @PostMapping
    @Operation(summary = "Guardar nuevo rol", description = "Guarda un nuevo rol y devuelve el recurso creado")
    public Rol guardar(@Valid @RequestBody Rol rol) {
        return rolService.guardar(rol);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener rol por ID", description = "Devuelve un rol específico por su ID")
    public Rol obtenerPorId(@PathVariable Long id) {
        return rolService.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar rol por ID", description = "Elimina un rol específico por su ID")
    public void eliminar(@PathVariable Long id) {
        rolService.eliminarPorId(id);
    }
}
