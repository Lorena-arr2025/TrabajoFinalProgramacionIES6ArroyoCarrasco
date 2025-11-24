package edu.ar.facilmovilidad.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ar.facilmovilidad.model.Usuario;
import edu.ar.facilmovilidad.repository.UsuarioRepository;



@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listarActivos() {
        return usuarioRepository.findByEstadoTrue();
    }

    public Usuario buscarPorId(Integer id) {
        Optional<Usuario> optional = usuarioRepository.findById(id);
        return optional.orElse(null);
    }

    public void guardar(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public void eliminarLogico(Integer id) {
        Usuario usuario = buscarPorId(id);
        if (usuario != null) {
            usuario.setEstado(false);
            usuarioRepository.save(usuario);
        }
    }
}
