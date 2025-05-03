package com.unicauca.TallerP2.infraestructura.output.persistencia.gateway;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.unicauca.TallerP2.aplicacion.output.IDocenteQueryRepositoryPort;
import com.unicauca.TallerP2.dominio.Modelos.Docente;
import com.unicauca.TallerP2.infraestructura.output.persistencia.entities.DocenteEntity;
import com.unicauca.TallerP2.infraestructura.output.persistencia.mappers.IDocenteEagerEntityMapper;
import com.unicauca.TallerP2.infraestructura.output.persistencia.mappers.IDocenteEntityMapper;
import com.unicauca.TallerP2.infraestructura.output.persistencia.repositoros.IDocenteRepositorio;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DocenteQueryImplAdapter implements IDocenteQueryRepositoryPort {

    private final IDocenteRepositorio docenteRepositorio;

    private final IDocenteEntityMapper docenteEntityMapper;

    private final IDocenteEagerEntityMapper docenteEagerEntityMapper;

    @Override
    @Transactional(readOnly = true)
    public List<Docente> listarDocentes(String nombreGrupo, String patronApellido) {
        List<DocenteEntity> listaDocentes = docenteRepositorio.findByNombreGrupoAndApellidoStartingWithIgnoreCaseOrderByApellidoAsc(nombreGrupo, patronApellido);
        return docenteEntityMapper.toDomainList(listaDocentes);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existeDocente(Integer idDocente) {
        return docenteRepositorio.existsById(idDocente);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existeDocentePorCorreo(String correo) {
        return docenteRepositorio.existsByCorreo(correo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Docente> listarMiembrosComite() {
        List<DocenteEntity> listaMiembrosComite = docenteRepositorio.findAll();
        return docenteEntityMapper.toDomainList(listaMiembrosComite);
    }

    @Override
    public Docente formatosPorDocente(Integer idDocente) {
        Optional<DocenteEntity> docenteEntity = docenteRepositorio.findById(idDocente);
        if (docenteEntity.isPresent()) {
            return docenteEagerEntityMapper.toDomain(docenteEntity.get());
        } else {
            return null;
        }
    }

    @Override
    public List<Docente> listarDocentesPorIds(List<Integer> idsDocentes) {
        List<DocenteEntity> listaDocentes = docenteRepositorio.findAllById(idsDocentes);
        return listaDocentes.stream()
                .map(docenteEntityMapper::toDomain)
                .toList();
    }
    
}
