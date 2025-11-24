package edu.ar.facilmovilidad.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.ar.facilmovilidad.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    // Listar solo usuarios activos
    List<Usuario> findByEstadoTrue();

}


