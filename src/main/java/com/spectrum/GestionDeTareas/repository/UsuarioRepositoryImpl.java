package com.spectrum.GestionDeTareas.repository;

import com.spectrum.GestionDeTareas.mapper.UsuarioMapper;
import com.spectrum.GestionDeTareas.model.Usuario;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

import static com.spectrum.GestionDeTareas.utilities.BaseDatos.openSession;

public class UsuarioRepositoryImpl implements UsuarioRepository {

    @Override
    public boolean insertUsuario(Usuario usuario) {
        boolean esExitoso = false;
        SqlSession sqlSession = null;
        UsuarioMapper usuarioMapper;

        try {
//            abrir session
            sqlSession = openSession();
            // Obteniendo el Mapper
            usuarioMapper = sqlSession.getMapper(UsuarioMapper.class);

            // Insert usuario
            usuarioMapper.insertUsuario(usuario);
            sqlSession.commit();
            esExitoso = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(sqlSession != null) sqlSession.close();
            } catch (Exception e) {
            }
        }
        return esExitoso;
    }

    public boolean updateUsuario(Usuario usuario) {
        boolean esExitoso = false;
        SqlSession sqlSession = null;
        UsuarioMapper usuarioMapper;

        try {
//            abrir session
            sqlSession = openSession();
            // Obteniendo el Mapper
            usuarioMapper = sqlSession.getMapper(UsuarioMapper.class);
            // Insert usuario
            usuarioMapper.updateUsuario(usuario);
            sqlSession.commit();
            esExitoso = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(sqlSession != null) sqlSession.close();
            } catch (Exception e) {
            }
        }
        return esExitoso;
    }

    @Override
    public boolean deleteUsuario(int id) {
        boolean esExitoso = false;
        SqlSession sqlSession = null;
        UsuarioMapper usuarioMapper;
        try {
//            abrir session
            sqlSession = openSession();
            // Obteniendo el Mapper
            usuarioMapper = sqlSession.getMapper(UsuarioMapper.class);
            // Insert usuario
            usuarioMapper.deleteUsuario(id);
            sqlSession.commit();
            esExitoso = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(sqlSession != null) sqlSession.close();
            } catch (Exception e) {
            }
        }
        return esExitoso;
    }

    @Override
    public List<Usuario> getAllUsuario() {
        List<Usuario> usuarios = null;
        SqlSession sqlSession = null;
        UsuarioMapper usuarioMapper;

        try {
//            abrir session
            sqlSession = openSession();
            // Obteniendo el Mapper
            usuarioMapper = sqlSession.getMapper(UsuarioMapper.class);
            // Insert usuario
            usuarios = usuarioMapper.getAllUsuario();
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(sqlSession != null) sqlSession.close();
            } catch (Exception e) {
            }
        }
        return usuarios;
    }
    public Usuario getUsuarioById(int id) {
        Usuario usuario = null;
        SqlSession sqlSession = null;
        UsuarioMapper usuarioMapper;

        try {
//            abrir session
            sqlSession = openSession();
            // Obteniendo el Mapper
            usuarioMapper = sqlSession.getMapper(UsuarioMapper.class);
            // Insert usuario
            usuario = usuarioMapper.getUsuarioById(id);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(sqlSession != null) sqlSession.close();
            } catch (Exception e) {
            }
        }
        return usuario;
    }

    @Override
    public List<Usuario> getUsuarioByCriterio(String criterio, Object valor) {
        List<Usuario> usuarios = new ArrayList<>();
        SqlSession sqlSession = null;
        UsuarioMapper usuarioMapper;

        try {
//            abrir session
            sqlSession = openSession();
            // Obteniendo el Mapper
            usuarioMapper = sqlSession.getMapper(UsuarioMapper.class);
            // Insert usuario
            usuarios = usuarioMapper.getUsuarioByCriterio(criterio,valor);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(sqlSession != null) sqlSession.close();
            } catch (Exception e) {
            }
        }
        return usuarios;

    }

}


