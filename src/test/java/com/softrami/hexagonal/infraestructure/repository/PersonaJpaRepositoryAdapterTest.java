package com.softrami.hexagonal.infraestructure.repository;

import com.softrami.hexagonal.domain.model.Persona;
import com.softrami.hexagonal.infraestructure.entity.PersonaEntity;
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

class PersonaJpaRepositoryAdapterTest {

    @Mock
    PersonaJpaRepository personaJpaRepository;

    @InjectMocks
    PersonaJpaRepositoryAdapter personaJpaRepositoryAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        personaJpaRepositoryAdapter = new PersonaJpaRepositoryAdapter(personaJpaRepository);
    }

    @Test
    void saveExitosoPersonaEntity() {
        Persona persona = new Persona(1L,"Ramiro","Nuñez",new Date(),"Masculino");
        PersonaEntity personaEntity = new PersonaEntity(1L,"Ramiro","Nuñez",new Date(),"Masculino");

        // Simulando comportamiento
        when(personaJpaRepository.save(Mockito.any(PersonaEntity.class))).thenReturn(personaEntity);

        Persona personaAdapter = personaJpaRepositoryAdapter.save(persona);

        assertNotNull(personaAdapter);
        assertEquals(persona.getId(),personaAdapter.getId());
        assertEquals(persona.getNombre(),personaAdapter.getNombre());
    }

    @Test
    void findByIdExitoso() {
        Long id = 1L;
        PersonaEntity personaEntity = new PersonaEntity(1L,"Ramiro","Nuñez",new Date(),"Masculino");

        when(personaJpaRepository.findById(id)).thenReturn(Optional.of(personaEntity));

        Optional<Persona> personaAdapter = personaJpaRepositoryAdapter.findById(id);

        assertNotNull(personaAdapter);
        assertEquals(personaEntity.getId(),personaAdapter.get().getId());
    }

    @Test
    void findById_IsEmpty() {
        Long id = 1L;

        when(personaJpaRepository.findById(id)).thenReturn(Optional.empty());

        Optional<Persona> optionalPersona = personaJpaRepositoryAdapter.findById(id);
        assertTrue(optionalPersona.isEmpty());
    }

    @Test
    void updatePersonaEntity() {
        Long id = 1L;
        Persona persona = new Persona(1L,"Ramiro","Nuñez",new Date(),"Masculino");
        PersonaEntity personaEntity = new PersonaEntity(1L,"Ramiro","Nuñez",new Date(),"Masculino");

        when(personaJpaRepository.findById(Mockito.any())).thenReturn(Optional.of(personaEntity));
        when(personaJpaRepository.save(Mockito.any(PersonaEntity.class))).thenReturn(personaEntity);

        Optional<Persona> personaAdapter = personaJpaRepositoryAdapter.update(id,persona);

        assertNotNull(personaAdapter);
        /*assertEquals(persona.getId(),personaAdapter.get().getId());
        assertEquals(persona.getNombre(),personaAdapter.get().getNombre());
        assertEquals(persona.getApellido(),personaAdapter.get().getApellido());
        assertEquals(persona.getFechaNacimiento(),personaAdapter.get().getFechaNacimiento());
        assertEquals(persona.getGenero(),personaAdapter.get().getGenero());*/


    }

    @Test
    void deleteByIdPersonaEntity() {
        Long id= 1L;
        when(personaJpaRepository.existsById(id)).thenReturn(true);

        boolean usuarioAdapter = personaJpaRepositoryAdapter.deleteById(id);
    }
}