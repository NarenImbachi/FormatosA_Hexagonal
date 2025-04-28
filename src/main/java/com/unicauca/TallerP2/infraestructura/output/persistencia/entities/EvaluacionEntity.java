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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "evaluaciones")
public class EvaluacionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = true)
    private String concepto;

    @Column(nullable = true)
    private Date fechaRegistroConcepto;

    @Column(nullable = true)
    private String nombreCoordinador;

    @OneToMany(mappedBy = "objEvaluacion", fetch = FetchType.EAGER)
    private List<ObservacionEntity> observacion;

    @ManyToOne
    @JoinColumn(name = "idFormato")
    private FormatoAEntity objFormato;
}

