package com.unicauca.TallerP2.aplicacion.input;

import java.util.List;

import com.unicauca.TallerP2.dominio.Modelos.Docente;

public interface IDocenteQueryInputPort {
    public List<Docente> listarDocentes(String nombreGrupo, String patronApellido);
    public List<Docente> listarMiembrosComite();
    public Docente formatosPorDocente(Integer idDocente);
}