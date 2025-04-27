package com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.dto.DTORespuesta;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class HistoricoRespuestaDTO {
    private Date fechaInicio;
    private Date fechaFin;
    private RolRespuestaDTO objRol;
}
