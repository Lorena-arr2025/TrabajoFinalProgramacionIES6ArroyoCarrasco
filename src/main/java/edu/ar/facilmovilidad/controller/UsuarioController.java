package edu.ar.facilmovilidad.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import edu.ar.facilmovilidad.model.Usuario;
import edu.ar.facilmovilidad.service.UsuarioService;


@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("usuarios", usuarioService.listarActivos());
        return "usuario/usuarioList";
    }

    @GetMapping("/crear")
    public String crear(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuario/usuarioForm";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Usuario usuario) {
        usuarioService.guardar(usuario);
        return "redirect:/usuario/listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        Usuario usuario = usuarioService.buscarPorId(id);
        model.addAttribute("usuario", usuario);
        return "usuario/usuarioForm";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        usuarioService.eliminarLogico(id);
        return "redirect:/usuario/listar";
    }
}
    
