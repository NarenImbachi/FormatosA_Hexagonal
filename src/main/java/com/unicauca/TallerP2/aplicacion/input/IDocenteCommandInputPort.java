package com.unicauca.TallerP2.aplicacion.input;

import com.unicauca.TallerP2.dominio.Modelos.Docente;

public interface IDocenteCommandInputPort {
    public Docente crearDocente(Docente docente);
    public Docente modificarDocente(Docente docente);
    public String cambiarEstadoDocente(int idDocente);
}
