package com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.dto.DTORespuesta;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DocenteComiteRespuestaDTO {
    private Integer id;

    private String nombre;

    private String apellido;

    private String correo;

    private String nombreGrupo;

    private List<HistoricoRespuestaDTO> objHistorico;
}
