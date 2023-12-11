package com.test.cognoware.bryam.parra.testBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.cognoware.bryam.parra.testBackend.DTO.EmpresaPersonaDTO;
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
            return ResponseEntity.status(HttpStatus.CREATED).body(this.responseWS);
        } else {
            this.responseWS = new ResponseWS(HttpStatus.INTERNAL_SERVER_ERROR.value(), "No se pudo guardar, Intente nuevamente mas tarde", (String) obj);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(this.responseWS);
        }
    }

    @GetMapping( path = "read-empresa", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseWS> readEmpresas(){
        System.out.println("se obtiene empresas");
        List<Empresa> empresas = empresaService.readEmpresas();
        if ( !empresas.isEmpty() ) {
            this.responseWS = new ResponseWS(HttpStatus.OK.value(), "Se han obtenido las empresas", empresas);
            return ResponseEntity.status(HttpStatus.OK).body(this.responseWS);
        } else {
            this.responseWS = new ResponseWS(HttpStatus.NOT_FOUND.value(), "No se pudo recuperar las empresas", "Sin empresas");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(this.responseWS);
        }
    }

    @PutMapping( path = "update-empresa", consumes = MediaType.APPLICATION_JSON_VALUE ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseWS> updateEmpresas(@RequestBody Empresa empresa){
        Object obj = empresaService.updateEmpresa(empresa);
        if ( obj instanceof Empresa) {
            Empresa empresaSaved = (Empresa) obj;
            this.responseWS = new ResponseWS(HttpStatus.CREATED.value(), "Empresa actualizada con exito", "", empresaSaved);
            return ResponseEntity.status(HttpStatus.CREATED).body(this.responseWS);
        } else {
            this.responseWS = new ResponseWS(HttpStatus.INTERNAL_SERVER_ERROR.value(), "No se pudo actualizar, Intente nuevamente mas tarde", (String) obj);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(this.responseWS);
        }
    }

    @DeleteMapping( path = "delete-empresa", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseWS> updateEmpresas(@RequestParam("id") Long id){
        boolean stateDelete = empresaService.deleteEmpresa(id);
        if ( stateDelete ) {
            this.responseWS = new ResponseWS(HttpStatus.ACCEPTED.value(), "Empresa eliminada con exito", "");
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(this.responseWS);
        } else {
            this.responseWS = new ResponseWS(HttpStatus.INTERNAL_SERVER_ERROR.value(), "No se pudo eliminar, Intente nuevamente mas tarde", "");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(this.responseWS);
        }
    }

    @GetMapping( path = "empresas-personas", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseWS> getEmpresasYPersonas(){
        List<EmpresaPersonaDTO> empresaPersonaDTOs = this.empresaService.getEmpresaPersonas();
        if ( !empresaPersonaDTOs.isEmpty() ) {
            this.responseWS = new ResponseWS(HttpStatus.OK.value(), "Se obtuvo satisfactoriamente", "", empresaPersonaDTOs);
            return ResponseEntity.status(HttpStatus.OK).body(this.responseWS);
        } else {
            this.responseWS = new ResponseWS(HttpStatus.INTERNAL_SERVER_ERROR.value(), "No se pudo obtener, intente mas tarde", "No informacion de empresas y personas");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(this.responseWS);
        }
    }

    // @GetMapping( path = "hola", 
    //     produces = MediaType.APPLICATION_JSON_VALUE)
    // public ResponseEntity<ResponseWS> saludo(){
    //     this.responseWS = new ResponseWS(HttpStatus.OK.value(), "Hola desde erl microservicio /empresa", "");
    //     return ResponseEntity.ok(this.responseWS);
    // }
}