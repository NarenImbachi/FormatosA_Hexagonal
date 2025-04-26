package com.unicauca.TallerP2.dominio.Modelos.PatronEstado;


public interface IntEstado {
    Resultado enviarAEvaluacion(Integer idFormato);
    Resultado aprobar(Integer idFormato);
    Resultado rechazar(Integer idFormato);
    Resultado enviarACorreccion(Integer idFormato);
}
