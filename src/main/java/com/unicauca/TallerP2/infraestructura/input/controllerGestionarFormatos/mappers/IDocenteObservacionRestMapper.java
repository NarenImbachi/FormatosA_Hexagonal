package com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.unicauca.TallerP2.dominio.Modelos.Docente;
import com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.dto.DTOPeticion.DocentePeticionDTO;
import com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.dto.DTORespuesta.DocenteObservacionRespuestaDTO;
import com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.dto.DTORespuesta.DocenteRespuestaDTO;

@Mapper(componentModel = "spring")
public interface IDocenteObservacionRestMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "objObservacion", ignore = true)
    @Mapping(target = "objFormatoA", ignore = true)
    @Mapping(target = "objHistorico", ignore = true)
    Docente toModel (DocentePeticionDTO docentePeticionDTO);

    DocenteRespuestaDTO toDTO (Docente docente);

    @Mapping(target = "correo", source = "correo")
    @Mapping(target = "id", source = "id")
    DocenteObservacionRespuestaDTO toDocenteObservacionDTO (Docente docente);
}
