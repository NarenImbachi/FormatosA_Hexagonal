package com.unicauca.TallerP2.dominio.Modelos.PatronEstado;

import com.unicauca.TallerP2.aplicacion.output.IFormatoCommandRepositoryPort;

public class EstCorrecion implements IntEstado{

    IFormatoCommandRepositoryPort formatoCommandRepositoryPort;
    
    public EstCorrecion(IFormatoCommandRepositoryPort formatoCommandRepositoryPort) {
        this.formatoCommandRepositoryPort = formatoCommandRepositoryPort;
    }

    @Override
    public Resultado enviarAEvaluacion(Integer idFormato) {
        formatoCommandRepositoryPort.cambiarEstado(idFormato, "evaluacion");
        return new Resultado(true, "El formato ha sido enviado para evaluación");
    }

    @Override
    public Resultado aprobar(Integer idFormato) {
        return new Resultado(false, "No se puede aprobar un formato en corrección");
    }

    @Override
    public Resultado rechazar(Integer idFormato) {
        return new Resultado(false, "No se puede rechazar un formato en corrección");
    }

    @Override
    public Resultado enviarACorreccion(Integer idFormato) {
        return new Resultado(false, "El formato ya se encuentra en corrección");
    }
    
}
