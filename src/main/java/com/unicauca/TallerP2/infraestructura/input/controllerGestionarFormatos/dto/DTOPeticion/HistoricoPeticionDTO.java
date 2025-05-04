package com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.dto.DTOPeticion;
 
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class HistoricoPeticionDTO {

    boolean estado;
    Date fechaInicio;
    Date fechaFin;
    RolPeticionDTO objRol;
}