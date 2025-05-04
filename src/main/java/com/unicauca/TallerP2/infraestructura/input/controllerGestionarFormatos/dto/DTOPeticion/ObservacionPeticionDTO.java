package com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.dto.DTOPeticion;

import java.util.List;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor

public class ObservacionPeticionDTO {
    @NotBlank(message = "{observacion.descripcion.notblank}")
    private String observacion;

    @NotNull(message = "{observacion.idFormatoA.notnull}")
    @Min(value = 1, message = "{observacion.idFormatoA.min}")
    private Integer idFormatoA;

    @NotEmpty(message = "{observacion.docentesId.notempty}")
    private List<Integer> docentesId;
}
