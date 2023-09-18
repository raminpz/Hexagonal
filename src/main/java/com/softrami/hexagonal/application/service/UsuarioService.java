package com.softrami.hexagonal.application.service;

import com.softrami.hexagonal.domain.model.Usuario;
import com.softrami.hexagonal.domain.ports.in.PersonaUseCase;
import com.softrami.hexagonal.domain.ports.in.UsuarioUseCase;

import java.util.Optional;

public class UsuarioService implements UsuarioUseCase {

    private final UsuarioUseCase usuarioUseCase;


    public UsuarioService(UsuarioUseCase usuarioUseCase) {
        this.usuarioUseCase = usuarioUseCase;
    }


    @Override
    public Usuario crearUsuario(Usuario usuario) {
        return usuarioUseCase.crearUsuario(usuario);
    }

    @Override
    public Optional<Usuario> getUsuario(Long id) {
        return usuarioUseCase.getUsuario(id);
    }

    @Override
    public Optional<Usuario> updateUsuario(Long id, Usuario usuario) {
        return usuarioUseCase.updateUsuario(id,usuario);
    }

    @Override
    public boolean deleteUsuario(Long id) {
        return usuarioUseCase.deleteUsuario(id);
    }
}
