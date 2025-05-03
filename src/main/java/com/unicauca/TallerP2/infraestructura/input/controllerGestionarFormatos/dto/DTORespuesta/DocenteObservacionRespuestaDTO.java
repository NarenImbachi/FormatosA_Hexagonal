package com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.dto.DTORespuesta;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class DocenteObservacionRespuestaDTO {
    private Integer id;
    private String correo;
}
