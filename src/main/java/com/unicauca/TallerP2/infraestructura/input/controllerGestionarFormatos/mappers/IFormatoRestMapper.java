package com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.SubclassMapping;

import com.unicauca.TallerP2.dominio.Modelos.FormatoA;
import com.unicauca.TallerP2.dominio.Modelos.FormatoPPA;
import com.unicauca.TallerP2.dominio.Modelos.FormatoTIA;
import com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.dto.DTOPeticion.FormatoPPPeticionDto;
import com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.dto.DTOPeticion.FormatoPeticionDTO;
import com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.dto.DTOPeticion.FormatoTIPeticionDto;
import com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.dto.DTORespuesta.FormatoPPRespuestaDto;
import com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.dto.DTORespuesta.FormatoRespuestaDTO;
import com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.dto.DTORespuesta.FormatoTIRespuestaDto;

@Mapper(componentModel = "spring", uses = IDocenteRestMapper.class)
public interface IFormatoRestMapper {

    @SubclassMapping(source = FormatoPPPeticionDto.class, target = FormatoPPA.class)
    @SubclassMapping(source = FormatoTIPeticionDto.class, target = FormatoTIA.class)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "estado", ignore = true)
    @Mapping(target = "evaluacion", ignore = true)
    FormatoA toModel(FormatoPeticionDTO formatoPeticionDTO);

    @SubclassMapping(source = FormatoPPA.class, target = FormatoPPRespuestaDto.class)
    @SubclassMapping(source = FormatoTIA.class, target = FormatoTIRespuestaDto.class)
    FormatoRespuestaDTO toDTO(FormatoA formatoA);

    List<FormatoRespuestaDTO> toDTOList(List<FormatoA> formatoAList);
}
