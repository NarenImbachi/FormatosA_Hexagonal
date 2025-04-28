package com.unicauca.TallerP2.dominio.casosDeUso;

import com.unicauca.TallerP2.aplicacion.input.IFormatoCommandInputPort;
import com.unicauca.TallerP2.aplicacion.output.IFormatoCommandRepositoryPort;
import com.unicauca.TallerP2.aplicacion.output.IFormatoQueryRepository;
import com.unicauca.TallerP2.aplicacion.output.IFormeadorResultadoOutputPort;
import com.unicauca.TallerP2.dominio.Modelos.Estado;
import com.unicauca.TallerP2.dominio.Modelos.FormatoA;

public class FormatoCommandAdapter implements IFormatoCommandInputPort {

    private final IFormatoCommandRepositoryPort formatoCommandRepositoryPort;

    private final IFormatoQueryRepository formatoQueryRepository;

    private final IFormeadorResultadoOutputPort formeadorResultadoOutputPort;

    public FormatoCommandAdapter(IFormatoCommandRepositoryPort formatoCommandRepositoryPort, IFormatoQueryRepository formatoQueryRepository, IFormeadorResultadoOutputPort formeadorResultadoOutputPort) {
        this.formatoCommandRepositoryPort = formatoCommandRepositoryPort;
        this.formatoQueryRepository = formatoQueryRepository;
        this.formeadorResultadoOutputPort = formeadorResultadoOutputPort;
    }

    @Override
    public FormatoA crearFormato(FormatoA formatoA) {

        if (formatoQueryRepository.existeFormatoPorTitulo(formatoA.getTitulo())) {
            this.formeadorResultadoOutputPort.retornarRespuestaErrorEntidadExiste("Error, ya existe un formato con el mismo titulo");
        }
    
        Estado estado = new Estado();
        estado.setEstadoActual("formulado");
        estado.setFechaRegistro(new java.util.Date());

        formatoA.setEstado(estado);

        FormatoA formatoCreado = formatoCommandRepositoryPort.crearFormato(formatoA);
        if (formatoCreado == null) {
            this.formeadorResultadoOutputPort.retornarRespuestaErrorEntidadNoExiste("Error, no se pudo crear el formato");
        }
        return formatoCreado;
    }

    @Override
    public FormatoA modificarFormato(FormatoA formatoA) {
        FormatoA formatoExistente = formatoQueryRepository.buscarFormatoPorId(formatoA.getId());
        if (formatoExistente == null) {
            this.formeadorResultadoOutputPort.retornarRespuestaErrorEntidadNoExiste("Error, no se encontro el formato");
        }
    
        if (formatoQueryRepository.existeFormatoPorTitulo(formatoA.getTitulo())) {
            this.formeadorResultadoOutputPort.retornarRespuestaErrorEntidadExiste("Error, ya existe un formato con el mismo titulo");
        }
    
        FormatoA formatoModificado = formatoCommandRepositoryPort.modificarFormato(formatoA);
        if (formatoModificado == null) {
            this.formeadorResultadoOutputPort.retornarRespuestaErrorEntidadNoExiste("Error, no se pudo modificar el formato");
        }
        return formatoModificado;
    }

    @Override
    public String cambiarEstado(Integer idFormato, String estado) {
        return formatoCommandRepositoryPort.cambiarEstado(idFormato, estado);
    }
    
}
