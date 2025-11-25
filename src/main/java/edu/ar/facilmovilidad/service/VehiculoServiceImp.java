package edu.ar.facilmovilidad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ar.facilmovilidad.model.Vehiculo;
import edu.ar.facilmovilidad.repository.VehiculoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VehiculoServiceImp {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    public List<Vehiculo> listarActivos() {
        return vehiculoRepository.findByEstadoTrue();
    }

    public Vehiculo buscarPorId(Integer id) {
        Optional<Vehiculo> optional = vehiculoRepository.findById(id);
        return optional.orElse(null);
    }

    public void guardar(Vehiculo vehiculo) {
        vehiculoRepository.save(vehiculo);
    }

    public void eliminarLogico(Integer id) {
        Vehiculo vehiculo = buscarPorId(id);
        if (vehiculo != null) {
            vehiculo.setEstado(false);
            vehiculoRepository.save(vehiculo);
        }
    }
}