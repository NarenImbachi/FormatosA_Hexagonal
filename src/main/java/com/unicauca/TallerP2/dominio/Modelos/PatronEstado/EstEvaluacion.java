package com.unicauca.TallerP2.dominio.Modelos.PatronEstado;

import com.unicauca.TallerP2.aplicacion.output.IFormatoCommandRepositoryPort;

public class EstEvaluacion implements IntEstado{

    private IFormatoCommandRepositoryPort formatoCommandRepositoryPort;

    public EstEvaluacion(IFormatoCommandRepositoryPort formatoCommandRepositoryPort) {
        this.formatoCommandRepositoryPort = formatoCommandRepositoryPort;
    }

    @Override
    public Resultado enviarAEvaluacion(Integer idFormato) {
        return new Resultado(false, "El formato ya se encuentra en evaluación");
    }

    @Override
    public Resultado aprobar(Integer idFormato) {
        formatoCommandRepositoryPort.cambiarEstado(idFormato, "aprobado");
        return new Resultado(true, "El formato ha sido aprobado exitosamente");
    }

    @Override
    public Resultado rechazar(Integer idFormato) {
        formatoCommandRepositoryPort.cambiarEstado(idFormato, "rechazado");
        return new Resultado(true, "El formato ha sido rechazado");
    }

    @Override
    public Resultado enviarACorreccion(Integer idFormato) {
        formatoCommandRepositoryPort.cambiarEstado(idFormato, "evaluacion");
        return new Resultado(true, "El formato ha sido enviado a corrección");
    }
    
}
