package com.unicauca.TallerP2.infraestructura.output.persistencia.repositoros;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.unicauca.TallerP2.infraestructura.output.persistencia.entities.FormatoAEntity;

public interface IFormatoRepositorio extends JpaRepository<FormatoAEntity, Integer> {
    Optional<FormatoAEntity> findById(Integer id);
    boolean existsByTitulo(String titulo);
    boolean existsById(Integer id);

    @Query("SELECT f FROM FormatoAEntity f " +
        "JOIN f.estado e " +
        "JOIN f.objDocente d " +
        "WHERE f.titulo = :titulo " +
        "AND e.fechaRegistro >= :fechaInicio " +
        "AND e.fechaRegistro <= :fechaFin")
    FormatoAEntity findByTituloAndFechaInicioAndFechaFin(
        @Param("titulo") String titulo,
        @Param("fechaInicio") Date fechaInicio,
        @Param("fechaFin") Date fechaFin
    );


    
}
