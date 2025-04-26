package com.unicauca.TallerP2.dominio.Modelos.PatronEstado;

public class EstAprobado implements IntEstado{

    @Override
    public Resultado enviarAEvaluacion(Integer idFormato) {
        return new Resultado(false, "El formato ya ha sido aprobado");
    }

    @Override
    public Resultado aprobar(Integer idFormato) {
        return new Resultado(false, "El formato ya ha sido aprobado");
    }

    @Override
    public Resultado rechazar(Integer idFormato) {
        return new Resultado(false, "El formato ya ha sido aprobado");
    }

    @Override
    public Resultado enviarACorreccion(Integer idFormato) {
        return new Resultado(false, "El formato ya ha sido aprobado");
    }
    
}
