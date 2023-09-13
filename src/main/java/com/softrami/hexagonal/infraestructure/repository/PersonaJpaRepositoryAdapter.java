package com.softrami.hexagonal.infraestructure.repository;

import com.softrami.hexagonal.domain.model.Persona;
import com.softrami.hexagonal.domain.ports.out.PersonaRepositoryPort;
import com.softrami.hexagonal.infraestructure.entity.PersonaEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PersonaJpaRepositoryAdapter implements PersonaRepositoryPort {

    private final PersonaJpaRepository personaJpaRepository;

    public PersonaJpaRepositoryAdapter(PersonaJpaRepository personaJpaRepository) {
        this.personaJpaRepository = personaJpaRepository;
    }

    @Override
    public Persona save(Persona persona) {
        PersonaEntity personaEntity = PersonaEntity.fromDomainModel(persona);
        PersonaEntity savePersonaEntity = personaJpaRepository.save(personaEntity);
        return savePersonaEntity.toDomainModel();
    }

    @Override
    public Optional<Persona> findById(Long id) {
        return personaJpaRepository.findById(id)
                .map(PersonaEntity::toDomainModel);
    }

    @Override
    public Persona updatePersona(Persona persona) {
        PersonaEntity personaExistente = personaJpaRepository.findById(persona.getId()).orElse(null);
        personaExistente.setNombre(persona.getNombre());
        personaExistente.setApellido(persona.getApellido());
        personaExistente.setFechaNacimiento(persona.getFechaNacimiento());
        personaExistente.setGenero(persona.getGenero());

        PersonaEntity newPersona = personaJpaRepository.save(personaExistente);

        return newPersona.toDomainModel();
    }

    @Override
    public void deletePersona(Long id) {
        personaJpaRepository.deleteById(id);
    }
}
