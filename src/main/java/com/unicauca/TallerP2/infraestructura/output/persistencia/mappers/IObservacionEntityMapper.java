package com.unicauca.TallerP2.infraestructura.output.persistencia.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.unicauca.TallerP2.dominio.Modelos.Observacion;
import com.unicauca.TallerP2.infraestructura.output.persistencia.entities.ObservacionEntity;

@Mapper(componentModel = "spring", uses = { IDocenteEntityMapper.class})
public interface IObservacionEntityMapper {

    @Mapping(target = "objEvaluacion", ignore = true)
    Observacion toDomain(ObservacionEntity observacionEntity);
      
    ObservacionEntity toEntity(Observacion observacion);
}
