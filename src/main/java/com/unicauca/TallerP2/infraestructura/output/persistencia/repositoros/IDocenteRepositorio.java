package com.unicauca.TallerP2.infraestructura.output.persistencia.repositoros;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.unicauca.TallerP2.infraestructura.output.persistencia.entities.DocenteEntity;

public interface IDocenteRepositorio extends JpaRepository<DocenteEntity, Integer> {

    @Query("SELECT CASE WHEN COUNT(d) > 0 THEN true ELSE false END FROM DocenteEntity d WHERE d.correo = :correo")
    boolean existsByCorreo(@Param("correo") String correo);

    /*
     * listar docentes, ordenados ascendentemente por el campo apellido
     * OrderByApellidoAsc
     * ignorando mayúsculas y minúsculas
     * IgnoreCase
     * los cuales pertenezcan a un grupo (nombre_grupo) en particular
     * findByNombreGrupo
     * y que comiencen por un patrón de búsqueda.
     * StartingWith
     */
    List<DocenteEntity> findByNombreGrupoAndApellidoStartingWithIgnoreCaseOrderByApellidoAsc(String nombreGrupo, String patronApellido);

    boolean existsById(Integer idDocente);
}
