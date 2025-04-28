package com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.dto.DTORespuesta;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EvaluacionRespuestaDTO {
    private Integer id;

    private String concepto;

    private Date fechaRegistroConcepto;

    private String nombreCoordinador;

    private List<ObservacionnRespuestaDto> observacion;

}
