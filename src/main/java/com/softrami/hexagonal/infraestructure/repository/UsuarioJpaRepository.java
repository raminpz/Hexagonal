package com.softrami.hexagonal.infraestructure.repository;

import com.softrami.hexagonal.infraestructure.entity.PersonaEntity;
import com.softrami.hexagonal.infraestructure.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioJpaRepository extends JpaRepository<UsuarioEntity, Long> {
}
