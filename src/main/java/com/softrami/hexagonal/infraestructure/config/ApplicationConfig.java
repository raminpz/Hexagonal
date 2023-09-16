package com.softrami.hexagonal.infraestructure.config;

import com.softrami.hexagonal.application.service.PersonaService;
import com.softrami.hexagonal.application.service.UsuarioService;
import com.softrami.hexagonal.application.usecase.PersonaUseCaseImpl;
import com.softrami.hexagonal.application.usecase.UsuarioUseCaseImpl;
import com.softrami.hexagonal.domain.ports.out.PersonaRepositoryPort;
import com.softrami.hexagonal.domain.ports.out.UsuarioRepositoryPort;
import com.softrami.hexagonal.infraestructure.repository.PersonaJpaRepositoryAdapter;
import com.softrami.hexagonal.infraestructure.repository.UsuarioJpaRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public PersonaService personaService(PersonaRepositoryPort personaRepositoryPort){
        return new PersonaService(new PersonaUseCaseImpl(personaRepositoryPort));
    }

    @Bean
    public PersonaRepositoryPort personaRepositoryPort(PersonaJpaRepositoryAdapter personaJpaRepositoryAdapter){
        return personaJpaRepositoryAdapter;
    }

    @Bean
    public UsuarioService usuarioService(UsuarioRepositoryPort usuarioRepositoryPort){
        return new UsuarioService(new UsuarioUseCaseImpl(usuarioRepositoryPort));
    }

    @Bean
    public UsuarioRepositoryPort usuarioRepositoryPort(UsuarioJpaRepositoryAdapter usuarioJpaRepositoryAdapter){
        return  usuarioJpaRepositoryAdapter;
    }
}
