package com.unicauca.TallerP2.infraestructura.output.persistencia.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.unicauca.TallerP2.dominio.Modelos.Historico;
import com.unicauca.TallerP2.infraestructura.output.persistencia.entities.HistoricoEntity;

@Mapper(componentModel = "spring")
public interface IHistoricoEntityMapper {
    
    //@Mapping(target = "objRol.objHistorico", ignore = true) // Eager
    //@Mapping(target = "objRol", ignore = true) // Lazy
    @Mapping(target = "objDocente", ignore = true)
    Historico toDomain(HistoricoEntity historicoEntity);
    
    @Mapping(target = "objRol", ignore = true)
    @Mapping(target = "objDocente", ignore = true)
    HistoricoEntity toEntity(Historico historico);
}
