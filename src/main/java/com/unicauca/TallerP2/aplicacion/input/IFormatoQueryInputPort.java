package com.unicauca.TallerP2.aplicacion.input;

import java.util.Date;
import java.util.List;

import com.unicauca.TallerP2.dominio.Modelos.FormatoA;

public interface IFormatoQueryInputPort {
    public FormatoA buscarFormatoPorId(Integer idFormato);
    public List<FormatoA> buscarFormatoPorCorreoFechaInicioFin(String correo, Date fechaInicio, Date fechaFin);
}