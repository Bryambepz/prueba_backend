package com.test.cognoware.bryam.parra.testBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.cognoware.bryam.parra.testBackend.model.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long>{
    
}
