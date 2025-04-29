package com.unicauca.TallerP2.dominio.Modelos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FormatoPPA extends FormatoA {
    private String nombreEstudiante1;

    private String codigoEstudiante1;
    
    private String nombreEstudiante2;

    private String codigoEstudiante2;

    public FormatoPPA() {
        super();
    }

    public FormatoPPA(String nombreEstudiante1, String nombreEstudiante2, String codigoEstudiante1,String codigoEstudiante2) {
        this.nombreEstudiante1 = nombreEstudiante1;
        this.nombreEstudiante2 = nombreEstudiante2;
        this.codigoEstudiante1 = codigoEstudiante1;
        this.codigoEstudiante2 = codigoEstudiante2;
    }
}
