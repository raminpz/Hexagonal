package com.softrami.hexagonal.infraestructure.controller;

import com.softrami.hexagonal.application.service.PersonaService;
import com.softrami.hexagonal.domain.model.Persona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/personas")
public class PersonaController {

    private final PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }


    @PostMapping
    public ResponseEntity<Persona> createPersona(@RequestBody Persona persona){
        Persona createPersona = personaService.crearPersona(persona);

        return new ResponseEntity<>(createPersona, HttpStatus.CREATED);
    }

    @GetMapping("/{personaId}")
    public ResponseEntity<Persona> getPersona(@PathVariable Long personaId){
        return personaService.getPersona(personaId)
                .map(persona -> new ResponseEntity<>(persona,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/actualizarPersona")
    public Persona actualizarPersona(@RequestBody Persona persona){
        return personaService.actualizaPersona(persona);
    }

    @DeleteMapping("/borrar/{id}")
    public void borrarPersona(@PathVariable Long id){
        personaService.eliminarPersona(id);
    }
}
