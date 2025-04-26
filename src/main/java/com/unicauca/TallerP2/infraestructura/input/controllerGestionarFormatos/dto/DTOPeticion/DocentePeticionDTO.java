package com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.dto.DTOPeticion;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class DocentePeticionDTO {

    private Integer id;

    private String nombre;

    private String apellido;

    private String correo;

    private String nombreGrupo;
}
