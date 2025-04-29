package com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.dto.DTOPeticion;

import java.util.List;

import com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.validaciones.Estudiante2Valido;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Estudiante2Valido
public class FormatoPPPeticionDto extends  FormatoPeticionDTO{
    
    @NotBlank(message = "{formato.nombreEstudiante1.notblank}")
    private String nombreEstudiante1;

    @NotBlank(message = "{formato.codigoEstudiante.notblank}")
    @Pattern(regexp = "^\\d+$", message = "{solo.numeros}")
    private String codigoEstudiante1;
    
    private String nombreEstudiante2;

    private String codigoEstudiante2;

    
    public FormatoPPPeticionDto(String objetivoGeneral, String titulo, List<String> objetivosEspecificos
            , String nombreEstudiante1, String codigoEstudiante1,String nombreEstudiante2, String codigoEstudiante2 ,DocentePeticionDTO docente) {
        super(objetivoGeneral, titulo,  objetivosEspecificos, docente);

        this.nombreEstudiante1 = nombreEstudiante1;
        this.nombreEstudiante2 = nombreEstudiante2;
        this.codigoEstudiante1 = codigoEstudiante1;
        this.codigoEstudiante2 = codigoEstudiante2;
    }

}
