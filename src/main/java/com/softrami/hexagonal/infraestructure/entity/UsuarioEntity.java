package com.softrami.hexagonal.infraestructure.entity;



import com.softrami.hexagonal.domain.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuarios")
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreUsuario;
    private String contrasenia;
    private String correoElectronico;
    @OneToOne
    private PersonaEntity personaEntity;


    public static UsuarioEntity fromDomainModel(Usuario usuario){
        return new UsuarioEntity(usuario.getId(), usuario.getNombreUsuario(), usuario.getContrasenia(), usuario.getCorreoElectronico(), PersonaEntity.fromDomainModel(usuario.getPersona()));
    }

    public Usuario toDomainModel(){
        return new Usuario(id,nombreUsuario,contrasenia,correoElectronico,personaEntity.toDomainModel());
    }


}
