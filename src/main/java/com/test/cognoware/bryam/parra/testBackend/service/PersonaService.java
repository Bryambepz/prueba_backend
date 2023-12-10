package com.test.cognoware.bryam.parra.testBackend.service;

import java.time.LocalDateTime;
import java.util.List;

import com.test.cognoware.bryam.parra.testBackend.model.Persona;

public interface PersonaService {
    
    public Object createPersona( Persona persona );
    public List<Persona> readPersona( );
    public Object updatePersona( Persona persona );
    public boolean deletePersona( Long id );

    public boolean validateCedula( String cedula);
    public boolean validateFecha( LocalDateTime fechaBirthday);
    
}
