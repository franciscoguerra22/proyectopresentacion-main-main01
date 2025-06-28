package com.example.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.models.entities.Rol;
import com.example.repositories.RolRepository;
@Service
public class RolService {
    @Autowired
    private RolRepository rolRepository;

    public List<Rol> listar() {
        return rolRepository.findAll();
    }

    public Rol guardar(Rol rol) {
        return rolRepository.save(rol);
    }
    
}
