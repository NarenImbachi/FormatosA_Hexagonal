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
    
    @Column(nullable = false, length = 100)
    private String nombreEstudiante2;

    public FormatoPPAEntity() {
        super();
    }

    public FormatoPPAEntity(String nombreEstudiante1, String nombreEstudiante2) {
        this.nombreEstudiante1 = nombreEstudiante1;
        this.nombreEstudiante2 = nombreEstudiante2;
    }
}