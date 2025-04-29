package com.unicauca.TallerP2.infraestructura.output.persistencia.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "formatosPPA")
public class FormatoPPAEntity extends FormatoAEntity {
    @Column(nullable = false, length = 100)
    private String nombreEstudiante1;

    @Column(nullable = false, length = 12)
    private String codigoEstudiante1;
    
    @Column(nullable = false, length = 100)
    private String nombreEstudiante2;

    @Column(nullable = false, length = 12)
    private String codigoEstudiante2;

    public FormatoPPAEntity() {
        super();
    }

    public FormatoPPAEntity(String nombreEstudiante1, String nombreEstudiante2,
            String codigoEstudiante1, String codigoEstudiante2) {
        this.nombreEstudiante1 = nombreEstudiante1;
        this.nombreEstudiante2 = nombreEstudiante2;
        this.codigoEstudiante1 = codigoEstudiante1;
        this.codigoEstudiante2 = codigoEstudiante2;
    }
    
}