package com.unicauca.TallerP2.infraestructura.output.persistencia.repositoros;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unicauca.TallerP2.infraestructura.output.persistencia.entities.HistoricoEntity;

public interface IHistoricoRepositorio extends JpaRepository<HistoricoEntity, Integer> {
    
}
