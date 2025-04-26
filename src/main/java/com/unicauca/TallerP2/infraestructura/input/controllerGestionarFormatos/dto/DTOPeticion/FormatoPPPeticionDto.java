package com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.dto.DTOPeticion;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FormatoPPPeticionDto extends  FormatoPeticionDTO{
    
    private String nombreEstudiante1;
    
    private String nombreEstudiante2;

    
    public FormatoPPPeticionDto(String objetivoGeneral, String titulo, String objetivosEspecificos
            , String nombreEstudiante1, String nombreEstudiante2, DocentePeticionDTO docente) {
        super(objetivoGeneral, titulo, objetivosEspecificos, docente);

        this.nombreEstudiante1 = nombreEstudiante1;
        this.nombreEstudiante2 = nombreEstudiante2;
    }

}
