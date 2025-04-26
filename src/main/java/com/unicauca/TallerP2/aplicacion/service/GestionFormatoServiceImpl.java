package com.unicauca.TallerP2.aplicacion.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.unicauca.TallerP2.aplicacion.input.IFormatoQueryInputPort;
import com.unicauca.TallerP2.aplicacion.input.IGestionEstadoInputPort;
import com.unicauca.TallerP2.aplicacion.output.IFormatoCommandRepositoryPort;
import com.unicauca.TallerP2.aplicacion.output.IFormatoQueryRepository;
import com.unicauca.TallerP2.dominio.Modelos.Estado;
import com.unicauca.TallerP2.dominio.Modelos.FormatoA;
import com.unicauca.TallerP2.dominio.Modelos.PatronEstado.EstAprobado;
import com.unicauca.TallerP2.dominio.Modelos.PatronEstado.EstCorrecion;
import com.unicauca.TallerP2.dominio.Modelos.PatronEstado.EstEvaluacion;
import com.unicauca.TallerP2.dominio.Modelos.PatronEstado.EstFormulado;
import com.unicauca.TallerP2.dominio.Modelos.PatronEstado.EstRechazado;
import com.unicauca.TallerP2.dominio.Modelos.PatronEstado.IntEstado;
import com.unicauca.TallerP2.dominio.Modelos.PatronEstado.Resultado;
import com.unicauca.TallerP2.dominio.casosDeUso.GestionEstadoFormato;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GestionFormatoServiceImpl implements IGestionEstadoInputPort{

    private final GestionEstadoFormato gestionEstadoFormato;
    private final IFormatoQueryRepository formatoQueryRepository;
    private final IFormatoCommandRepositoryPort formatoCommandRepositoryPort;
    private String estadoActual;

    @Override
    public Resultado enviarAEvaluacion(Integer idFormato) {
        Resultado resultado = gestionEstadoFormato.enviarAEvaluacion(idFormato);
        return resultado;
    }

    @Override
    public Resultado aprobar(Integer idFormato) {
        Resultado resultado = gestionEstadoFormato.aprobar(idFormato);
        return resultado;
    }

    @Override
    public Resultado rechazar(Integer idFormato) {
        Resultado resultado = gestionEstadoFormato.rechazar(idFormato);
        return resultado;
    }

    @Override
    public Resultado enviarACorreccion(Integer idFormato) {
        Resultado resultado = gestionEstadoFormato.enviarACorreccion(idFormato);
        return resultado;
    }

    public IntEstado getEstadoPatron(Integer idFormato) {
        FormatoA formato = formatoQueryRepository.buscarFormatoPorId(idFormato);
        estadoActual = formato.getEstado().getEstadoActual();

        return switch (estadoActual.toLowerCase()) {
            case "formulado"   -> new EstFormulado(formatoCommandRepositoryPort);
            case "evaluacion"  -> new EstEvaluacion(formatoCommandRepositoryPort);
            case "correccion"  -> new EstCorrecion(formatoCommandRepositoryPort);
            case "aprobado"    -> new EstAprobado();
            case "rechazado"   -> new EstRechazado();
            default            -> throw new IllegalArgumentException("Estado no válido: " + estadoActual);
        };
    }
    
}
