package com.unicauca.TallerP2.infraestructura.output.persistencia.repositoros;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unicauca.TallerP2.infraestructura.output.persistencia.entities.EstadoEntity;

public interface IEstadoRepositorio extends JpaRepository<EstadoEntity, Integer> {

    
}
