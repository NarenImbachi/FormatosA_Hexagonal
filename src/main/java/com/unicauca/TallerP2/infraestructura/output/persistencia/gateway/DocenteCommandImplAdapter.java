package com.unicauca.TallerP2.infraestructura.output.persistencia.gateway;

import org.springframework.stereotype.Component;

import com.unicauca.TallerP2.aplicacion.output.IDocenteCommandRepositoryPort;
import com.unicauca.TallerP2.dominio.Modelos.Docente;
import com.unicauca.TallerP2.infraestructura.output.persistencia.entities.DocenteEntity;
import com.unicauca.TallerP2.infraestructura.output.persistencia.mappers.IDocenteEntityMapper;
import com.unicauca.TallerP2.infraestructura.output.persistencia.repositoros.IDocenteRepositorio;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DocenteCommandImplAdapter implements IDocenteCommandRepositoryPort {

    private final IDocenteRepositorio docenteRepositorio;

    private final IDocenteEntityMapper docenteEntityMapper;

    @Override
    public Docente crearDocente(Docente docente) {
        DocenteEntity docenteCreado = docenteRepositorio.save(docenteEntityMapper.toEntity(docente));
        return docenteEntityMapper.toDomain(docenteCreado);
    }

    @Override
    public Docente modificarDocente(Docente docente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modificarDocente'");
    }

    @Override
    public String cambiarEstadoDocente(int idDocente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cambiarEstadoDocente'");
    }

    
}
