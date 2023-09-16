package com.softrami.hexagonal.infraestructure.repository;

import com.softrami.hexagonal.domain.model.Usuario;
import com.softrami.hexagonal.domain.ports.out.UsuarioRepositoryPort;
import com.softrami.hexagonal.infraestructure.entity.UsuarioEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

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

    @Override
    public Optional<Usuario> findById(Long id) {
        return usuarioJpaRepository.findById(id)
                .map(UsuarioEntity::toDomainModel);
    }

    @Override
    public Optional<Usuario> update(Long id, Usuario usuario) {
        if (usuarioJpaRepository.existsById(id)){
            UsuarioEntity usuarioEntity = UsuarioEntity.fromDomainModel(usuario);
            UsuarioEntity updateUsuarioEntity = usuarioJpaRepository.save(usuarioEntity);
            return Optional.of(updateUsuarioEntity.toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long id) {
        if (usuarioJpaRepository.existsById(id)){
            usuarioJpaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
