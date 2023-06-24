package com.spectrum.GestionDeTareas.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Tarea {

    private int id;
    private String titulo;
    private String descripcion;
    private String prioridad;
    private Date fechaCreacion;
    private Date fechaVencimiento;
    private String estado;
    private int usuarioId;
}




