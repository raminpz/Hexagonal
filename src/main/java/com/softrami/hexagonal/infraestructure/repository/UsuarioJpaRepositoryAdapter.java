package com.softrami.hexagonal.infraestructure.repository;

import com.softrami.hexagonal.domain.model.Usuario;
import com.softrami.hexagonal.domain.ports.out.PersonaRepositoryPort;
import com.softrami.hexagonal.domain.ports.out.UsuarioRepositoryPort;
import com.softrami.hexagonal.infraestructure.entity.PersonaEntity;
import com.softrami.hexagonal.infraestructure.entity.UsuarioEntity;
import org.springframework.stereotype.Component;

@Component
public class UsuarioJpaRepositoryAdapter implements UsuarioRepositoryPort {

    private final UsuarioJpaRepository usuarioJpaRepository;


    public UsuarioJpaRepositoryAdapter(UsuarioJpaRepository usuarioJpaRepository) {
        this.usuarioJpaRepository = usuarioJpaRepository;
    }


    @Override
    public Usuario save(Usuario usuario) {
        UsuarioEntity usuarioEntity = UsuarioEntity.fromDomainModel(usuario);
        UsuarioEntity saveUsuarioEntity = usuarioJpaRepository.save(usuarioEntity);
        return saveUsuarioEntity.toDomainModel();
    }
}
