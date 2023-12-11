package com.test.cognoware.bryam.parra.testBackend.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.cognoware.bryam.parra.testBackend.DTO.EmpresaPersonaDTO;
import com.test.cognoware.bryam.parra.testBackend.model.Empresa;
import com.test.cognoware.bryam.parra.testBackend.model.Persona;
import com.test.cognoware.bryam.parra.testBackend.repository.EmpresaRepository;
import com.test.cognoware.bryam.parra.testBackend.service.EmpresaService;

@Service
public class EmpresaServiceImpl implements EmpresaService{

    @Autowired
    private EmpresaRepository empresaRepository;

    @Override
    public Object createEmpresa(Empresa empresa) {
        try {
            empresaRepository.save(empresa);
            return empresa;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public List<Empresa> readEmpresas() {
        try {
            return empresaRepository.findAll();
        } catch (Exception e) {
            System.out.println("se dio error => " + e.getMessage() + "\n === \n");
            return null;
        }
    }

    @Override
    public Object updateEmpresa(Empresa empresa) {
        try {
            empresaRepository.save(empresa);
            return empresa;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public boolean deleteEmpresa(Long id) {
        try {
            empresaRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<EmpresaPersonaDTO> getEmpresaPersonas() {
        try {
            List<Object[]> empresasPersonasDTO = empresaRepository.getEmpresasPersonas();
            List<EmpresaPersonaDTO> personasEmpresasDTOs = new ArrayList<>();
            for (Object[] objects : empresasPersonasDTO) {
                EmpresaPersonaDTO newEmpPer = new EmpresaPersonaDTO();
                // newEmpPer.setEmpresa( (Empresa) objects[0]);
                // newEmpPer.setPersona( (Persona) objects[1]);
                newEmpPer.setEmpresaId(  Long.parseLong(objects[0].toString()) );
                newEmpPer.setEmpresaNombre( objects[1].toString().toString() );
                newEmpPer.setEmpresaDireccion( objects[2].toString());
                newEmpPer.setPersonaId( Long.parseLong(objects[3].toString()));
                newEmpPer.setPersonaNombre(objects[4].toString());
                newEmpPer.setPersonaEstudio(objects[5].toString());
                personasEmpresasDTOs.add(newEmpPer);
            }
            return personasEmpresasDTOs;
        } catch (Exception e) {
            System.out.println("error de get EP => "+e.getMessage());
            return null;
        }
    }
    
}
