package com.unicauca.TallerP2.infraestructura.output.persistencia.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "docentes")
public class DocenteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 100)
    private String apellido;

    @Column(nullable = false, length = 100, unique = true)
    private String correo;

    @Column(nullable = false, length = 50)
    private String nombreGrupo;

    @ManyToMany(mappedBy = "objDocente", fetch = FetchType.LAZY)
    private List<ObservacionEntity> objObservacion;

    @OneToMany( mappedBy = "objDocente", fetch = FetchType.EAGER)
    private List<FormatoAEntity> objFormatoA;

    @OneToMany( mappedBy = "objDocente", fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST})
    private List<HistoricoEntity> objHistorico;

}
