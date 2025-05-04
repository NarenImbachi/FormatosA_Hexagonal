package com.unicauca.TallerP2.infraestructura.output.persistencia.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.unicauca.TallerP2.dominio.Modelos.Evaluacion;
import com.unicauca.TallerP2.infraestructura.output.persistencia.entities.EvaluacionEntity;

@Mapper(componentModel = "spring", uses = { IObservacionEntityMapper.class})
public interface IEvaluacionObservacionEntityMapper {

    @Mapping(target = "objFormato", ignore = true)
    Evaluacion toDomain(EvaluacionEntity evaluacionEntity);


    EvaluacionEntity toEntity(Evaluacion evaluacion);
}
