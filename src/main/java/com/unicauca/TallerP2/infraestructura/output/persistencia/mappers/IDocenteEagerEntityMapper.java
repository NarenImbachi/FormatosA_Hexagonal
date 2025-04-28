package com.unicauca.TallerP2.infraestructura.output.persistencia.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.unicauca.TallerP2.dominio.Modelos.Docente;
import com.unicauca.TallerP2.infraestructura.output.persistencia.entities.DocenteEntity;

@Mapper(componentModel = "spring", uses = {IFormatoEagerEntityMapper.class})
public interface IDocenteEagerEntityMapper {
    @Mapping(target = "objObservacion", ignore = true)
    @Mapping(target = "objHistorico", ignore = true)
    Docente toDomain(DocenteEntity docenteEntity);
}
