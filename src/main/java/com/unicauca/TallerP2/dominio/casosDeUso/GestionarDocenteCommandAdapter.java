package com.unicauca.TallerP2.dominio.casosDeUso;

import org.springframework.stereotype.Service;

import com.unicauca.TallerP2.aplicacion.input.IDocenteCommandInputPort;
import com.unicauca.TallerP2.aplicacion.output.IDocenteCommandRepositoryPort;
import com.unicauca.TallerP2.aplicacion.output.IDocenteQueryRepositoryPort;
import com.unicauca.TallerP2.aplicacion.output.IFormeadorResultadoOutputPort;
import com.unicauca.TallerP2.dominio.Modelos.Docente;

@Service
public class GestionarDocenteCommandAdapter implements IDocenteCommandInputPort {
    private final IDocenteCommandRepositoryPort docenteCommandRepositoryPort;
    private final IFormeadorResultadoOutputPort formeadorResultadoOutputPort;
    private final IDocenteQueryRepositoryPort docenteQueryRepositoryPort;

    public GestionarDocenteCommandAdapter(IDocenteCommandRepositoryPort docenteCommandRepositoryPort, IFormeadorResultadoOutputPort formeadorResultadoOutputPort, IDocenteQueryRepositoryPort docenteQueryRepositoryPort) {
        this.docenteCommandRepositoryPort = docenteCommandRepositoryPort;
        this.formeadorResultadoOutputPort = formeadorResultadoOutputPort;
        this.docenteQueryRepositoryPort = docenteQueryRepositoryPort;
    }   

    @Override
    public Docente crearDocente(Docente docente) {

        if(this.docenteCommandRepositoryPort.existeDocentePorCorreo(docente.getCorreo())) {
            this.formeadorResultadoOutputPort.retornarRespuestaErrorEntidadExiste("Error, hay un docente registrado con el mismo correo");
        }
        
        return this.docenteCommandRepositoryPort.crearDocente(docente);
    }

    @Override
    public Docente modificarDocente(Docente docente) {
        if(this.docenteQueryRepositoryPort.existeDocente(docente.getId()))
            this.formeadorResultadoOutputPort.retornarRespuestaErrorEntidadNoExiste("Error, el docente no existe en la base de datos");
        
        if(this.docenteCommandRepositoryPort.existeDocentePorCorreo(docente.getCorreo())) 
            this.formeadorResultadoOutputPort.retornarRespuestaErrorEntidadExiste("Error, hay un docente registrado con el mismo correo");
        
        return this.docenteCommandRepositoryPort.modificarDocente(docente);
    }

    @Override
    public String cambiarEstadoDocente(int idDocente) {
        if(this.docenteQueryRepositoryPort.existeDocente(idDocente))
            this.formeadorResultadoOutputPort.retornarRespuestaErrorEntidadNoExiste("Error, el docente no existe en la base de datos");
        return "El estado del docente ha sido cambiado correctamente";
    }
}
