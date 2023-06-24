package com.spectrum.GestionDeTareas.mapper;

import com.spectrum.GestionDeTareas.model.Usuario;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UsuarioMapper {
    void insertUsuario(Usuario usuario);
    void updateUsuario(Usuario usuario);
    void deleteUsuario(int id);
    Usuario getUsuarioById(int id);
    List<Usuario> getAllUsuario();
    List<Usuario> getUsuarioByCriterio(@Param("criterio") String criterio, @Param("valor") Object valor);

}
