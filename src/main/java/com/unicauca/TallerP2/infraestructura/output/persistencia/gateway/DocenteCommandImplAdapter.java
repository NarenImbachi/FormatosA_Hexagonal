package com.unicauca.TallerP2.infraestructura.output.persistencia.gateway;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.unicauca.TallerP2.aplicacion.output.IDocenteCommandRepositoryPort;
import com.unicauca.TallerP2.dominio.Modelos.Docente;
import com.unicauca.TallerP2.infraestructura.output.persistencia.entities.DocenteEntity;
import com.unicauca.TallerP2.infraestructura.output.persistencia.entities.RolEntity;
import com.unicauca.TallerP2.infraestructura.output.persistencia.mappers.IDocenteEntityMapper;
import com.unicauca.TallerP2.infraestructura.output.persistencia.repositoros.IDocenteRepositorio;
import com.unicauca.TallerP2.infraestructura.output.persistencia.repositoros.IHistoricoRepositorio;
import com.unicauca.TallerP2.infraestructura.output.persistencia.repositoros.IRolRepositorio;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DocenteCommandImplAdapter implements IDocenteCommandRepositoryPort {

    private final IDocenteRepositorio docenteRepositorio;

    private final IDocenteEntityMapper docenteEntityMapper;

    private final IHistoricoRepositorio historicoRepositorio;

    private final IRolRepositorio rolRepositorio;

    @Override
    @Transactional
    public Docente crearDocente(Docente docente) {

        DocenteEntity docenteCreado = docenteRepositorio.save(docenteEntityMapper.toEntity(docente));

        for( int i = 0; i < docenteCreado.getObjHistorico().size(); i++){
            RolEntity rolEntity = rolRepositorio.findByNombre(docente.getObjHistorico().get(i).getObjRol().getNombre());
            docenteCreado.getObjHistorico().get(i).setObjDocente(docenteCreado);
            docenteCreado.getObjHistorico().get(i).setObjRol(rolEntity);
            historicoRepositorio.save(docenteCreado.getObjHistorico().get(i));
        }

        return docenteEntityMapper.toDomain(docenteCreado);
    }

    @Override
    @Transactional
    public Docente modificarDocente(Docente docente) {
        DocenteEntity docenteModificado = docenteRepositorio.save(docenteEntityMapper.toEntity(docente));
        return docenteEntityMapper.toDomain(docenteModificado);
    }
    
}
