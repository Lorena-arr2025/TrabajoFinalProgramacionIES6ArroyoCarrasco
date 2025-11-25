package edu.ar.facilmovilidad.controller;

import edu.ar.facilmovilidad.model.Vehiculo;
import edu.ar.facilmovilidad.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/vehiculos")
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    @GetMapping("/lista")
    public String listarVehiculos(Model model) {
        model.addAttribute("vehiculos", vehiculoService.listarTodos());
        return "vehiculo-lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("vehiculo", new Vehiculo());
        return "vehiculo-form";
    }

    @PostMapping("/guardar")
    public String guardarVehiculo(@ModelAttribute Vehiculo vehiculo) {
        vehiculoService.guardar(vehiculo);
        return "redirect:/vehiculos/lista";
    }
}
