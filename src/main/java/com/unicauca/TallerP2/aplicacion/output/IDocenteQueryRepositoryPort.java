package com.unicauca.TallerP2.aplicacion.output;

import java.util.List;

import com.unicauca.TallerP2.dominio.Modelos.Docente;

public interface IDocenteQueryRepositoryPort {
    public List<Docente> listarDocentes(String nombreGrupo, String patronApellido);
    public boolean existeDocente(Integer idDocente);
    public boolean existeDocentePorCorreo(String correo);
    public List<Docente> listarMiembrosComite();
    public Docente formatosPorDocente(Integer idDocente);
    public List<Docente> listarDocentesPorIds(List<Integer> idsDocentes);
}