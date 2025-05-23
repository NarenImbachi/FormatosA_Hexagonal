package com.unicauca.TallerP2.infraestructura.output.persistencia.repositoros;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.unicauca.TallerP2.infraestructura.output.persistencia.entities.EvaluacionEntity;
import com.unicauca.TallerP2.infraestructura.output.persistencia.entities.FormatoAEntity;

public interface IFormatoRepositorio extends JpaRepository<FormatoAEntity, Integer> {
    Optional<FormatoAEntity> findById(Integer id);

    @Query(value = """
        SELECT CASE WHEN COUNT(*) > 0 THEN true ELSE false END FROM (
            SELECT titulo FROM formatosPPA WHERE titulo = :titulo
            UNION
            SELECT titulo FROM formatosTIA WHERE titulo = :titulo
        ) AS sub
        """, nativeQuery = true)
    int existsByTitulo(@Param("titulo") String titulo);
    
    boolean existsById(Integer id);

    @Query("SELECT f FROM FormatoAEntity f " +
        "JOIN f.estado e " +
        "JOIN f.objDocente d " +
        "WHERE d.correo = :correo " +
        "AND e.fechaRegistro >= :fechaInicio " +
        "AND e.fechaRegistro <= :fechaFin")
    List<FormatoAEntity> findByTituloAndFechaInicioAndFechaFin(
        @Param("correo") String correo,
        @Param("fechaInicio") Date fechaInicio,
        @Param("fechaFin") Date fechaFin
    );

    @Query(value = "SELECT e FROM EvaluacionEntity e WHERE e.objFormato.id = :idFormatoA ORDER BY e.fechaRegistroConcepto DESC")
    Optional<EvaluacionEntity> obtenerUltimaEvaluacionPorFormatoA(@Param("idFormatoA") Integer idFormatoA);
    
}
