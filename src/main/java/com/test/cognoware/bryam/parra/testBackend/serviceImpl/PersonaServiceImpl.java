package com.test.cognoware.bryam.parra.testBackend.serviceImpl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.cognoware.bryam.parra.testBackend.model.Persona;
import com.test.cognoware.bryam.parra.testBackend.repository.PersonaRepository;
import com.test.cognoware.bryam.parra.testBackend.service.PersonaService;


@Service
public class PersonaServiceImpl implements PersonaService{

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public Object createPersona(Persona persona) {
        try {
            personaRepository.save(persona);
            return persona;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public boolean validateCedula(String cedula) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'validateCedula'");
    }

    @Override
    public boolean validateFecha(LocalDateTime fechaBirthday) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'validateFecha'");
    }
    
}
