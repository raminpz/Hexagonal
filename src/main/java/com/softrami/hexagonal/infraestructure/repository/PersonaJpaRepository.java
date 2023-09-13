package com.softrami.hexagonal.infraestructure.repository;

import com.softrami.hexagonal.infraestructure.entity.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaJpaRepository extends JpaRepository<PersonaEntity, Long> {
}
