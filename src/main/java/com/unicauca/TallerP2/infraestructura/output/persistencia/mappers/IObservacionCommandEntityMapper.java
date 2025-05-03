package com.unicauca.TallerP2.infraestructura.output.persistencia.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.unicauca.TallerP2.dominio.Modelos.Observacion;
import com.unicauca.TallerP2.infraestructura.output.persistencia.entities.ObservacionEntity;

@Mapper(componentModel = "spring")
public interface IObservacionCommandEntityMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "objEvaluacion.observacion", ignore = true)
    @Mapping(target = "objEvaluacion.objFormato", ignore = true)
    @Mapping(target = "objDocente.objObservacion", ignore = true)
    @Mapping(target = "objDocente.objFormatoA", ignore = true)
    @Mapping(target = "objDocente.objHistorico", ignore = true)
    Observacion toDomain(ObservacionEntity observacionEntity);
    
    ObservacionEntity toEntity(Observacion observacion);
}
