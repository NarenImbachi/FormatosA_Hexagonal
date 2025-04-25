package com.unicauca.TallerP2.dominio.Modelos;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Estado {
    private Integer idEstado;

    private String estadoActual;

    private Date fechaRegistro;

    private FormatoA objFormato;
}
