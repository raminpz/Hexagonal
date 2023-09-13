package com.softrami.hexagonal.domain.ports.out;

import com.softrami.hexagonal.domain.model.Persona;

import java.util.Optional;

public interface PersonaRepositoryPort {
    Persona save(Persona persona);
    Optional<Persona> findById(Long id);

    Persona updatePersona(Persona persona);

    void deletePersona(Long id);
}
