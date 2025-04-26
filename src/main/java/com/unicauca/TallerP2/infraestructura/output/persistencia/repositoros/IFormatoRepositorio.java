package com.unicauca.TallerP2.infraestructura.output.persistencia.repositoros;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unicauca.TallerP2.infraestructura.output.persistencia.entities.FormatoAEntity;

public interface IFormatoRepositorio extends JpaRepository<FormatoAEntity, Integer> {
    Optional<FormatoAEntity> findById(Integer id);
    boolean existsByTitulo(String titulo);
    boolean existsById(Integer id);

}
