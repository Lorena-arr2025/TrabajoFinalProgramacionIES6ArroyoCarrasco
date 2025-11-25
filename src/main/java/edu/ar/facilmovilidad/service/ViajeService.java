package edu.ar.facilmovilidad.service;

import edu.ar.facilmovilidad.model.Viaje;
import edu.ar.facilmovilidad.repository.ViajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViajeService {

    @Autowired
    private ViajeRepository viajeRepository;

    // Listar todos los viajes
    public List<Viaje> listarTodos() {
        return viajeRepository.findAll();
    }

    // Listar viajes activos
    public List<Viaje> listarActivos() {
        return viajeRepository.findByEstadoTrue();
    }

    // Guardar viaje
    public Viaje guardar(Viaje viaje) {
        return viajeRepository.save(viaje);
    }

    // Buscar por ID
    public Viaje buscarPorId(Integer id) {
        return viajeRepository.findById(id).orElse(null);
    }

    // Borrado lógico
    public void eliminarLogico(Integer id) {
        Viaje viaje = buscarPorId(id);
        if (viaje != null) {
            viaje.setEstado(false);
            viajeRepository.save(viaje);
        }
    }
}
