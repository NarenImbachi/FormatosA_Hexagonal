package com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.dto.DTORespuesta;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FormatoTIRespuestaDto extends FormatoRespuestaDTO {
    private String nombreAsesor;

    private String nombreEstudiante1;
    
    private String rutaCA;

    public FormatoTIRespuestaDto(String objetivoGeneral, String titulo, String objetivosEspecificos,
            EstadoRespuestaDTO estado, String nombreAsesor, String nombreEstudiante1, String rutaCA) {
        super(objetivoGeneral, titulo, objetivosEspecificos, estado);
        this.nombreAsesor = nombreAsesor;
        this.nombreEstudiante1 = nombreEstudiante1;
        this.rutaCA = rutaCA;
    }
     
}
