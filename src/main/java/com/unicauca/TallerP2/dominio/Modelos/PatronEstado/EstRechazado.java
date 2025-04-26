package com.unicauca.TallerP2.dominio.Modelos.PatronEstado;

public class EstRechazado implements IntEstado{

    @Override
    public Resultado enviarAEvaluacion(Integer idFormato) {
        return new Resultado(false, "El formato ya ha sido rechazado");
    }

    @Override
    public Resultado aprobar(Integer idFormato) {
        return new Resultado(false, "El formato ya ha sido rechazado");
    }

    @Override
    public Resultado rechazar(Integer idFormato) {
        return new Resultado(false, "El formato ya ha sido rechazado");
    }

    @Override
    public Resultado enviarACorreccion(Integer idFormato) {
        return new Resultado(false, "El formato ya ha sido rechazado");
    }
    
}
