package com.unicauca.TallerP2.aplicacion.input;

import java.util.List;

import com.unicauca.TallerP2.dominio.Modelos.Observacion;

public interface IObservacionCommandInputPort {
    public Observacion crearObservacion(String observacion, Integer idFormatoA, List<Integer> docentesId);
}
