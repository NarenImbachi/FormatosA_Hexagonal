package com.unicauca.TallerP2.dominio.casosDeUso;

import org.springframework.stereotype.Service;

import com.unicauca.TallerP2.aplicacion.input.IEstadoInputPort;
import com.unicauca.TallerP2.aplicacion.output.IFormatoCommandRepositoryPort;
import com.unicauca.TallerP2.aplicacion.output.IFormatoQueryRepository;
import com.unicauca.TallerP2.dominio.Modelos.FormatoA;
import com.unicauca.TallerP2.dominio.Modelos.PatronEstado.EstAprobado;
import com.unicauca.TallerP2.dominio.Modelos.PatronEstado.EstCorrecion;
import com.unicauca.TallerP2.dominio.Modelos.PatronEstado.EstEvaluacion;
import com.unicauca.TallerP2.dominio.Modelos.PatronEstado.EstFormulado;
import com.unicauca.TallerP2.dominio.Modelos.PatronEstado.EstRechazado;
import com.unicauca.TallerP2.dominio.Modelos.PatronEstado.Resultado;
import com.unicauca.TallerP2.dominio.service.EstadoService;

@Service
public class EstadoAdapter implements IEstadoInputPort {

    private EstadoService estadoService;

    private final IFormatoQueryRepository formatoQueryRepository;

    private final IFormatoCommandRepositoryPort formatoCommandRepositoryPort;

    public EstadoAdapter(EstadoService estadoService, IFormatoQueryRepository formatoQueryRepository,
            IFormatoCommandRepositoryPort formatoCommandRepositoryPort) {
        this.estadoService = estadoService;
        this.formatoQueryRepository = formatoQueryRepository;
        this.formatoCommandRepositoryPort = formatoCommandRepositoryPort;
    }

    @Override
    public String cambiarEstado(Integer idFormato, String estado) {
        FormatoA formato = formatoQueryRepository.buscarFormatoPorId(idFormato);

        if (formato == null) {
            return "Formato no encontrado";
        }

        Resultado resultado = null;

        this.asignarEstado(formato.getEstado().getEstadoActual());

        switch (estado) {
            case "evaluacion":
                resultado = estadoService.enviarAEvaluacion(idFormato);
                break;
            case "aprobar":
                resultado = estadoService.aprobar(idFormato);
                break;
            case "rechazar":
                resultado = estadoService.rechazar(idFormato);
                break;
            case "enviarACorreccion":
                resultado = estadoService.enviarACorreccion(idFormato);
                break;
            default:
                return "Estado no válido";
        }

        return resultado.message();
    }

    private void asignarEstado(String estado) {
        switch (estado) {
            case "formulado":
                estadoService.setEstadoActual(new EstFormulado(this.formatoCommandRepositoryPort));
                break;
            case "evaluacion":
                estadoService.setEstadoActual(new EstEvaluacion(this.formatoCommandRepositoryPort));
                break;
            case "aprobado":
                estadoService.setEstadoActual(new EstAprobado());
                break;
            case "rechazado":
                estadoService.setEstadoActual(new EstRechazado());
                break;
            case "correccion":
                estadoService.setEstadoActual(new EstCorrecion(this.formatoCommandRepositoryPort));
                break;
            default:
                throw new IllegalArgumentException("Estado no válido");
        }
    }

    
}
