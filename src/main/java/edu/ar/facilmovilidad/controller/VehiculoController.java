package edu.ar.facilmovilidad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import edu.ar.facilmovilidad.model.Vehiculo;
import edu.ar.facilmovilidad.service.VehiculoService;
import edu.ar.facilmovilidad.service.ConductorService;

@Controller
@RequestMapping("/vehiculo")
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    @Autowired
    private ConductorService conductorService;

    // LISTAR vehículos activos
    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("vehiculos", vehiculoService.listarActivos());
        return "vehiculo/vehiculoList";
    }

    // CREAR nuevo vehículo
    @GetMapping("/crear")
    public String crear(Model model) {
        model.addAttribute("vehiculo", new Vehiculo());
        model.addAttribute("conductores", conductorService.listarActivos());
        return "vehiculo/vehiculoForm";
    }

    // GUARDAR vehículo
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Vehiculo vehiculo) {
        vehiculoService.guardar(vehiculo);
        return "redirect:/vehiculo/listar";
    }

    // EDITAR vehículo
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        model.addAttribute("vehiculo", vehiculoService.buscarPorId(id));
        model.addAttribute("conductores", conductorService.listarActivos());
        return "vehiculo/vehiculoForm";
    }

    // ELIMINAR lógicamente el vehículo
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        vehiculoService.eliminarLogico(id);
        return "redirect:/vehiculo/listar";
    }
}
