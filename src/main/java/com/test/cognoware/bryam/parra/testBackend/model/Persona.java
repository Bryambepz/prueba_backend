package com.test.cognoware.bryam.parra.testBackend.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table( name = "persona")
public class Persona implements Serializable{
    
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( name = "id")
    @Id
    private Long id;

    @Column( name = "cedula")
    private String cedula;

    @Column( name = "fecha_nacimiento")
    private LocalDateTime fecha_nacimiento;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "estudio")
    private String estudio;

    @ManyToMany( mappedBy = "personas")
    private List<Empresa> empresas;
    
    public Persona() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public LocalDateTime getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDateTime fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public List<Empresa> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(List<Empresa> empresas) {
        this.empresas = empresas;
    }
    
}
