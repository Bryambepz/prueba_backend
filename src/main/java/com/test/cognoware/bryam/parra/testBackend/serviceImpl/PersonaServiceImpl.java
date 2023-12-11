package com.test.cognoware.bryam.parra.testBackend.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.cognoware.bryam.parra.testBackend.model.Empresa;
import com.test.cognoware.bryam.parra.testBackend.model.Persona;
import com.test.cognoware.bryam.parra.testBackend.repository.PersonaRepository;
import com.test.cognoware.bryam.parra.testBackend.service.PersonaService;
import com.test.cognoware.bryam.parra.testBackend.validations.validations;


@Service
public class PersonaServiceImpl implements PersonaService{

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public Object createPersona(Persona persona) {
        validations validation = new validations();
        if( !validation.validaFecha(persona.getFecha_nacimiento())){
            return "Fecha invalida";
        }
        if (!validation.validaCedula(persona.getCedula())) {
            return "Cedula invalida";
        }
        try {
            personaRepository.save(persona);
            return persona;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public List<Persona> readPersona() {
        try {
            return personaRepository.findAll();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Object updatePersona(Persona persona) {
        validations validation = new validations();
        if( !validation.validaFecha(persona.getFecha_nacimiento())){
            return "Fecha invalida";
        }
        if (!validation.validaCedula(persona.getCedula())) {
            return "Cedula invalida";
        }
        try {
            personaRepository.save(persona);
            return persona;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public boolean deletePersona(Long id) {
        try {
            Persona persona = this.personaRepository.findById(id).get();
            if (persona != null) {
                for (Empresa empresa : persona.getEmpresas()) {
                    empresa.getPersonas().remove(persona);
                }
                persona.getEmpresas().clear();
                personaRepository.deleteById(id);

            }
            return true;
        } catch (Exception e) {
            System.out.println("error eliminacion => "+e.getMessage());
            return false;
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
