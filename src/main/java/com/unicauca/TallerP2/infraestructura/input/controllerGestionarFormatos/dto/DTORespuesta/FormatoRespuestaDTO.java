package com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.dto.DTORespuesta;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FormatoRespuestaDTO {
    
    private String objetivoGeneral;

    private String titulo;
    
    private String objetivosEspecificos;

    private EstadoRespuestaDTO estado;
}
