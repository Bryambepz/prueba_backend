package com.test.cognoware.bryam.parra.testBackend.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.cognoware.bryam.parra.testBackend.model.Empresa;
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
    
}
