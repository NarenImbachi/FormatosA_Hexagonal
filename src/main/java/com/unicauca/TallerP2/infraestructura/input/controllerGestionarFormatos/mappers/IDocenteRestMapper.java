package com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.unicauca.TallerP2.dominio.Modelos.Docente;
import com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.dto.DTOPeticion.DocentePeticionDTO;
import com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.dto.DTORespuesta.DocenteComiteRespuestaDTO;
import com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.dto.DTORespuesta.DocenteRespuestaDTO;
import com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.dto.DTORespuesta.FormatosDocenteResponseDTO;

@Mapper(componentModel = "spring")
public interface IDocenteRestMapper {

    @Mapping(target = "objObservacion", ignore = true)
    @Mapping(target = "objFormatoA", ignore = true)
    @Mapping(target = "objHistorico", ignore = true)
    Docente toModel (DocentePeticionDTO docentePeticionDTO);

    DocenteRespuestaDTO toDTO (Docente docente);

    List<DocenteRespuestaDTO> toDTOList (List<Docente> docente);

    List<DocenteComiteRespuestaDTO> toDTOListComite (List<Docente> docentes);

    FormatosDocenteResponseDTO toFormatosDocenteResponseDTO(Docente docente);
}
