package edu.ar.facilmovilidad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import edu.ar.facilmovilidad.model.Usuario;
import edu.ar.facilmovilidad.model.Vehiculo;
import edu.ar.facilmovilidad.model.Viaje;
import edu.ar.facilmovilidad.service.UsuarioService;
import edu.ar.facilmovilidad.service.VehiculoService;
import edu.ar.facilmovilidad.service.ViajeService;

@Controller
@RequestMapping("/viaje")
public class ViajeController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private VehiculoService vehiculoService;

    @Autowired
    private ViajeService viajeService;

    // Paso 1 → seleccionar usuario
    @GetMapping("/seleccionarUsuario")
    public String seleccionarUsuario(Model model) {
        model.addAttribute("usuarios", usuarioService.listarActivos());
        return "viaje/viajeList";
    }

    // Paso 2 → seleccionar vehículo
    @GetMapping("/seleccionarVehiculo/{usuarioId}")
    public String seleccionarVehiculo(@PathVariable Integer usuarioId, Model model) {
        model.addAttribute("usuario", usuarioService.buscarPorId(usuarioId));
        model.addAttribute("vehiculos", vehiculoService.listarDisponibles());
        return "viaje/viajeForm";
    }

    // Paso 3 → guardar el viaje
    @PostMapping("/guardar")
    public String guardar(
            @RequestParam Integer usuarioId,
            @RequestParam Integer vehiculoId,
            @RequestParam String tipoDistancia,
            Model model) {

        Usuario usuario = usuarioService.buscarPorId(usuarioId);
        Vehiculo vehiculo = vehiculoService.buscarPorId(vehiculoId);

        Viaje viaje = viajeService.registrarViaje(usuario, vehiculo, tipoDistancia);

        model.addAttribute("viaje", viaje);
        model.addAttribute("usuario", usuario);
        model.addAttribute("vehiculo", vehiculo);
        model.addAttribute("conductor", vehiculo.getConductor());

        return "viaje/viajeResumen";
    }
}