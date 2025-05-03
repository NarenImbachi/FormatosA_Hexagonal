package com.unicauca.TallerP2.aplicacion.output;

import java.util.Date;
import java.util.List;

import com.unicauca.TallerP2.dominio.Modelos.Evaluacion;
import com.unicauca.TallerP2.dominio.Modelos.FormatoA;

public interface IFormatoQueryRepository {
    public FormatoA buscarFormatoPorId(Integer idFormato);
    public boolean existeFormatoPorTitulo(String titulo);
    public List<FormatoA> buscarFormatoPorCorreoFechaInicioFin(String correo, Date fechaInicio, Date fechaFin);
    public Evaluacion obtenerUltimaEvaluacion(Integer idFormatoA);
}
