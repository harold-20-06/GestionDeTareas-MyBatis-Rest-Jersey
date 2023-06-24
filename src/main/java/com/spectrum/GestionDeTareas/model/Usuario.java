package com.spectrum.GestionDeTareas.model;

import lombok.Data;
@Data
public class Usuario {

        private int Id;
        private String nombre;
        private String correo;
        private String contrasena;

    public Usuario(String nombre, String correo, String contrasena) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public Usuario() {
    }
}
