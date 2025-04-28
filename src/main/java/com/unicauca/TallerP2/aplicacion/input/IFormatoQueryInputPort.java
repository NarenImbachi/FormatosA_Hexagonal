package com.unicauca.TallerP2.aplicacion.input;

import java.util.Date;

import com.unicauca.TallerP2.dominio.Modelos.FormatoA;

public interface IFormatoQueryInputPort {
    public FormatoA buscarFormatoPorId(Integer idFormato);
    public FormatoA buscarFormatoPorTituloFechaInicioFin(String titulo, Date fechaInicio, Date fechaFin);
}