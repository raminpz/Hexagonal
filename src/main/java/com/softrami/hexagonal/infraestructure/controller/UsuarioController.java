package com.softrami.hexagonal.infraestructure.controller;

import com.softrami.hexagonal.application.service.UsuarioService;
import com.softrami.hexagonal.domain.model.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario){
        Usuario createUsuario = usuarioService.crearUsuario(usuario);
        return new ResponseEntity<>(createUsuario, HttpStatus.CREATED);
    }

    @GetMapping("/{usuarioId}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long usuarioId){
        return usuarioService.getUsuario(usuarioId)
                .map(usu -> new ResponseEntity<>(usu,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{usuarioId}")
    public ResponseEntity<Usuario> updatePersona(@PathVariable Long usuarioId, @RequestBody Usuario usuario){
        return usuarioService.updateUsuario(usuarioId,usuario)
                .map(usu -> new ResponseEntity<>(usu,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{usuarioId}")
    public ResponseEntity<Void> deleteUsuarioById(@PathVariable Long usuarioId){
        if (usuarioService.deleteUsuario(usuarioId)){
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
