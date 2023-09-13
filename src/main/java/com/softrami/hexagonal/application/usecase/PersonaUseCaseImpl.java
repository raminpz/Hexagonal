package com.softrami.hexagonal.application.usecase;

import com.softrami.hexagonal.domain.model.Persona;
import com.softrami.hexagonal.domain.ports.in.PersonaUseCase;
import com.softrami.hexagonal.domain.ports.out.PersonaRepositoryPort;

import java.util.Optional;

public class PersonaUseCaseImpl implements PersonaUseCase {

    private final PersonaRepositoryPort personaRepositoryPort;

    public PersonaUseCaseImpl(PersonaRepositoryPort personaRepositoryPort) {
        this.personaRepositoryPort = personaRepositoryPort;
    }

    @Override
    public Persona crearPersona(Persona persona) {
        return personaRepositoryPort.save(persona);
    }

    @Override
    public Optional<Persona> getPersona(Long id) {
        return personaRepositoryPort.findById(id);
    }

    @Override
    public Persona actualizaPersona(Persona persona) {
        return personaRepositoryPort.updatePersona(persona);
    }

    @Override
    public void eliminarPersona(Long id) {
        personaRepositoryPort.deletePersona(id);
    }


}