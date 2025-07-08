package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.models.entities.User;
import com.example.models.requests.LoginRequest;
import com.example.models.requests.UserCreate;
import com.example.models.requests.UserUpdate;
import com.example.services.UserService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    @Operation(summary = "Listar todos los usuarios", description = "Devuelve todos los usuarios registrados")
    public List<User> obtenerTodos() {
        return userService.obtenerTodos();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener usuario por ID", description = "Devuelve un usuario específico por su ID")
    public User obtenerPorId(@PathVariable int id) {
        return userService.obtenerPorId(id);
    }

    @PostMapping
    @Operation(summary = "Registrar un nuevo usuario", description = "Registra un usuario y devuelve el recurso creado")
    public User registrar(@Valid @RequestBody UserCreate user) {
        return userService.registrar(user);
    }

    @PutMapping
    @Operation(summary = "Actualizar usuario", description = "Actualiza un usuario existente")
    public User actualizar(@Valid @RequestBody UserUpdate user) {
        return userService.actualizar(user);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar usuario por ID", description = "Elimina un usuario específico por su ID")
    public void eliminar(@PathVariable int id) {
        userService.eliminar(id);
    }
    
    @PostMapping("/login")
    @Operation(summary = "Login de usuario", description = "Permite iniciar sesión con email y contraseña")
    public User login(@RequestBody LoginRequest loginRequest) {
        return userService.login(loginRequest);
    }
}
