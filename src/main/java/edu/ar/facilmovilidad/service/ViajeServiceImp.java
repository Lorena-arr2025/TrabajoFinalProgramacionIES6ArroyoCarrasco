package edu.ar.facilmovilidad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ar.facilmovilidad.model.Viaje;
import edu.ar.facilmovilidad.model.Vehiculo;
import edu.ar.facilmovilidad.repository.ViajeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ViajeServiceImp {

    @Autowired
    private ViajeRepository viajeRepository;

    public List<Viaje> listarActivos() {
        return viajeRepository.findByEstadoTrue();
    }

    public Viaje buscarPorId(Integer id) {
        Optional<Viaje> optional = viajeRepository.findById(id);
        return optional.orElse(null);
    }

    public void guardar(Viaje viaje) {
        viajeRepository.save(viaje);
    }

    public void eliminarLogico(Integer id) {
        Viaje viaje = buscarPorId(id);
        if (viaje != null) {
            viaje.setEstado(false);
            viajeRepository.save(viaje);
        }
    }

    public double calcularCosto(Viaje viaje, Vehiculo vehiculo) {

        double costoBase = switch (viaje.getTipoDistancia()) {
            case "corta" -> 7000;
            case "media" -> 7000;
            case "larga" -> 20000;
            default -> 0;
        };

        double multiplicador = switch (vehiculo.getTipo()) {
            case "X" -> 1.0;
            case "Luxe" -> 1.10;
            case "Premium" -> 1.20;
            default -> 1.0;
        };

        return costoBase * multiplicador;
    }
}