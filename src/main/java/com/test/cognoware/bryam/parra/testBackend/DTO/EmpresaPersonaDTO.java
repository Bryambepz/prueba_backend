package com.test.cognoware.bryam.parra.testBackend.DTO;

import com.test.cognoware.bryam.parra.testBackend.model.Empresa;
import com.test.cognoware.bryam.parra.testBackend.model.Persona;

public class EmpresaPersonaDTO {

    private Long empresaId;
    private String empresaNombre;
    private String empresaDireccion;
    private Long personaId;
    private String personaNombre;
    private String personaEstudio;
    
    public EmpresaPersonaDTO() {
    }
    public Long getEmpresaId() {
        return empresaId;
    }
    public void setEmpresaId(Long empresaId) {
        this.empresaId = empresaId;
    }
    public String getEmpresaNombre() {
        return empresaNombre;
    }
    public void setEmpresaNombre(String empresaNombre) {
        this.empresaNombre = empresaNombre;
    }
    public String getEmpresaDireccion() {
        return empresaDireccion;
    }
    public void setEmpresaDireccion(String empresaDireccion) {
        this.empresaDireccion = empresaDireccion;
    }
    public Long getPersonaId() {
        return personaId;
    }
    public void setPersonaId(Long personaId) {
        this.personaId = personaId;
    }
    public String getPersonaNombre() {
        return personaNombre;
    }
    public void setPersonaNombre(String personaNombre) {
        this.personaNombre = personaNombre;
    }
    public String getPersonaEstudio() {
        return personaEstudio;
    }
    public void setPersonaEstudio(String personaEstudio) {
        this.personaEstudio = personaEstudio;
    }
    
    // private Empresa empresa;
    // private Persona persona;
    
    // public EmpresaPersonaDTO() {
    // }
    
    // public Empresa getEmpresa() {
    //     return empresa;
    // }
    // public void setEmpresa(Empresa empresa) {
    //     this.empresa = empresa;
    // }
    // public Persona getPersona() {
    //     return persona;
    // }
    // public void setPersona(Persona persona) {
    //     this.persona = persona;
    // }
    
}
