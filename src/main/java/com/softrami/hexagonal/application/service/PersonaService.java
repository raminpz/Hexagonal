package com.softrami.hexagonal.application.service;

import com.softrami.hexagonal.domain.model.Persona;
import com.softrami.hexagonal.domain.ports.in.PersonaUseCase;

import java.util.Optional;

public class PersonaService implements PersonaUseCase {

    private final PersonaUseCase personaUseCase;

    public PersonaService(PersonaUseCase personaUseCase) {
        this.personaUseCase = personaUseCase;
    }

    @Override
    public Persona crearPersona(Persona persona) {
        return personaUseCase.crearPersona(persona);
    }

    @Override
    public Optional<Persona> getPersona(Long id) {
        return personaUseCase.getPersona(id);
    }

    @Override
    public Persona actualizaPersona(Persona persona) {
        return personaUseCase.actualizaPersona(persona);
    }

    @Override
    public void eliminarPersona(Long id) {
        personaUseCase.eliminarPersona(id);
    }


}
