package com.unicauca.TallerP2.aplicacion.input;

import com.unicauca.TallerP2.dominio.Modelos.FormatoA;

public interface IFormatoCommandInputPort {
    public FormatoA crearFormato(FormatoA formatoA);
    public FormatoA modificarFormato(FormatoA formatoA);
    public String cambiarEstado(Integer idFormato, String estado);
}
