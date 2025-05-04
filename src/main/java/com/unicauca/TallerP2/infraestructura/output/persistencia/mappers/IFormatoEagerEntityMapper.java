package com.unicauca.TallerP2.infraestructura.output.persistencia.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.SubclassMapping;

import com.unicauca.TallerP2.dominio.Modelos.FormatoA;
import com.unicauca.TallerP2.dominio.Modelos.FormatoPPA;
import com.unicauca.TallerP2.dominio.Modelos.FormatoTIA;
import com.unicauca.TallerP2.infraestructura.output.persistencia.entities.FormatoAEntity;
import com.unicauca.TallerP2.infraestructura.output.persistencia.entities.FormatoPPAEntity;
import com.unicauca.TallerP2.infraestructura.output.persistencia.entities.FormatoTIAEntity;

@Mapper(componentModel = "spring", uses = { IEstadoEntityMapper.class, IEvaluacionEntityMapper.class , IObservacionEntityMapper.class })
public interface IFormatoEagerEntityMapper {

    @SubclassMapping(source = FormatoPPAEntity.class, target = FormatoPPA.class)
    @SubclassMapping(source = FormatoTIAEntity.class, target = FormatoTIA.class)
    @Mapping(target = "objDocente", ignore = true)
    @Mapping(target = "estado.objFormato", ignore = true)
    //@Mapping(target = "evaluacion", ignore = true) // Lazzy
    FormatoA toDomain(FormatoAEntity formatoAEntity);

}
