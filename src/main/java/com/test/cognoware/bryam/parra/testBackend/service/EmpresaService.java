package com.test.cognoware.bryam.parra.testBackend.service;

import java.util.List;

import com.test.cognoware.bryam.parra.testBackend.model.Empresa;

public interface EmpresaService {
    
    public Object createEmpresa( Empresa empresa );
    public List<Empresa> readEmpresas();
    public Object updateEmpresa( Empresa empresa );
    public boolean deleteEmpresa( Long id );
}
