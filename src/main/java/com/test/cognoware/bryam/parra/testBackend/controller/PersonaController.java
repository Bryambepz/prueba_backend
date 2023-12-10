package com.test.cognoware.bryam.parra.testBackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.cognoware.bryam.parra.testBackend.model.Persona;
import com.test.cognoware.bryam.parra.testBackend.response.ResponseWS;
import com.test.cognoware.bryam.parra.testBackend.service.PersonaService;

@RestController
@RequestMapping("persona")
@CrossOrigin( origins = "*")
public class PersonaController {
    
    @Autowired
    private PersonaService personaService;

    private ResponseWS responseWS;

    @PostMapping( path = "create-persona", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<ResponseWS> createPersona(@RequestBody Persona persona) {
        Object obj = personaService.createPersona(persona);
        if ( obj instanceof Persona ) {
            this.responseWS = new ResponseWS(HttpStatus.CREATED.value(), "Se ha creado la persona con exito", "", (Persona) obj);
            return ResponseEntity.status(HttpStatus.CREATED).body(this.responseWS);
        } else {
            this.responseWS = new ResponseWS(HttpStatus.INTERNAL_SERVER_ERROR.value(), "No se pudo crear la persona", (String) obj);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(this.responseWS);
        }

    }

    @GetMapping( path = "hola", 
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseWS> saludo(){
        this.responseWS = new ResponseWS(HttpStatus.OK.value(), "Hola desde erl microservicio /persona");
        return ResponseEntity.ok(this.responseWS);
    }
}
