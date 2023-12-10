package com.test.cognoware.bryam.parra.testBackend.service;

import java.time.LocalDateTime;

import com.test.cognoware.bryam.parra.testBackend.model.Persona;

public interface PersonaService {
    
    public Object createPersona( Persona persona );
    public boolean validateCedula( String cedula);
    public boolean validateFecha( LocalDateTime fechaBirthday);
    
}
