package com.unicauca.TallerP2.aplicacion.input;

import java.util.List;

import com.unicauca.TallerP2.dominio.Modelos.Docente;

public interface IDocenteQueryInputPort {
    public List<Docente> listarDocentes();
    public List<Docente> listarMiembrosComite();
}