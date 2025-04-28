package com.unicauca.TallerP2.infraestructura.output.persistencia.mappers;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.unicauca.TallerP2.dominio.Modelos.Docente;
import com.unicauca.TallerP2.infraestructura.output.persistencia.entities.DocenteEntity;

@Mapper(componentModel = "spring", uses = {IHistoricoEntityMapper.class})
public interface IDocenteEntityMapper {

    @Named("toDomain")
    @Mapping(target = "objObservacion", ignore = true)
    @Mapping(target = "objFormatoA", ignore = true)
    @Mapping(target = "objHistorico", ignore = true)
    Docente toDomain(DocenteEntity docenteEntity);

    DocenteEntity toEntity(Docente docente);

    @Mapping(target = "objObservacion", ignore = true)
    @Mapping(target = "objFormatoA", ignore = true)
    Docente toDomainLazyrole(DocenteEntity docenteEntity);

    @IterableMapping(qualifiedByName = "toDomain")
    List<Docente> toDomainList(List<DocenteEntity> listaDocenteEntity);
}
