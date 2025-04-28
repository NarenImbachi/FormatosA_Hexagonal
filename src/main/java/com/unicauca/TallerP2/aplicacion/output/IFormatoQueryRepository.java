package com.unicauca.TallerP2.aplicacion.output;

import java.util.Date;

import com.unicauca.TallerP2.dominio.Modelos.FormatoA;

public interface IFormatoQueryRepository {
    public FormatoA buscarFormatoPorId(Integer idFormato);
    public boolean existeFormatoPorTitulo(String titulo);
    public FormatoA buscarFormatoPorTituloFechaInicioFin(String titulo, Date fechaInicio, Date fechaFin);
}
