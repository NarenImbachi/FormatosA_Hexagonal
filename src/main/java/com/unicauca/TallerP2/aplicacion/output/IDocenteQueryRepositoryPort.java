package com.unicauca.TallerP2.aplicacion.output;

import java.util.List;

import com.unicauca.TallerP2.dominio.Modelos.Docente;

public interface IDocenteQueryRepositoryPort {
    public List<Docente> listarDocentes();
    public boolean existeDocente(Integer idDocente);
}