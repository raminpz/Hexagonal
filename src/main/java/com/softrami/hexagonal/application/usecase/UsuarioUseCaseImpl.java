package com.softrami.hexagonal.application.usecase;

import com.softrami.hexagonal.domain.model.Usuario;
import com.softrami.hexagonal.domain.ports.in.UsuarioUseCase;
import com.softrami.hexagonal.domain.ports.out.UsuarioRepositoryPort;

import java.util.Optional;

public class UsuarioUseCaseImpl implements UsuarioUseCase {

    private final UsuarioRepositoryPort usuarioRepositoryPort;


    public UsuarioUseCaseImpl(UsuarioRepositoryPort usuarioRepositoryPort) {
        this.usuarioRepositoryPort = usuarioRepositoryPort;
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepositoryPort.save(usuario);
    }

    @Override
    public Optional<Usuario> getUsuario(Long id) {
        return usuarioRepositoryPort.findById(id);
    }

    @Override
    public Optional<Usuario> updateUsuario(Long id, Usuario usuario) {
        return usuarioRepositoryPort.update(id,usuario);
    }

    @Override
    public boolean deleteUsuario(Long id) {
        return usuarioRepositoryPort.deleteById(id);
    }
}
