package edu.ar.facilmovilidad.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vehiculo")
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer vehiculoId;

    @Column(nullable = false)
    private String marca;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = false, unique = true)
    private String patente;

    // Tipo: "X", "Luxe", "Premium"
    @Column(nullable = false)
    private String tipo;

    // Relación 1:1 con Conductor
    @OneToOne
    @JoinColumn(name = "conductorId", unique = true)
    private Conductor conductor;

    // Relación 1:N con Viaje
    @OneToMany(mappedBy = "vehiculo", cascade = CascadeType.ALL)
    private List<Viaje> viajesRealizados = new ArrayList<>();

    @Column(nullable = false)
    private boolean disponible = true;

    // Borrado lógico
    @Column(nullable = false)
    private boolean estado = true;

    public Vehiculo() {}

    public Vehiculo(String marca, String modelo, String patente, String tipo, Conductor conductor) {
        this.marca = marca;
        this.modelo = modelo;
        this.patente = patente;
        this.tipo = tipo;
        this.conductor = conductor;
        this.disponible = true;
        this.estado = true;
    }

    // Getters y Setters
    public Integer getVehiculoId() { return vehiculoId; }
    public void setVehiculoId(Integer vehiculoId) { this.vehiculoId = vehiculoId; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public String getPatente() { return patente; }
    public void setPatente(String patente) { this.patente = patente; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public Conductor getConductor() { return conductor; }
    public void setConductor(Conductor conductor) { this.conductor = conductor; }

    public List<Viaje> getViajesRealizados() { return viajesRealizados; }
    public void setViajesRealizados(List<Viaje> viajesRealizados) { this.viajesRealizados = viajesRealizados; }

    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }

    public boolean isEstado() { return estado; }
    public void setEstado(boolean estado) { this.estado = estado; }
}
