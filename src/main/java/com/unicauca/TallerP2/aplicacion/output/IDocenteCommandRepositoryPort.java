package com.unicauca.TallerP2.aplicacion.output;

import com.unicauca.TallerP2.dominio.Modelos.Docente;

public interface IDocenteCommandRepositoryPort {
    public Docente crearDocente(Docente docente);
    public Docente modificarDocente(Docente docente);
}
