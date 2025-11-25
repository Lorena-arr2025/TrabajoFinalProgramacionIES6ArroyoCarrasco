package edu.ar.facilmovilidad.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer usuarioId;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String telefono;

    @Column
    private String direccion;

    // Relación 1:N con Viaje
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Viaje> viajesRealizados = new ArrayList<>();

    // Borrado lógico
    @Column(nullable = false)
    private boolean estado = true;

    // Constructor vacío
    public Usuario() {}

    // Constructor con parámetros (sin ID)
    public Usuario(String nombre, String apellido, String email, String telefono, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        this.estado = true;
    }

    // Getters y Setters
    public Integer getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Integer usuarioId) { this.usuarioId = usuarioId; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public List<Viaje> getViajesRealizados() { return viajesRealizados; }
    public void setViajesRealizados(List<Viaje> viajesRealizados) { this.viajesRealizados = viajesRealizados; }
    public boolean isEstado() { return estado; }
    public void setEstado(boolean estado) { this.estado = estado; }
}
