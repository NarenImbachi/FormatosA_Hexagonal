package com.unicauca.TallerP2.dominio.Modelos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FormatoTIA extends FormatoA {
    private String nombreAsesor;

    private String nombreEstudiante1;

    private String codigoEstudiante1;
    
    private String rutaCA;

    public FormatoTIA() {
        super();
    }

    public FormatoTIA(String nombreAsesor, String nombreEstudiante1, String codigoEstudiante1, String rutaCA) {
        this.nombreAsesor = nombreAsesor;
        this.nombreEstudiante1 = nombreEstudiante1;
        this.codigoEstudiante1 = codigoEstudiante1;
        this.rutaCA = rutaCA;
    }
}
