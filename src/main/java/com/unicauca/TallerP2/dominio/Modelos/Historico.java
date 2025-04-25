package com.unicauca.TallerP2.dominio.Modelos;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Historico {
    private Integer id;

    private boolean estado;
    
    private Date fechaInicio;

    private Docente objDocente;

    private Rol objRol;
}
