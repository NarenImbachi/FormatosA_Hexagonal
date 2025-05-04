package com.unicauca.TallerP2.dominio.casosDeUso;

import java.util.List;

import com.unicauca.TallerP2.aplicacion.input.IDocenteQueryInputPort;
import com.unicauca.TallerP2.aplicacion.output.IDocenteQueryRepositoryPort;
import com.unicauca.TallerP2.aplicacion.output.IFormeadorResultadoOutputPort;
import com.unicauca.TallerP2.dominio.Modelos.Docente;


public class DocenteQueryAdapter implements IDocenteQueryInputPort {

    private final IDocenteQueryRepositoryPort docenteQueryRepositoryPort;

    private final IFormeadorResultadoOutputPort formeadorResultadoOutputPort;

    public DocenteQueryAdapter(IDocenteQueryRepositoryPort docenteQueryRepositoryPort, IFormeadorResultadoOutputPort formeadorResultadoOutputPort) {
        this.docenteQueryRepositoryPort = docenteQueryRepositoryPort;
        this.formeadorResultadoOutputPort = formeadorResultadoOutputPort;
    }

    @Override
    public List<Docente> listarDocentes(String nombreGrupo, String patronApellido) {
        List<Docente> listaDocentes = docenteQueryRepositoryPort.listarDocentes(nombreGrupo, patronApellido);
        if (listaDocentes.isEmpty()) {
            this.formeadorResultadoOutputPort.retornarRespuestaErrorEntidadNoExiste("Error, no hay docentes registrados en la base de datos");
        }
        return listaDocentes;
    }

    @Override
    public List<Docente> listarMiembrosComite() {
        List<Docente> listaMiembrosComite = docenteQueryRepositoryPort.listarMiembrosComite();
        if (listaMiembrosComite.isEmpty()) {
            this.formeadorResultadoOutputPort.retornarRespuestaErrorEntidadNoExiste("Error, no hay docentes registrados en la base de datos");
        }
        return listaMiembrosComite;
    }

    @Override
    public Docente formatosPorDocente(Integer idDocente) {   
        if (!docenteQueryRepositoryPort.existeDocente(idDocente)) {
            this.formeadorResultadoOutputPort.retornarRespuestaErrorEntidadNoExiste("Error, no hay docentes registrados con ese id en la base de datos");
        }
        Docente docente = docenteQueryRepositoryPort.formatosPorDocente(idDocente);
        return docente;
    }
    
}
