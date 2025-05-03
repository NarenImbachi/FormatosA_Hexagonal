package com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.dto.DTORespuesta;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ObservacionCommandRespuestaDTO {
    private Integer id;
    private String observacion;
    private Date fechaRegistro;
    private Integer idEvaluacion;
    private List<DocenteObservacionRespuestaDTO> objDocente;
}
