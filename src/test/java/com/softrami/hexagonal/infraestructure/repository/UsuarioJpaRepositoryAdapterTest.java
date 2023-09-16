package com.softrami.hexagonal.infraestructure.repository;

import com.softrami.hexagonal.domain.model.Persona;
import com.softrami.hexagonal.domain.model.Usuario;
import com.softrami.hexagonal.infraestructure.entity.PersonaEntity;
import com.softrami.hexagonal.infraestructure.entity.UsuarioEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


class UsuarioJpaRepositoryAdapterTest {

    @Mock
    UsuarioJpaRepository usuarioJpaRepository;

    @InjectMocks
    UsuarioJpaRepositoryAdapter usuarioJpaRepositoryAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        usuarioJpaRepositoryAdapter = new UsuarioJpaRepositoryAdapter(usuarioJpaRepository);
    }
    @Test
    void saveExitosoUsuarioEntity() {
        Persona persona = new Persona(1L,"Ramiro","Nuñez Perez",new Date(),"Masculino");
        PersonaEntity personaEntity = new PersonaEntity(1L,"Ramiro","Nuñez", new Date(),"Masculino");
        Usuario usuario = new Usuario(1L,"Ramiro","rami123","rami@gmail.com",persona);
        UsuarioEntity usuarioEntity = new UsuarioEntity(1L,"Ramiro","rami123","rami@gmail.com",personaEntity);

        // Simulando comportamiento
        when(usuarioJpaRepository.save(Mockito.any(UsuarioEntity.class))).thenReturn(usuarioEntity);

        Usuario usuario1 = usuarioJpaRepositoryAdapter.save(usuario);
        assertNotNull(usuario1);
        assertEquals(usuario.getId(),usuario1.getId());
        assertEquals(usuario.getNombreUsuario(),usuario1.getNombreUsuario());
    }

    @Test
    void findByIdExitoso() {
        Long id=1L;
        PersonaEntity personaEntity = new PersonaEntity(1L,"Ramiro","Nuñez", new Date(),"Masculino");
        UsuarioEntity usuarioEntity = new UsuarioEntity(1L,"Ramiro","rami123","rami@gmail.com",personaEntity);

        when(usuarioJpaRepository.findById(id)).thenReturn(Optional.of(usuarioEntity));

        Optional<Usuario> usuarioAdapter = usuarioJpaRepositoryAdapter.findById(id);

        assertNotNull(usuarioAdapter);
        assertEquals(usuarioEntity.getId(),usuarioAdapter.get().getId());

    }

    @Test
    void findById_IsEmpty() {
        Long id = 1L;

        when(usuarioJpaRepository.findById(id)).thenReturn(Optional.empty());


        Optional<Usuario> optionalUsuario = usuarioJpaRepositoryAdapter.findById(id);

        assertTrue(optionalUsuario.isEmpty());
    }

    @Test
    void updateUsuarioEntity() {
        Persona persona = new Persona(1L,"Ramiro","Nuñez Perez",new Date(),"Masculino");
        Usuario usuario = new Usuario(1L,"Ramiro","rami123","rami@gmail.com",persona);
        PersonaEntity personaEntity = new PersonaEntity(2L, "Emi", "Benz", new Date(), "Femenino");
        UsuarioEntity usuarioEntity = new UsuarioEntity(1L,"Emily","123456","emi@gmail.com",personaEntity);
        when(usuarioJpaRepository.save(Mockito.any(UsuarioEntity.class))).thenReturn(usuarioEntity);
        Usuario usuarioAdapter = usuarioJpaRepositoryAdapter.save(usuario);

        assertNotNull(usuarioAdapter);
        assertEquals(usuario.getId(), usuarioAdapter.getId());


    }

    @Test
    void deleteByIdUsuarioEntity() {
        Long id = 1L;

        when(usuarioJpaRepository.existsById(id)).thenReturn(true);

        boolean usuarioAdapter = usuarioJpaRepositoryAdapter.deleteById(id);

    }
}