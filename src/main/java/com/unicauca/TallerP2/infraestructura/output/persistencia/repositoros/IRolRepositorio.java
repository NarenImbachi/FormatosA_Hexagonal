package com.unicauca.TallerP2.infraestructura.output.persistencia.repositoros;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unicauca.TallerP2.infraestructura.output.persistencia.entities.RolEntity;

public interface IRolRepositorio extends JpaRepository<RolEntity, Integer> {
    RolEntity findByNombre(String nombre);
}
