package com.softrami.hexagonal.application.service;

import com.softrami.hexagonal.domain.model.Usuario;
import com.softrami.hexagonal.domain.ports.in.PersonaUseCase;
import com.softrami.hexagonal.domain.ports.in.UsuarioUseCase;

public class UsuarioService implements UsuarioUseCase {

    private final UsuarioUseCase usuarioUseCase;


    public UsuarioService(UsuarioUseCase usuarioUseCase) {
        this.usuarioUseCase = usuarioUseCase;
    }


    @Override
    public Usuario crearUsuario(Usuario usuario) {
        return usuarioUseCase.crearUsuario(usuario);
    }
}
