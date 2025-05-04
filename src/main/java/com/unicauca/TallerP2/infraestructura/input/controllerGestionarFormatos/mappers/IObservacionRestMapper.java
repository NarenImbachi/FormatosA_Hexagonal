package com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.unicauca.TallerP2.dominio.Modelos.Observacion;
import com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.dto.DTOPeticion.ObservacionPeticionDTO;
import com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.dto.DTORespuesta.ObservacionCommandRespuestaDTO;

@Mapper(componentModel = "spring", uses = {IDocenteObservacionRestMapper.class})
public interface IObservacionRestMapper {
    @Mapping(target = "idEvaluacion", source = "objEvaluacion.id")
    @Mapping(target = "objDocente", source = "objDocente") 
    ObservacionCommandRespuestaDTO toDTO(Observacion observacion);

    @Mapping(target = "id" , ignore = true)
    @Mapping(target = "fechaRegistro", ignore = true)
    @Mapping(target = "objEvaluacion", ignore = true)
    @Mapping(target = "objDocente", ignore = true)
    Observacion toDomain(ObservacionPeticionDTO observacionPeticionDTO);
}
