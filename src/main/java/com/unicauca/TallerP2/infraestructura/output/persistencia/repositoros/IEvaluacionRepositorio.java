package com.unicauca.TallerP2.infraestructura.output.persistencia.repositoros;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unicauca.TallerP2.infraestructura.output.persistencia.entities.EvaluacionEntity;

public interface IEvaluacionRepositorio extends JpaRepository<EvaluacionEntity, Integer>{
    
}
