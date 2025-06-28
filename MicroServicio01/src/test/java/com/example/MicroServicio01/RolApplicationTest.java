package com.example.MicroServicio01;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.example.models.entities.Rol;
import com.example.repositories.RolRepository;
import com.example.services.RolService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
public class RolApplicationTest {

    @Mock
    private RolRepository rolRepository;

    @InjectMocks
    private RolService rolService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testListar() {
        Rol rol1 = new Rol();
        rol1.setId(1);
        rol1.setNombre("ADMIN");

        Rol rol2 = new Rol();
        rol2.setId(2);
        rol2.setNombre("USER");

        when(rolRepository.findAll()).thenReturn(Arrays.asList(rol1, rol2));

        List<Rol> resultado = rolService.listar();

        assertEquals(2, resultado.size());
        assertEquals("ADMIN", resultado.get(0).getNombre());
        assertEquals("USER", resultado.get(1).getNombre());
    }

    @Test
    public void testGuardar() {
        Rol rol = new Rol();
        rol.setId(1);
        rol.setNombre("MODERATOR");

        when(rolRepository.save(rol)).thenReturn(rol);

        Rol resultado = rolService.guardar(rol);

        assertNotNull(resultado);
        assertEquals("MODERATOR", resultado.getNombre());
        verify(rolRepository, times(1)).save(rol);
    }
    
}
