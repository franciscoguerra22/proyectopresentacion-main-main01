package com.example.repositories;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.models.entities.Rol;


public interface RolRepository extends JpaRepository<Rol, Long> {
    
    // Busca rol por nombre
    Optional<Rol> findByNombre(String nombre);
    
    // Busca rol que contenga una palabra del nombre
    List<Rol> findByNombreContainingIgnoreCaseList(String nombre);
    
    // Busca rol por nombre y ordena por nombre ascendente
    List<Rol> findAllByOrderByNombreAsc();
    
    // Verifica si existe un rol por nombres
    boolean existsByNombre(String nombre);
    
}
