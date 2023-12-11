package com.test.cognoware.bryam.parra.testBackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

// import com.test.cognoware.bryam.parra.testBackend.DTO.EmpresaPersonaDTO;
import com.test.cognoware.bryam.parra.testBackend.model.Empresa;

@Repository
@EnableJpaRepositories
public interface EmpresaRepository extends JpaRepository<Empresa, Long>{
    
    @Query(nativeQuery = true,
    value = "select em.id, em.nombre, em.direccion, pa.id, pa.nombre, pa.estudio from empresa em, persona pa, empresa_persona empa where em.id = empa.empresa_id and pa.id = empa.persona_id")
    // @Query("SELECT e, p FROM Empresa e JOIN e.personas p")
    List<Object[]> getEmpresasPersonas();
}
