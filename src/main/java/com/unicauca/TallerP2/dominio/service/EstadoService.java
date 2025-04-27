package com.unicauca.TallerP2.dominio.service;

import org.springframework.stereotype.Service;

import com.unicauca.TallerP2.dominio.Modelos.PatronEstado.IntEstado;
import com.unicauca.TallerP2.dominio.Modelos.PatronEstado.Resultado;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Service
public class EstadoService {
    
    private IntEstado estadoActual;

    public EstadoService(IntEstado estadoActual) {
        this.estadoActual = estadoActual;
    }

    public Resultado enviarAEvaluacion(Integer idFormato) {
        return estadoActual.enviarAEvaluacion(idFormato);
    }

    public Resultado aprobar(Integer idFormato) {
        return estadoActual.aprobar(idFormato);
    }

    public Resultado rechazar(Integer idFormato) {
        return estadoActual.rechazar(idFormato);
    }

    public Resultado enviarACorreccion(Integer idFormato) {
        return estadoActual.enviarACorreccion(idFormato);
    }

}
