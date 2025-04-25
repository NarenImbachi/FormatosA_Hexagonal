package com.unicauca.TallerP2.infraestructura.output.persistencia.repositoros;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.unicauca.TallerP2.infraestructura.output.persistencia.entities.DocenteEntity;

public interface IDocenteRepositorio extends JpaRepository<DocenteEntity, Integer> {

    @Query("SELECT d FROM DocenteEntity d WHERE d.correo = :correo")
    DocenteEntity findByCorreo(@Param("correo") String correo);

    boolean existsById(Integer idDocente);
}
