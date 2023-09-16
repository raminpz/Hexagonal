package com.softrami.hexagonal.domain.ports.in;

import com.softrami.hexagonal.domain.model.Persona;

import java.util.Optional;

public interface PersonaUseCase {

    Persona crearPersona(Persona persona);

    Optional<Persona> getPersona(Long id);

    Optional<Persona> updatePersona(Long id, Persona persona);
    boolean deletePersona(Long id);


}
