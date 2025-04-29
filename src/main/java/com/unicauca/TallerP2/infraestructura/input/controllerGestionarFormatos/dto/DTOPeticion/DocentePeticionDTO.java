package com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.dto.DTOPeticion;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DocentePeticionDTO {

    @NotBlank(message = "{docente.nombre.notblank}")
    @Size(min = 1, max = 50, message = "{size.min.to.max}")
    private String nombre;

    @NotBlank(message = "{docente.apellido.notblank}")
    @Size(min = 1, max = 50, message = "{size.min.to.max}")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$", message = "{solo.letras}")
    private String apellido;

    @Email(message = "{docente.correo.email}")
    @Pattern(regexp = "^[A-Za-z0-9]+@unicauca\\.edu\\.co$", message = "{docente.correo.pattern}")
    private String correo;

    @NotBlank(message = "{docente.nombreGrupo.notblank}")
    @Size(min = 1, max = 50, message = "{size.min.to.max}")
    private String nombreGrupo;
}
