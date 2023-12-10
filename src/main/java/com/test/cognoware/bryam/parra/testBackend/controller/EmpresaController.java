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

import com.test.cognoware.bryam.parra.testBackend.model.Empresa;
import com.test.cognoware.bryam.parra.testBackend.response.ResponseWS;
import com.test.cognoware.bryam.parra.testBackend.service.EmpresaService;

@RestController
@RequestMapping("/empresa")
@CrossOrigin( origins = "*")
public class EmpresaController {
    
    @Autowired
    private EmpresaService empresaService;

    private ResponseWS responseWS;

    @PostMapping( path = "create-empresa", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseWS> createEmpresa(@RequestBody Empresa empresa){
        Object obj = empresaService.createEmpresa(empresa);
        if ( obj instanceof Empresa) {
            Empresa empresaSaved = (Empresa) obj;
            this.responseWS = new ResponseWS(HttpStatus.CREATED.value(), "Empresa creada con exito", "", empresaSaved);
        } else {
            this.responseWS = new ResponseWS(HttpStatus.INTERNAL_SERVER_ERROR.value(), "No se pudo guardar, Intenete nuevamnete mas tarde", (String) obj);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(this.responseWS);
    }

    @GetMapping( path = "hola", 
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseWS> saludo(){
        this.responseWS = new ResponseWS(HttpStatus.OK.value(), "Hola desde erl microservicio /empresa");
        return ResponseEntity.ok(this.responseWS);
    }
}