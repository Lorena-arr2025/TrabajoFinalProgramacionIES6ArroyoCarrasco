package edu.ar.facilmovilidad.service;

import org.springframework.beans.factory.annotation.Autowired;

import edu.ar.facilmovilidad.model.Conductor;
import edu.ar.facilmovilidad.repository.ConductorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConductorServiceImp {
     @Autowired
    private ConductorRepository conductorRepository;

    public List<Conductor> listarActivos() {
        return conductorRepository.findByEstadoTrue();
    }

    public Conductor buscarPorId(Integer id) {
        Optional<Conductor> optional = conductorRepository.findById(id);
        return optional.orElse(null);
    }

    public void guardar(Conductor conductor) {
        conductorRepository.save(conductor);
    }

    public void eliminarLogico(Integer id) {
        Conductor conductor = buscarPorId(id);
        if (conductor != null) {
            conductor.setEstado(false);
            conductorRepository.save(conductor);
        }
    }
}

