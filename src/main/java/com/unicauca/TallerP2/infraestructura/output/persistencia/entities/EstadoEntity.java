package com.unicauca.TallerP2.infraestructura.output.persistencia.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "estados")
public class EstadoEntity {
    @Id
    private Integer idEstado;

    @Column(nullable = false, length = 50)
    private String estadoActual;

    @Column(nullable = false)
    private Date fechaRegistro;

    @OneToOne
    @MapsId
    @JoinColumn(name = "idFormatoA", referencedColumnName = "id", unique = true)
    private FormatoAEntity objFormato;
}
