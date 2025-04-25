package com.unicauca.TallerP2.infraestructura.output.persistencia.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "observaciones")
public class ObservacionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 500)
    private String observacion;
    
    @Column(nullable = false)
    private Date fechaRegistro;
    
    @ManyToOne
    @JoinColumn(name = "idEvaluacion", nullable = false)
    private EvaluacionEntity objEvaluacion;

    @ManyToMany(fetch = FetchType.EAGER )
    @JoinTable(
        name = "Observacion_Docente", 
        joinColumns = @JoinColumn(name = "idObservacion", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "idDocente", referencedColumnName = "id")
    )
    private List<DocenteEntity> objDocente;
}

