package com.unicauca.TallerP2.aplicacion.input;

import com.unicauca.TallerP2.dominio.Modelos.PatronEstado.Resultado;

public interface IGestionEstadoInputPort {
    Resultado enviarAEvaluacion(Integer idFormato);
    Resultado aprobar(Integer idFormato);
    Resultado rechazar(Integer idFormato);
    Resultado enviarACorreccion(Integer idFormato);
}
