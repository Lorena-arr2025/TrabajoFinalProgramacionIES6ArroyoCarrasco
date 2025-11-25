package edu.ar.facilmovilidad.model;

import jakarta.persistence.*;

@Entity
@Table(name = "conductor")
public class Conductor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer conductorId;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false, unique = true)
    private String dni;

    @Column
    private String telefono;

    @Column
    private String licencia;

    // Relación 1:1 con Vehiculo (mappedBy en Vehiculo)
    //@OneToOne(mappedBy = "conductor")
    //private Vehiculo vehiculo;

    // Borrado lógico
    @Column(nullable = false)
    private boolean estado = true;

    public Conductor() {}

    public Conductor(String nombre, String apellido, String dni, String telefono, String licencia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
        this.licencia = licencia;
        this.estado = true;
    }

    // Getters y Setters
    public Integer getConductorId() { return conductorId; }
    public void setConductorId(Integer conductorId) { this.conductorId = conductorId; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getLicencia() { return licencia; }
    public void setLicencia(String licencia) { this.licencia = licencia; }
    //public Vehiculo getVehiculo() { return vehiculo; }
    //public void setVehiculo(Vehiculo vehiculo) { this.vehiculo = vehiculo; }
    public boolean isEstado() { return estado; }
    public void setEstado(boolean estado) { this.estado = estado; }
}

