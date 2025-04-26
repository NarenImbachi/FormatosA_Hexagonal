package com.unicauca.TallerP2.dominio.casosDeUso;

import com.unicauca.TallerP2.aplicacion.input.IFormatoQueryInputPort;
import com.unicauca.TallerP2.aplicacion.input.IGestionEstadoInputPort;
import com.unicauca.TallerP2.dominio.Modelos.FormatoA;
import com.unicauca.TallerP2.dominio.Modelos.PatronEstado.Resultado;

public class GestionEstadoFormato implements IGestionEstadoInputPort {

    IFormatoQueryInputPort formatoQueryInputPort;

    public GestionEstadoFormato(IFormatoQueryInputPort formatoQueryInputPort) {
        this.formatoQueryInputPort = formatoQueryInputPort;
    }

    @Override
    public Resultado enviarAEvaluacion(Integer idFormato) {
        FormatoA formato = formatoQueryInputPort.buscarFormatoPorId(idFormato);
        return formato.getEstado().getEstadoPatron().enviarAEvaluacion(formato.getId());
    }

    @Override
    public Resultado aprobar(Integer idFormato) {
        FormatoA formato = formatoQueryInputPort.buscarFormatoPorId(idFormato);
        return formato.getEstado().getEstadoPatron().aprobar(formato.getId());
    }

    @Override
    public Resultado rechazar(Integer idFormato) {
        FormatoA formato = formatoQueryInputPort.buscarFormatoPorId(idFormato);
        return formato.getEstado().getEstadoPatron().rechazar(formato.getId());
    }

    @Override
    public Resultado enviarACorreccion(Integer idFormato) {
        FormatoA formato = formatoQueryInputPort.buscarFormatoPorId(idFormato);
        return formato.getEstado().getEstadoPatron().enviarACorreccion(formato.getId());
    }
}
