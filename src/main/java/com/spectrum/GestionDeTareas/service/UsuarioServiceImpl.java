package com.spectrum.GestionDeTareas.service;

import com.spectrum.GestionDeTareas.model.Usuario;
import com.spectrum.GestionDeTareas.repository.UsuarioRepository;
import com.spectrum.GestionDeTareas.repository.UsuarioRepositoryImpl;
import java.util.List;

public class UsuarioServiceImpl implements UsuarioService{
    private static final UsuarioRepository usuarioRepository = new UsuarioRepositoryImpl();

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
    }

    public UsuarioServiceImpl() {

    }


    @Override
    public boolean insertUsuario(Usuario usuario) {
        boolean esExitoso = usuarioRepository.insertUsuario(usuario);
        return esExitoso;
    }

    public boolean updateUsuario(Usuario usuario) {
        boolean esExitoso = usuarioRepository.updateUsuario(usuario);
        return esExitoso;
    }

    @Override
    public boolean deleteUsuario(int id) {
        boolean esExitoso = usuarioRepository.deleteUsuario(id);
        return esExitoso;
    }

    @Override
    public List<Usuario> getAllUsuario() {
        List<Usuario> usuarios = usuarioRepository.getAllUsuario();
        return usuarios;
    }


    public Usuario getUsuarioById(int id) {
        Usuario usuario = usuarioRepository.getUsuarioById(id);
        return usuario;
    }

    public List<Usuario> getUsuarioByCriterio(String criterio, Object valor) {
        List<Usuario> usuarios = usuarioRepository.getUsuarioByCriterio(criterio,valor);
        return usuarios;
    }

//    public List<Usuario> getUsuarioByCriterio(String criterio, int valor) {
//        List<Usuario> usuarios = usuarioRepository.getUsuarioByCriterio(criterio,valor);
//        return usuarios;
//    }
}
