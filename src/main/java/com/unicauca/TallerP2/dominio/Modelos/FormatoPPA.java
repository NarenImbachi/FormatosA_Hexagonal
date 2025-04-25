package com.unicauca.TallerP2.dominio.Modelos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FormatoPPA extends FormatoA {
    private String nombreEstudiante1;
    
    private String nombreEstudiante2;

    public FormatoPPA() {
        super();
    }

    public FormatoPPA(String nombreEstudiante1, String nombreEstudiante2) {
        this.nombreEstudiante1 = nombreEstudiante1;
        this.nombreEstudiante2 = nombreEstudiante2;
    }
}
