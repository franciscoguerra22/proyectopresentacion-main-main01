package com.example.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.models.entities.Permiso;
import com.example.repositories.PermisoRepository;

public class PermisoService {
    @Autowired
    private PermisoRepository permisoRepository;

    public List<Permiso> listar() {
        return permisoRepository.findAll();
    }
    
    public Permiso guardar(Permiso permiso) {
        return permisoRepository.save(permiso);
    }
}
