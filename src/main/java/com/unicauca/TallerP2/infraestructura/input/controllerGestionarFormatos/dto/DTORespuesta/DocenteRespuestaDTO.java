package com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.dto.DTORespuesta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DocenteRespuestaDTO {
    private String nombre;

    private String apellido;

    private String correo;

    private String nombreGrupo;
}
