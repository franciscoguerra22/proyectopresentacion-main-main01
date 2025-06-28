package com.example.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.swing.text.html.parser.Entity;
/*prueba 1 de commit 3 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assemblers.UserModelAssembler;
import com.example.models.entities.User;
import com.example.models.requests.UserCreate;
import com.example.models.requests.UserUpdate;
import com.example.services.UserService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;



@RestController
@RequestMapping("/usuario")
public class UserControllerv2 {
    
    @Autowired
    private UserModelAssembler assembler;

    @Autowired
    private UserService userService;


    @GetMapping("/")
    @Operation(summary = "Obtener todos los usuarios",
    description = "Obtiene una lista de todos los usuarios registrados en el sistema")
    public List<User> obtenerTodos() {
        List<EntityModel<User>> usuarios = userService.obtenerTodos()
            .stream()
            .map(assembler::toModel)
            .collect(Collectors.toList());
        return userService.obtenerTodos();
    }

     @GetMapping("/{id}")
     @Operation(summary = "Obtener un usuario por ID",
    description = "Obtiene un usuario específico por su ID")
    public User obtenerUno(@PathVariable int id) {
        return userService.obtenerPorId(id);
    }

    @PostMapping
    @Operation(summary = "Registrar un nuevo usuario",
    description = "Registra un nuevo usuario en el sistema")
    public User registrar(@Valid @RequestBody UserCreate body) {
        return userService.registrar(body);
    }

    @PutMapping("/")
    @Operation(summary = "Modificar un usuario",
    description = "Modifica un usuario existente en el sistema")
    public User modificar(@Valid @RequestBody UserUpdate body){
        return userService.actualizar(body);
    }
    @Operation(summary = "Actualizar un usuario",
    description = "Actualiza un usuario existente en el sistema")
      @PutMapping()
    public User actualizar(@Valid @RequestBody UserUpdate body) {
        return userService.actualizar(body);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un usuario",
    description = "Elimina un usuario del sistema por su ID")
    public String eliminar(@PathVariable int id) {
        userService.eliminar(id);
        return "ok";
    }
}

