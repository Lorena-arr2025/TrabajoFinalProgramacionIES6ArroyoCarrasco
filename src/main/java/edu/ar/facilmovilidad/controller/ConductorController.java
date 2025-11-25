package edu.ar.facilmovilidad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import edu.ar.facilmovilidad.model.Conductor;
import edu.ar.facilmovilidad.service.ConductorService;

@Controller
@RequestMapping("/conductor")
public class ConductorController {

     @Autowired
    private ConductorService conductorService;

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("conductores", conductorService.listarActivos());
        return "conductorList";   // OK
    }

    @GetMapping("/crear")
    public String crear(Model model) {
        model.addAttribute("conductor", new Conductor());
        return "conductorForm";   // ← CORREGIDO
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Conductor conductor) {
        conductorService.guardar(conductor);
        return "redirect:/conductor/listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        model.addAttribute("conductor", conductorService.buscarPorId(id));
        return "conductorForm";  // ← CORREGIDO
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        conductorService.eliminarLogico(id);
        return "redirect:/conductor/listar";
    }
}