package com.softrami.hexagonal.domain.ports.out;


import com.softrami.hexagonal.domain.model.Usuario;

import java.util.Optional;

public interface UsuarioRepositoryPort {
    Usuario save(Usuario usuario);

}
