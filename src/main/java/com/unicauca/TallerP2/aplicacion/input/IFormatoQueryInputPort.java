package com.unicauca.TallerP2.aplicacion.input;

import java.util.List;

import com.unicauca.TallerP2.dominio.Modelos.FormatoA;

public interface IFormatoQueryInputPort {
    public List<FormatoA> listarFormatosPorDocente(Integer idDocente);
    public FormatoA buscarFormatoPorId(Integer idFormato);
}