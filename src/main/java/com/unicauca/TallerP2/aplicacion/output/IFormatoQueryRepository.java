package com.unicauca.TallerP2.aplicacion.output;

import java.util.List;

import com.unicauca.TallerP2.dominio.Modelos.FormatoA;

public interface IFormatoQueryRepository {
    public List<FormatoA> listarFormatosPorDocente(Integer idDocente);
    public FormatoA buscarFormatoPorId(Integer idFormato);
    public boolean existeFormatoPorTitulo(String titulo);
}
