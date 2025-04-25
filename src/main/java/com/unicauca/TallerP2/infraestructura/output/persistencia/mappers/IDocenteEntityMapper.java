package com.unicauca.TallerP2.infraestructura.output.persistencia.mappers;

import org.mapstruct.Mapper;

import com.unicauca.TallerP2.dominio.Modelos.Docente;
import com.unicauca.TallerP2.infraestructura.output.persistencia.entities.DocenteEntity;

@Mapper(componentModel = "spring")
public interface IDocenteEntityMapper {
    Docente toDomain(DocenteEntity docenteEntity);
    DocenteEntity toEntity(Docente docente);
}
