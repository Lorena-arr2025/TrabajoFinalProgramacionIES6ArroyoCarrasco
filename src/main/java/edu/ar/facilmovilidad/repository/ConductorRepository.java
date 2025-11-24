package edu.ar.facilmovilidad.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.ar.facilmovilidad.model.Conductor;


@Repository
public interface ConductorRepository extends JpaRepository<Conductor, Integer> {

    // Listar solo conductores activos
    List<Conductor> findByEstadoTrue();

}
