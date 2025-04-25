package com.unicauca.TallerP2.dominio.Modelos;


import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Evaluacion {
  
    private Integer id;

    private String concepto;

    private Date fechaRegistroConcepto;

    private String nombreCoordinador;

    private List<Observacion> observacion;

    private FormatoA objFormato;
}
