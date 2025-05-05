package com.unicauca.TallerP2.infraestructura.output.persistencia.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "formatosA")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class FormatoAEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable = false)
    private String objetivoGeneral;

    @Column(nullable = false, unique = true)
    private String titulo;
    
    @Column(nullable = false)
    private List<String> objetivosEspecificos;

    @OneToOne(mappedBy = "objFormato", cascade = {CascadeType.PERSIST}, optional = false)
    private EstadoEntity estado;

    @OneToMany(mappedBy = "objFormato", fetch = FetchType.EAGER)
    private List<EvaluacionEntity> evaluacion;

    @ManyToOne(cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinColumn(name = "idDocente", nullable = false)
    private DocenteEntity objDocente;
}
