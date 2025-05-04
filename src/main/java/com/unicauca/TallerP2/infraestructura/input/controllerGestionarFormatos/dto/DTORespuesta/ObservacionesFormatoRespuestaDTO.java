package com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.dto.DTORespuesta;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ObservacionesFormatoRespuestaDTO {
    private Integer id;
    private String objetivoGeneral;
    private String titulo;
    private List<String> objetivosEspecificos;
    private EstadoRespuestaDTO estado;
    private List<EvaluacionRespuestaDTO> evaluacion;
}
