package com.unicauca.TallerP2.infraestructura.output.Formateador;

import org.springframework.stereotype.Service;

import com.unicauca.TallerP2.aplicacion.output.IFormeadorResultadoOutputPort;
import com.unicauca.TallerP2.infraestructura.output.controladorExcepciones.excepcionesPropias.EntidadNoExisteException;
import com.unicauca.TallerP2.infraestructura.output.controladorExcepciones.excepcionesPropias.EntidadYaExisteException;
import com.unicauca.TallerP2.infraestructura.output.controladorExcepciones.excepcionesPropias.EstadoInvalidoException;
import com.unicauca.TallerP2.infraestructura.output.controladorExcepciones.excepcionesPropias.ReglaNegocioExcepcion;

@Service
public class FormateadorResultadosImplAdapter implements IFormeadorResultadoOutputPort {

    @Override
    public void retornarRespuestaErrorEntidadExiste(String mensaje) {
        EntidadYaExisteException objException = new EntidadYaExisteException(mensaje);
        throw objException;
    }

    @Override
    public void retornarRespuestaErrorReglaDeNegocio(String mensaje) {
        ReglaNegocioExcepcion objException = new ReglaNegocioExcepcion(mensaje);
        throw objException;
    }

    @Override
    public void retornarRespuestaErrorEntidadNoExiste(String mensaje) {
        EntidadNoExisteException objException = new EntidadNoExisteException(mensaje);
        throw objException;
    }

    @Override
    public void retornarRespuestaErrorEstadoInvalidoParaObservacion(String mensaje) {
        EstadoInvalidoException objException = new EstadoInvalidoException(mensaje);
        throw objException;
    }
    
}
