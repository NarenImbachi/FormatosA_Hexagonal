package com.unicauca.TallerP2.dominio.Modelos;


import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Observacion {
    private Integer id;

    private String observacion;
    
    private Date fechaRegistro;
    
    private Evaluacion objEvaluacion;

    private List<Docente> objDocente;
}
