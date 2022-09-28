package org.acme.kafka.model;

import java.util.UUID;

import javax.ws.rs.FormParam;

public class Referencia {

    public String id;
    
    @FormParam("nombrePaciente")
    public String nombrePaciente;
    
    @FormParam("dniPaciente")
    public String dniPaciente;
    
    @FormParam("edadPaciente")
    public int edadPaciente;
    
    @FormParam("idCentroReferencia")
    public String idCentroReferencia;
    
    @FormParam("idCentroContraReferencia")
    public String idCentroContraReferencia;
    
    @FormParam("nombreEspecialista")
    public String nombreEspecialista;
    
    @FormParam("dniEspecialista")
    public String dniEspecialista;
    
    @FormParam("fechaRegistro")
    public String fechaRegistro;
    
    @FormParam("diagnostico")
    public String diagnostico;
    
    @FormParam("tratamiento")
    public String tratamiento;
    
    @FormParam("planOindicaciones")
    public String planOindicaciones;

    /**
     * Constructor por defecto requerido para ser deserializado
     */
    public Referencia() { 
        this.id = UUID.randomUUID().toString();
    }

    @Override
    public String toString() {
        return "Referencia{" +
                "id='" + id + '\'' +
                ", paciente=" + nombrePaciente +
                '}';
    }
}