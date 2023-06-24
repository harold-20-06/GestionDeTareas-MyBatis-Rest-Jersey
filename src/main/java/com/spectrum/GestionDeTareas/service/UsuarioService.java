package com.spectrum.GestionDeTareas.service;

import com.spectrum.GestionDeTareas.model.Usuario;

import java.util.List;

public interface UsuarioService {

    boolean insertUsuario(Usuario usuario);
    boolean updateUsuario(Usuario usuario);
    boolean deleteUsuario(int id);
    List<Usuario> getAllUsuario();
    Usuario getUsuarioById(int id);
    List<Usuario> getUsuarioByCriterio(String criterio, Object valor);
}
