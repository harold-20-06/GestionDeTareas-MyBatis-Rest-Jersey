package com.spectrum.GestionDeTareas.controller;

import com.spectrum.GestionDeTareas.model.Usuario;
import com.spectrum.GestionDeTareas.service.UsuarioServiceImpl;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/usuario")
public class UsuarioController {

    public UsuarioController() {

    }

    private final UsuarioServiceImpl usuarioService = new UsuarioServiceImpl();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUsuario() {
        try {
            List<Usuario> usuarios = usuarioService.getAllUsuario();
            return Response.ok(usuarios).build();
        } catch (Exception e) {
            // Manejar la excepción y devolver una respuesta apropiada
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error al obtener la lista de usuarios")
                    .build();
        }
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUsuario(Usuario usuario) {
        try {
            // Lógica para insertar el usuario en la base de datos
            usuarioService.insertUsuario(usuario);
            return Response.status(Response.Status.CREATED).build();
        } catch (Exception e) {
            // Manejar la excepción y devolver una respuesta apropiada
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error al insertar el usuario")
                    .build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUsuario(@PathParam("id") int id, Usuario usuario) {
        try {
            // Lógica para actualizar el usuario en la base de datos
            usuario.setId(id);
            usuarioService.updateUsuario(usuario);
            return Response.ok().build();
        } catch (Exception e) {
            // Manejar la excepción y devolver una respuesta apropiada
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error al actualizar el usuario")
                    .build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteUsuario(@PathParam("id") int id) {
        try {
            // Lógica para eliminar el usuario de la base de datos
            usuarioService.deleteUsuario(id);
            return Response.ok().build();
        } catch (Exception e) {
            // Manejar la excepción y devolver una respuesta apropiada
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error al eliminar el usuario")
                    .build();
        }
    }

    @GET
    @Path("/buscar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarPorCriterio(@QueryParam("criterio") String criterio, @QueryParam("valor") String valor) {
        try {
            List<Usuario> usuarios = usuarioService.getUsuarioByCriterio(criterio, valor);
            return Response.ok(usuarios).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error al buscar usuarios por criterio")
                    .build();
        }
    }
}
