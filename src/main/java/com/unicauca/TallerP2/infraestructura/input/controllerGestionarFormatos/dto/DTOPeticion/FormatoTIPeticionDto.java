package com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.dto.DTOPeticion;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FormatoTIPeticionDto extends FormatoPeticionDTO {
    private String nombreAsesor;

    private String nombreEstudiante1;
    
    private String rutaCA;

    public FormatoTIPeticionDto(String objetivoGeneral, String titulo, String objetivosEspecificos,
            String nombreAsesor, String nombreEstudiante1, String rutaCA, DocentePeticionDTO docente) {
        super(objetivoGeneral, titulo, objetivosEspecificos, docente);
        this.nombreAsesor = nombreAsesor;
        this.nombreEstudiante1 = nombreEstudiante1;
        this.rutaCA = rutaCA;
    }
     
}
