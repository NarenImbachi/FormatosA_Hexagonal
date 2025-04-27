package com.unicauca.TallerP2.infraestructura.output.persistencia.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "historicos")
public class HistoricoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private boolean estado;
    
    @Column(nullable = false)
    private Date fechaInicio;

    @Column
    private Date fechaFin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( name =  "idDocente", referencedColumnName = "id" )
    private DocenteEntity objDocente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( name =  "idRol", referencedColumnName = "id" )
    private RolEntity objRol;
}
