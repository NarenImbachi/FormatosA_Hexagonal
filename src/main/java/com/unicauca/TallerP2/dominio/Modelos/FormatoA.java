package com.unicauca.TallerP2.dominio.Modelos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FormatoA {
    private Integer id;

    private String objetivoGeneral;

    private String titulo;
    
    private String objetivosEspecificos;

    private Estado estado;

    private List<Evaluacion> evaluacion;

    private Docente objDocente;
}
