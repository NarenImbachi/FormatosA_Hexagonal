package com.unicauca.TallerP2.dominio.Modelos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Docente {
    private Integer id;

    private String nombre;

    private String apellido;

    private String correo;

    private String nombreGrupo;

    private List<Observacion> objObservacion;

    private List<FormatoA> objFormatoA;

    private List<Historico> objHistorico;

}
