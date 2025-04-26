package com.unicauca.TallerP2.dominio.Modelos.PatronEstado;

import com.unicauca.TallerP2.aplicacion.output.IFormatoCommandRepositoryPort;

public class EstFormulado implements IntEstado{

    IFormatoCommandRepositoryPort formatoCommandRepositoryPort;

    public EstFormulado(IFormatoCommandRepositoryPort formatoCommandRepositoryPort) {
        this.formatoCommandRepositoryPort = formatoCommandRepositoryPort;
    }

    @Override
    public Resultado enviarAEvaluacion(Integer idFormato) {
        formatoCommandRepositoryPort.cambiarEstado(idFormato, "evalacuion");
        return new Resultado(true, "El formato ha sido aprobado exitosamente");
    }

    @Override
    public Resultado aprobar(Integer idFormato) {
        return new Resultado(false, "No se puede aprobar un formato en estado formulado");
    }

    @Override
    public Resultado rechazar(Integer idFormato) {
        return new Resultado(false, "No se puede rechazar un formato en estado formulado");
    }

    @Override
    public Resultado enviarACorreccion(Integer idFormato) {
        return new Resultado(false, "No se puede enviar a corrección un formato en estado formulado");
    }
    
}
