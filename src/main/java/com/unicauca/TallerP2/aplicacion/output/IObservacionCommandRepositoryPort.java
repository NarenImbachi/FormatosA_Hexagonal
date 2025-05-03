package com.unicauca.TallerP2.aplicacion.output;

import com.unicauca.TallerP2.dominio.Modelos.Observacion;

public interface IObservacionCommandRepositoryPort {
    public Observacion crearObservacion(Observacion observacion);
}
