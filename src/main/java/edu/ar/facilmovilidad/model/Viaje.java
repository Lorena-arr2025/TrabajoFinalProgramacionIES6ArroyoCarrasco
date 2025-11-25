// Redraw branch position test
package edu.ar.facilmovilidad.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "viaje")
public class Viaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer viajeId;

    @Column(nullable = false)
    private String tipoDistancia;

    @Column
    private Double costoFinal;

    @Column
    private LocalDateTime fechaViaje = LocalDateTime.now();

    // Relaciones
    @ManyToOne
    @JoinColumn(name = "usuarioId", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "vehiculoId", nullable = false)
    private Vehiculo vehiculo;

    // Borrado lógico
    @Column(nullable = false)
    private boolean estado = true;

    public Viaje() {}

    public Viaje(String tipoDistancia, Double costoFinal, Usuario usuario, Vehiculo vehiculo) {
        this.tipoDistancia = tipoDistancia;
        this.costoFinal = costoFinal;
        this.usuario = usuario;
        this.vehiculo = vehiculo;
        this.fechaViaje = LocalDateTime.now();
        this.estado = true;
    }

    // Getters y Setters
    public Integer getViajeId() { return viajeId; }
    public void setViajeId(Integer viajeId) { this.viajeId = viajeId; }

    public String getTipoDistancia() { return tipoDistancia; }
    public void setTipoDistancia(String tipoDistancia) { this.tipoDistancia = tipoDistancia; }

    public Double getCostoFinal() { return costoFinal; }
    public void setCostoFinal(Double costoFinal) { this.costoFinal = costoFinal; }

    public LocalDateTime getFechaViaje() { return fechaViaje; }
    public void setFechaViaje(LocalDateTime fechaViaje) { this.fechaViaje = fechaViaje; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public Vehiculo getVehiculo() { return vehiculo; }
    public void setVehiculo(Vehiculo vehiculo) { this.vehiculo = vehiculo; }

    public boolean isEstado() { return estado; }
    public void setEstado(boolean estado) { this.estado = estado; }
}
