package com.unicauca.TallerP2.infraestructura.output.persistencia.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.unicauca.TallerP2.dominio.Modelos.Docente;
import com.unicauca.TallerP2.infraestructura.output.persistencia.entities.DocenteEntity;

@Mapper(componentModel = "spring", uses = {IHistoricoEntityMapper.class})
public interface IDocenteEntityMapper {

    @Mapping(target = "objObservacion", ignore = true)
    @Mapping(target = "objFormatoA", ignore = true)
    @Mapping(target = "objHistorico", ignore = true)
    Docente toDomain(DocenteEntity docenteEntity);

    DocenteEntity toEntity(Docente docente);

    @Mapping(target = "objObservacion", ignore = true)
    @Mapping(target = "objFormatoA", ignore = true)
    Docente toDomainLazyrole(DocenteEntity docenteEntity);

}
