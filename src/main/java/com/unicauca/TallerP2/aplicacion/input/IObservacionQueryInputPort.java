package com.unicauca.TallerP2.aplicacion.input;

import java.util.List;

import com.unicauca.TallerP2.dominio.Modelos.Observacion;

public interface IObservacionQueryInputPort {
    public List<Observacion> listarObservacionesPorDocente(Integer idFormato);
}
