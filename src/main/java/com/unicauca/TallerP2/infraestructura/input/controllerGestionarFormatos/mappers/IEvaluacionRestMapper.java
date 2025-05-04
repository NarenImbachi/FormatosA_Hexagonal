package com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.unicauca.TallerP2.dominio.Modelos.Evaluacion;
import com.unicauca.TallerP2.dominio.Modelos.Observacion;
import com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.dto.DTORespuesta.EvaluacionRespuestaDTO;
import com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.dto.DTORespuesta.ObservacionesRespuestaDTO;

@Mapper(componentModel = "spring", uses = IDocenteRestMapper.class)
public interface IEvaluacionRestMapper {
    // Convierte una evaluación a su DTO con observaciones y docentes
    @Mapping(source = "nombreCoordinador", target = "nombreCoordinador")
    @Mapping(source = "observacion", target = "observacion")
    EvaluacionRespuestaDTO toDTO(Evaluacion evaluacion);


    // Observaciones asociadas a la evaluación
    @Mapping(source = "objDocente", target = "objDocente")
    ObservacionesRespuestaDTO toObservacionDTO(Observacion observacion);

    List<ObservacionesRespuestaDTO> toObservacionDTOList(List<Observacion> observaciones);

    List<EvaluacionRespuestaDTO> toDTOList(List<Evaluacion> evaluacion);
}
