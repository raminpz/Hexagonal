package com.softrami.hexagonal.domain.ports.in;



import com.softrami.hexagonal.domain.model.Usuario;

import java.util.Optional;

public interface UsuarioUseCase {

    Usuario crearUsuario(Usuario usuario);

    Optional<Usuario> getUsuario(Long id);

    Optional<Usuario> updateUsuario(Long id, Usuario usuario);
    boolean deleteUsuario(Long id);




}
