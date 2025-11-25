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

    // LISTAR TODOS
    public List<Vehiculo> listarTodos() {
        return vehiculoRepository.findAll();
    }

    // LISTAR SOLO ACTIVOS (estado = true)
    public List<Vehiculo> listarActivos() {
        return vehiculoRepository.findAll()
                .stream()
                .filter(Vehiculo::isEstado)   // usa tu getter REAL
                .toList();
    }

    // LISTAR SOLO VEHÍCULOS DISPONIBLES
    public List<Vehiculo> listarDisponibles() {
        return vehiculoRepository.findAll()
                .stream()
                .filter(Vehiculo::isDisponible)   // usa tu getter REAL
                .toList();
    }

    // GUARDAR
    public Vehiculo guardar(Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }

    // BUSCAR POR ID
    public Vehiculo buscarPorId(Integer id) {
        return vehiculoRepository.findById(id).orElse(null);
    }

    // BORRADO LÓGICO
    public void eliminarLogico(Integer id) {
        Vehiculo vehiculo = buscarPorId(id);
        if (vehiculo != null) {
            vehiculo.setEstado(false); // tu atributo REAL
            vehiculoRepository.save(vehiculo);
        }
    }
}