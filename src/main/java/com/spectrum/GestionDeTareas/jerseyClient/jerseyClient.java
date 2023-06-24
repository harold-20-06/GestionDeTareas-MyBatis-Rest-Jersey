package com.spectrum.GestionDeTareas.jerseyClient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

public class jerseyClient {

    public static void main(String[] args) {
        // Crear el cliente de Jersey
        Client client = ClientBuilder.newClient();

        // Realizar una solicitud GET
        String response = client.target("http://localhost:8081/tareas/api/usuario")
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);

        // Procesar la respuesta
        System.out.println(response);

        // Cerrar el cliente
        client.close();
    }
}
