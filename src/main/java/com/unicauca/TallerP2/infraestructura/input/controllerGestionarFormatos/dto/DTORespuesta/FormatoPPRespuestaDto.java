package com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.dto.DTORespuesta;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FormatoPPRespuestaDto extends  FormatoRespuestaDTO{
    
    private String nombreEstudiante1;
    
    private String nombreEstudiante2;

    
    public FormatoPPRespuestaDto(String objetivoGeneral, String titulo, String objetivosEspecificos,
            EstadoRespuestaDTO estado, DocenteRespuestaDTO objDocente,String nombreEstudiante1, String nombreEstudiante2) {
        super(objetivoGeneral, titulo, objetivosEspecificos, estado, objDocente);

        this.nombreEstudiante1 = nombreEstudiante1;
        this.nombreEstudiante2 = nombreEstudiante2;
    }

}
