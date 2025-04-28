package com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.dto.DTOPeticion;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DocentePeticionDTO {

    private Integer id;

    @NotBlank(message = "{docente.nombre.notblank}")
    private String nombre;

    @NotBlank(message = "{docente.apellido.notblank}")
    private String apellido;

    @Email(message = "{docente.correo.email}")
    private String correo;

    @NotBlank(message = "{docente.nombreGrupo.notblank}")
    private String nombreGrupo;
}
