package com.unicauca.TallerP2.infraestructura.output.persistencia.mappers;

import org.mapstruct.Mapper;

import com.unicauca.TallerP2.dominio.Modelos.Estado;
import com.unicauca.TallerP2.infraestructura.output.persistencia.entities.EstadoEntity;

@Mapper(componentModel = "spring")
public interface IEstadoEntityMapper {

    EstadoEntity toEntity(Estado estado);
}
