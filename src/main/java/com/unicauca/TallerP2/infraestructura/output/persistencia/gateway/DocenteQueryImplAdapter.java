package com.unicauca.TallerP2.infraestructura.output.persistencia.gateway;

import java.util.List;

import org.springframework.stereotype.Component;

import com.unicauca.TallerP2.aplicacion.output.IDocenteQueryRepositoryPort;
import com.unicauca.TallerP2.dominio.Modelos.Docente;
import com.unicauca.TallerP2.infraestructura.output.persistencia.entities.DocenteEntity;
import com.unicauca.TallerP2.infraestructura.output.persistencia.mappers.IDocenteEntityMapper;
import com.unicauca.TallerP2.infraestructura.output.persistencia.repositoros.IDocenteRepositorio;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DocenteQueryImplAdapter implements IDocenteQueryRepositoryPort {

    private final IDocenteRepositorio docenteRepositorio;

    private final IDocenteEntityMapper docenteEntityMapper;

    @Override
    public List<Docente> listarDocentes() {
        List<DocenteEntity> listaDocentes = docenteRepositorio.findAll();
        return listaDocentes.stream()
                .map(docenteEntityMapper::toDomain)
                .toList();
    }

    @Override
    public boolean existeDocente(Integer idDocente) {
        return docenteRepositorio.existsById(idDocente);
    }
    
}
