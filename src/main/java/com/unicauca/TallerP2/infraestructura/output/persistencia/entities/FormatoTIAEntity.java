package com.unicauca.TallerP2.infraestructura.output.persistencia.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "formatosTIA")
public class FormatoTIAEntity extends FormatoAEntity {
    @Column(nullable = false, length = 100)
    private String nombreAsesor;

    @Column(nullable = false, length = 100)
    private String nombreEstudiante1;

    @Column(nullable = false, length = 12)
    private String codigoEstudiante1;
    
    @Column(nullable = false, length = 100)
    private String rutaCA;

    public FormatoTIAEntity() {
        super();
    }

    public FormatoTIAEntity(String nombreAsesor, String nombreEstudiante1,  String codigoEstudiante1, String rutaCA) {
        this.nombreAsesor = nombreAsesor;
        this.nombreEstudiante1 = nombreEstudiante1;
        this.codigoEstudiante1 = codigoEstudiante1;
        this.rutaCA = rutaCA;
    }
}
