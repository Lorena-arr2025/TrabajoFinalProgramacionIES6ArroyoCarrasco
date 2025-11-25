package edu.ar.facilmovilidad.service;

import edu.ar.facilmovilidad.model.Vehiculo;
import edu.ar.facilmovilidad.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    // Listar todos los vehículos
    public List<Vehiculo> listarTodos() {
        return vehiculoRepository.findAll();
    }

    // Listar solo vehículos activos
    public List<Vehiculo> listarActivos() {
        return vehiculoRepository.findByEstadoTrue();
    }

    // Guardar / actualizar un vehículo
    public Vehiculo guardar(Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }

    // Buscar por ID
    public Vehiculo buscarPorId(Integer id) {
        return vehiculoRepository.findById(id).orElse(null);
    }

    // Borrado lógico (estado = false)
    public void eliminarLogico(Integer id) {
        Vehiculo vehiculo = buscarPorId(id);
        if (vehiculo != null) {
            vehiculo.setEstado(false);
            vehiculoRepository.save(vehiculo);
        }
    }
}
