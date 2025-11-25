package edu.ar.facilmovilidad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.ar.facilmovilidad.model.Vehiculo;
import java.util.List;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Integer> {

    // Vehículos activos (estado = TRUE)
    List<Vehiculo> findByEstadoTrue();

    // Vehículos disponibles para viaje
    List<Vehiculo> findByDisponibleTrue();
}


