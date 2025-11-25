package edu.ar.facilmovilidad.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.ar.facilmovilidad.model.Viaje;


@Repository
public interface ViajeRepository extends JpaRepository<Viaje, Integer> {

    // Listar solo viajes activos
    List<Viaje> findByEstadoTrue();

    // Listar viajes de un usuario
    List<Viaje> findByUsuarioUsuarioId(Integer usuarioId);

    // Listar viajes por vehículo
    List<Viaje> findByVehiculoVehiculoId(Integer vehiculoId);

}  

