package edu.ar.facilmovilidad.controller;

import edu.ar.facilmovilidad.model.Viaje;
import edu.ar.facilmovilidad.service.ViajeService;
import edu.ar.facilmovilidad.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/viajes")
public class ViajeController {

    @Autowired
    private ViajeService viajeService;

    @Autowired
    private VehiculoService vehiculoService;

    // Mostrar lista de viajes
    @GetMapping("/lista")
    public String listarViajes(Model model) {
        model.addAttribute("viajes", viajeService.listarTodos());
        return "viaje-lista";
    }

    // Mostrar formulario para crear un viaje
    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("viaje", new Viaje());
        model.addAttribute("vehiculos", vehiculoService.listarActivos());
        return "viaje-form";
    }

    // Guardar viaje
    @PostMapping("/guardar")
    public String guardarViaje(@ModelAttribute Viaje viaje) {
        viajeService.guardar(viaje);
        return "redirect:/viajes/lista";
    }
}
