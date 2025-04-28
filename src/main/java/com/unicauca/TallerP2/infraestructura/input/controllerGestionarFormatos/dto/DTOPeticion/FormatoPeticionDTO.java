package com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.dto.DTOPeticion;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "tipoFormato")
@JsonSubTypes({
    @JsonSubTypes.Type(value = FormatoTIPeticionDto.class, name = "TI"),
    @JsonSubTypes.Type(value = FormatoPPPeticionDto.class, name = "PP")
})
public class FormatoPeticionDTO {
    
    private String objetivoGeneral;

    private String titulo;
    
    private List<String> objetivosEspecificos;

    private DocentePeticionDTO objDocente;
}
