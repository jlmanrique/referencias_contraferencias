package org.acme.kafka.model;

public class Referencia {

    public String id;
    public String nombrePaciente;
    public String dniPaciente;
    public int edadPaciente;
    public String idCentroReferencia;
    public String idCentroContraReferencia;
    public String nombreEspecialista;
    public String dniEspecialista;
    public String fechaRegistro;
    public String diagnostico;
    public String tratamiento;
    public String planOindicaciones;

    /**
     * Default constructor required for Jackson serializer
     */
    public Referencia() { }

    @Override
    public String toString() {
        return "Referencia{" +
                "id='" + id + '\'' +
                ", paciente=" + nombrePaciente +
                '}';
    }
}