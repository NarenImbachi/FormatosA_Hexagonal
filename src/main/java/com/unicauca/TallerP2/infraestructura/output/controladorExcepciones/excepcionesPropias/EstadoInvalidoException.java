package com.unicauca.TallerP2.infraestructura.output.controladorExcepciones.excepcionesPropias;

import com.unicauca.TallerP2.infraestructura.output.controladorExcepciones.estructuraExcepciones.CodigoError;

import lombok.Getter;

@Getter
public class EstadoInvalidoException extends RuntimeException{
    private final String llaveMensaje;
    private final String codigo;

    public EstadoInvalidoException(CodigoError code) {
        super(code.getCodigo());
        this.llaveMensaje = code.getLlaveMensaje();
        this.codigo = code.getCodigo();
    }
    public EstadoInvalidoException(final String message) {
        super(message);
        this.llaveMensaje = CodigoError.VIOLACION_REGLA_DE_NEGOCIO.getLlaveMensaje();
        this.codigo = CodigoError.VIOLACION_REGLA_DE_NEGOCIO.getCodigo();
    }
}
