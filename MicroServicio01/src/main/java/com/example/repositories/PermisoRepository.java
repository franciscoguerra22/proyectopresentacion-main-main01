package com.example.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.models.entities.Permiso;

public interface PermisoRepository extends JpaRepository<Permiso, Long> {
    //busca rol por nombre
    Optional<Permiso> findByNombre(String nombre);
    
    //busca rol que contenga una palabra del nombre
    List<Permiso> findByNombreContainingIgnoreCaseList(String nombre);

    //busca rol por nombre y ordena por nombre ascendente
    List<Permiso> findAllByOrderByNombreAsc();
    
    //verifica si existe un permiso por nombres
    boolean existsByNombre(String nombre);

    
    
}
