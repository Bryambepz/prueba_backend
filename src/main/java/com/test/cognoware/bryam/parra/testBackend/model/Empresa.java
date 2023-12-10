package com.test.cognoware.bryam.parra.testBackend.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table( name = "empresa" )
public class Empresa implements Serializable{

    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( name = "id")
    @Id
    private Long id;

    @Column( name = "direccion")
    private String direccion;

    @Column( name = "nombre")
    private String nombre;

    @Column( name = "telefono")
    private String telefono;

    @ManyToMany
    @JoinTable(
    name = "empresa_persona", 
    joinColumns = @JoinColumn(name = "empresa_id"), 
    inverseJoinColumns = @JoinColumn(name = "persona_id"))
    private List<Persona> personas;
    
    public Empresa() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }
    
}
